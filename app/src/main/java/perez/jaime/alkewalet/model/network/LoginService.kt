package perez.jaime.alkewalet.model.network

import perez.jaime.alkewalet.model.LoginRequest
import perez.jaime.alkewalet.model.LoginResponse
import perez.jaime.alkewalet.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Api service que contiene los metodos para logear al usuario
 */
interface LoginService {
    /**
     * Servicio que hace login, recibe como parametros el email y
     * la contraseña encapsulados un objeto de Request
     */
    @POST("auth/login")
    fun hacerLogin(@Body request: LoginRequest): Call<LoginResponse>


    @GET("auth/me")
    fun obtenerInfoLogin(
        @Header("Authorization") token: String
    ): Call<User>

}