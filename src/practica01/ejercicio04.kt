package practica01

fun main() {
    val numeroSecreto = (1..30).random()
    var intentos = 5
    var adivinado = false

    println("🎲 Bienvenido al juego Adivina el Número (1 al 30)")
    println("Tienes $intentos intentos para adivinarlo.")

    while (intentos > 0) {
        print("Ingresa tu número: ")
        val intento = readln().toInt()
        if (intento == numeroSecreto) {
            println("🎉 ¡Felicidades! Adivinaste el número.")
            adivinado = true
            break
        } else if (intento < numeroSecreto) {
            println("El número secreto es mayor.")
        } else {
            println("El número secreto es menor.")
        }
        intentos--
        println("Te quedan $intentos intentos.")
    }

    if (!adivinado) {
        println("💀 Game Over. El número era: $numeroSecreto")
    }
}
