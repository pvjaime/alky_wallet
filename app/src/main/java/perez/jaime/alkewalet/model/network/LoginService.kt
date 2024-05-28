package perez.jaime.alkewalet.model.network

import perez.jaime.alkewalet.model.LoginRequest
import perez.jaime.alkewalet.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Api service que contiene los metodos para logear al usuario
 */
interface LoginService {
    /**
     * Servicio que hace login, recibe como parametros el email y la contraseña encapsulados un objeto
     */
    @POST("auth/login")
    fun hacerLogin(@Body request: LoginRequest): Call<LoginResponse>

}