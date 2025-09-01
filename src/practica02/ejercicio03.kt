/**
 * Ejercicio 03 - Figuras (Shape)
 * Clase abstracta con área y perimetro.
 * Subclases: Cuadrado, Círculo y Rectangulo.
 *
 * Autor: Jose Maria Mamani Zuniga
 * Fecha de creación: 2025-08-31
 * Última modificación: 2025-08-31
 */
abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Area: ${calcularArea()}")
        println("Perimetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

class Rectangulo(private val base: Double, private val altura: Double) : Shape() {
    override fun calcularArea() = base * altura
    override fun calcularPerimetro() = 2 * (base + altura)
}

fun main() {
    val cuadrado = Cuadrado(4.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(5.0, 2.0)

    println("Cuadrado:")
    cuadrado.imprimirResultados()

    println("\nCírculo:")
    circulo.imprimirResultados()

    println("\nRectangulo:")
    rectangulo.imprimirResultados()
}
