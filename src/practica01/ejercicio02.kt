package practica01

fun obtenerOpcionComputadora(): String {
    val opciones = listOf("piedra", "papel", "tijera")
    return opciones.random()
}

fun determinarGanador(usuario: String, computadora: String): String {
    return if (usuario == computadora) {
        "Empate"
    } else if (
        (usuario == "piedra" && computadora == "tijera") ||
        (usuario == "papel" && computadora == "piedra") ||
        (usuario == "tijera" && computadora == "papel")
    ) {
        "Ganaste"
    } else {
        "Perdiste"
    }
}

fun main() {
    print("Elige piedra, papel o tijera: ")
    val usuario = readln().lowercase()
    val computadora = obtenerOpcionComputadora()

    println("La computadora eligió: $computadora")
    println(determinarGanador(usuario, computadora))
}
