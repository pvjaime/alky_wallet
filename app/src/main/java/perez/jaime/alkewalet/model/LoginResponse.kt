package perez.jaime.alkewalet.model

data class LoginResponse(
    //Esto viene si la api responde bien
    val accessToken: String?,
    //Si la API responde con algun error devuelve estos datos
    val error: String?,
    val status: Int?
)
