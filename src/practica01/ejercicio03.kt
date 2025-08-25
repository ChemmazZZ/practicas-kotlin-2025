package practica01

fun suma(a: Double, b: Double) = a + b
fun resta(a: Double, b: Double) = a - b
fun multiplicacion(a: Double, b: Double) = a * b
fun division(a: Double, b: Double): Double? = if (b != 0.0) a / b else null

fun main() {
    while (true) {
        println("\n==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Seleccione una opción: ")

        when (readln()) {
            "1" -> {
                print("Ingrese el primer número: ")
                val a = readln().toDouble()
                print("Ingrese el segundo número: ")
                val b = readln().toDouble()
                println("Resultado: ${suma(a, b)}")
            }
            "2" -> {
                print("Ingrese el primer número: ")
                val a = readln().toDouble()
                print("Ingrese el segundo número: ")
                val b = readln().toDouble()
                println("Resultado: ${resta(a, b)}")
            }
            "3" -> {
                print("Ingrese el primer número: ")
                val a = readln().toDouble()
                print("Ingrese el segundo número: ")
                val b = readln().toDouble()
                println("Resultado: ${multiplicacion(a, b)}")
            }
            "4" -> {
                print("Ingrese el primer número: ")
                val a = readln().toDouble()
                print("Ingrese el segundo número: ")
                val b = readln().toDouble()
                val resultado = division(a, b)
                if (resultado != null) {
                    println("Resultado: $resultado")
                } else {
                    println("Error: División entre cero")
                }
            }
            "5" -> {
                println("Saliendo...")
                break
            }
            else -> println("Opción inválida, intente de nuevo.")
        }
    }
}
