package perez.jaime.alkewalet

import android.app.Application
import perez.jaime.alkewalet.model.User

class AlkeWalletApp : Application() {

    companion object {
        //Vamos a crear un objeto usuurio que va a estar global al proyecto
        var usuarioLogeado: User? = null
        //Vamos a crear un String que va a ser el Token
        var tokenAcesso: String? = ""
    }

    override fun onCreate() {
        super.onCreate()
        usuarioLogeado = null
        tokenAcesso = null
    }

}