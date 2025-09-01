/**
 * Ejercicio 01 - Clase CuentaBancaria
 * Diseña una clase CuentaBancaria que tenga un saldo y un limite de retiro.
 * Implementa metodos set y get para establecer y obtener el saldo,
 * y añade un metodo para realizar retiros que tenga en cuenta el limite de retiro.
 *
 * Autor: Jose Maria Mamani Zuniga
 * Fecha de creación: 2025-08-31
 * Última modificación: 2025-08-31
 */
class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo.")
        }
    }

    fun getSaldo(): Double = saldo

    fun setLimiteRetiro(nuevoLimite: Double) {
        if (nuevoLimite > 0) {
            limiteRetiro = nuevoLimite
        } else {
            println("El limite debe ser positivo.")
        }
    }

    fun getLimiteRetiro(): Double = limiteRetiro

    fun retirar(monto: Double) {
        if (monto > limiteRetiro) {
            println("El monto excede el limite de retiro.")
        } else if (monto > saldo) {
            println("Fondos insuficientes.")
        } else {
            saldo -= monto
            println("Retiro exitoso. Saldo actual: $$saldo")
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
    cuenta.retirar(200.0)
    cuenta.retirar(600.0)
    cuenta.retirar(900.0)
}
