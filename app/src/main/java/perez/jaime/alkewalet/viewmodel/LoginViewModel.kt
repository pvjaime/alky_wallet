package perez.jaime.alkewalet.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    //Variable LiveData que va a informar a la vista el login
    val loginResultLiveData = MutableLiveData<Boolean>()

    /**
     * funcion que implementa una corrrutina para llamar a la Api
     */
    fun hacerLogin(email: String, contrasena: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                //Aca nosotros vamos a llamar a la API
                //Esta es la intancia de retrofit
                var login: LoginService = RetrofitIntancia.retrofit.create(LoginService::class.java)
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
                                loginResultLiveData.postValue(true)
                            //Si no me logeo entonces muestro un error o muestro la respuesta
                            } else {
                                //aqui si hay un error se ejecuta este codigo
                                loginResultLiveData.postValue(false)
                            }
                        //Si la respuesta no es un codigo entre 200 o 300, hubo un error
                        } else {
                            //aqui si hay un error se ejecuta este codigo
                            loginResultLiveData.postValue(false)
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        //aqui si hay un error se ejecuta este codigo
                        loginResultLiveData.postValue(false)
                    }

                })

            } catch (e: Exception) {
                //aqui si hay un error se ejecuta este codigo
                loginResultLiveData.postValue(false)
            }
        }
    }
}