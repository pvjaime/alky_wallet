package perez.jaime.alkewalet.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                if (email == "test@test.cl" && contrasena == "1234") {
                    loginResultLiveData.postValue(true)
                } else {
                    loginResultLiveData.postValue(false)
                }
            } catch (e: Exception) {
                //aqui si hay un error se ejecuta este codigo
                loginResultLiveData.postValue(false)
            }
        }
    }
}