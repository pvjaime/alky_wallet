package perez.jaime.alkewalet.model

data class User (
    val id: Long,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val roleId: Long = 2,
    val points: Long = 0
)

