/**
 * Ejercicio 02 - Clase Producto
 * Diseña una clase Producto con precio y descuento aplicable.
 * Implementa metodos set y get y un metodo para calcular el precio final.
 *
 * Autor: Jose Maria Mamani Zuniga
 * Fecha de creación: 2025-08-31
 * Última modificación: 2025-08-31
 */
class Producto(private var precio: Double, private var descuento: Double) {

    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) precio = nuevoPrecio else println("Precio invalido.")
    }

    fun getPrecio(): Double = precio

    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) descuento = nuevoDescuento else println("Descuento invalido.")
    }

    fun getDescuento(): Double = descuento

    fun calcularPrecioFinal(): Double {
        return precio - (precio * (descuento / 100))
    }
}

fun main() {
    val producto = Producto(200.0, 10.0)
    println("Precio final: $${producto.calcularPrecioFinal()}")
    producto.setDescuento(50.0)
    println("Precio final con 50%: $${producto.calcularPrecioFinal()}")
}
