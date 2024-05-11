package perez.jaime.alkewalet.model

data class Transaccion(
    val amount: Long,
    val concept: String,
    val date: String,
    val type: String,
    val accountID: Long,
    val userID: Long,
    val toAccountID: Long
)
