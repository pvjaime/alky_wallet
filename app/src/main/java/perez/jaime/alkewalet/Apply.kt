package perez.jaime.alkewalet

import android.os.Bundle

// Definición de la clase Persona
data class Persona(var nombre: String = "", var edad: Int = 0) {
    // Método para imprimir un saludo
    fun saludar() {
        println("¡Hola! Mi nombre es $nombre y tengo $edad años.")
    }

    // Método para calcular el año de nacimiento
    fun calcularAñoDeNacimiento(añoActual: Int): Int {
        return añoActual - edad
    }

    companion object{
        var datosImportante = "Ingresa todos los datos"
    }

}

fun main() {
    // Crear una instancia de Persona y configurarla usando apply, también llamando a operaciones dentro de apply
    val persona = Persona().apply {
        nombre = "Jaime"
        edad = 36
        // Llamar al método saludar() y calcularAñoDeNacimiento() utilizando las propiedades configuradas
        saludar()
        val añoDeNacimiento = calcularAñoDeNacimiento(2024)
        println("Nací aproximadamente en el año $añoDeNacimiento.")
    }

}

