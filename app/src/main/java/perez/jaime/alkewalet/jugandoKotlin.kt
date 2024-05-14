package perez.jaime.alkewalet
data class Estudiante(
    var nombre: String = "",
    var curso : String = "Java"
)

fun main(){
    val jorgeEstudiante = Estudiante().apply {
        nombre = "Jorge"
    }

    println(" Estudiante: ${jorgeEstudiante.nombre} - Curso: ${jorgeEstudiante.curso}")

}

