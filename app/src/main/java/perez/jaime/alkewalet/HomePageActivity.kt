package perez.jaime.alkewalet

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import perez.jaime.alkewalet.clases.Usuario

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        var user = Usuario()
        var nombre = user.nombre
        user.nombre = "juanito"
        user.salude()

    }

}

fun Usuario.salude() : String{
    return "Hola ${this.nombre}"
}