package practica01

fun nivelRendimiento(puntos: Int): String {
    return when (puntos) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularDinero(salario: Double, puntos: Int): Double {
    return salario * (puntos / 10.0)
}

fun main() {
    print("Ingrese su salario mensual: ")
    val salario = readln().toDouble()
    print("Ingrese su puntuación (0 a 10): ")
    val puntos = readln().toInt()

    val nivel = nivelRendimiento(puntos)
    val dinero = calcularDinero(salario, puntos)

    println("Nivel de Rendimiento: $nivel")
    println("Cantidad de Dinero Recibido: $${"%.2f".format(dinero)}")
}
