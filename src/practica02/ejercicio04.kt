/**
 * Ejercicio 04 - Sistema de Gestion de Biblioteca
 * Incluye Material (abstracta), Libro, Revista, Usuario, IBiblioteca y Biblioteca.
 *
 * Autor: Jose Maria Mamani Zuniga
 * Fecha de creación: 2025-08-31
 * Última modificación: 2025-08-31
 */
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val paginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Genero: $genero, Paginas: $paginas")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Vol: $volumen, Nº: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesPrestados(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        prestamos[usuario] = mutableListOf()
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("${usuario.nombre} ha prestado ${material.titulo}")
        } else {
            println("${material.titulo} no esta disponible")
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        if (prestamos[usuario]?.contains(material) == true) {
            prestamos[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("${usuario.nombre} ha devuelto ${material.titulo}")
        } else {
            println("${usuario.nombre} no tiene este material en prestamo")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesPrestados(usuario: Usuario) {
        println("Materiales prestados a ${usuario.nombre}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    val libro = Libro("Don Quijote", "Cervantes", 1605, "Novela", 863)
    val revista = Revista("National Geographic", "Varios", 2023, "1234-5678", 150, 2, "NG Society")
    val usuario = Usuario("Ana", "López", 25)

    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)
    biblioteca.registrarUsuario(usuario)

    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.prestarMaterial(usuario, libro)
    biblioteca.mostrarMaterialesPrestados(usuario)
    biblioteca.devolverMaterial(usuario, libro)
    biblioteca.mostrarMaterialesDisponibles()
}

