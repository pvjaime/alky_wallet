package perez.jaime.alkewalet.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import perez.jaime.alkewalet.AlkeWalletApp.Companion.tokenAcesso
import perez.jaime.alkewalet.model.LoginRequest
import perez.jaime.alkewalet.model.LoginResponse
import perez.jaime.alkewalet.model.User
import perez.jaime.alkewalet.model.network.LoginService
import perez.jaime.alkewalet.model.network.RetrofitIntancia
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * View model encargado de hacer el Login de la app
 */
class LoginViewModel : ViewModel() {
    //Variable LiveData que va a informar el token al login
    val tokenLiveData = MutableLiveData<String>()
    //Variable LiveData que va a informar mensaje de error
    val errorLiveData = MutableLiveData<String>()
    //Variable LiveData que va a informar cuando tenga la informacion del usuario
    val usuarioLiveData = MutableLiveData<User>()

    /**
     * funcion que implementa una corrrutina para llamar a la Api
     */
    fun hacerLogin(email: String, contrasena: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                //Aca nosotros vamos a llamar a la API
                //Esta es la intancia de retrofit
                val login: LoginService = RetrofitIntancia.retrofit.create(LoginService::class.java)
                //Se crea esa variable que va a manejar la respuesta del servicio
                val llamadaApi: Call<LoginResponse> = login.hacerLogin(
                    LoginRequest(
                        email,
                        contrasena
                    ) //Se esta generando el request basado en el objeto de Request
                )
                //llamamos al servicio
                llamadaApi.enqueue(object : Callback<LoginResponse> {
                    //Respuesta cuando la informacion cargo correctamente
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        //Si la respues tiene un codigo entre el 200 y el 300 de HTTP
                        if (response.isSuccessful) {
                            //Aca yo rescato la data que me devolvio el servicio ya tranformado desde JSON a un objeto
                            val respuesta: LoginResponse? = response.body()
                            //Como se logeo correctamente si me trae el dato del Token
                            if (respuesta?.accessToken != null) {
                                tokenLiveData.postValue(respuesta.accessToken)
                                errorLiveData.postValue(null)
                                //Si no me logeo entonces muestro un error o muestro la respuesta
                            } else {
                                //aqui si hay un error se ejecuta este codigo
                                tokenLiveData.postValue(null)
                                errorLiveData.postValue(respuesta?.error)
                            }
                            //Si la respuesta no es un codigo entre 200 o 300, hubo un error
                        } else {
                            val respuestaError: LoginResponse? = response.body()
                            //aqui si hay un error se ejecuta este codigo
                            tokenLiveData.postValue(null)
                            errorLiveData.postValue(respuestaError?.error)
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        //aqui si hay un error se ejecuta este codigo
                        tokenLiveData.postValue(null)
                        errorLiveData.postValue(null)
                    }

                })

            } catch (e: Exception) {
                //aqui si hay un error se ejecuta este codigo
                tokenLiveData.postValue(null)
                errorLiveData.postValue(null)
            }
        }
    }

    /**
     * Funcion que va a obtener la informacion del usuario
     */
    fun obtenerDatosUser() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val getUsuario = RetrofitIntancia.retrofit.create(LoginService::class.java)
                val token = "Bearer $tokenAcesso"
                val usuarioLlamada : Call<User> = getUsuario.obtenerInfoLogin(token)
                usuarioLlamada.enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        if (response.isSuccessful){
                            val usuarioLogin = response.body()
                            usuarioLiveData.postValue(usuarioLogin)
                        }else{
                            usuarioLiveData.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        usuarioLiveData.postValue(null)
                    }
                })

            } catch (e: Exception) {
                //aqui si hay un error se ejecuta este codigo
                usuarioLiveData.postValue(null)
            }
        }
    }

}