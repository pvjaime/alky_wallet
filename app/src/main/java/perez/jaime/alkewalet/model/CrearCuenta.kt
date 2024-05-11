package perez.jaime.alkewalet.model

data class CrearCuenta(
    val creationDate: String,
    val money: Long,
    val isBlocked: Boolean,
    val userID: Long
)
