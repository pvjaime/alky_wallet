package perez.jaime.alkewalet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import perez.jaime.alkewalet.Persona.Companion.datosImportante
import perez.jaime.alkewalet.clases.Usuario
import java.util.Timer
import java.util.TimerTask

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.i("Ciclo de Vida", "on Create" )
        //Esta es la linea que dice que xml va a mostrar
        setContentView(R.layout.activity_splash_screen)
        /**
         * Abiendo la pantalla con un timer
         */
        var task: TimerTask? = object : TimerTask() {
            override fun run() {
                val abrirPantallaLogin = Intent(baseContext, LoginSignupActivity::class.java)
                abrirPantallaLogin.putExtra("nombre", "Jorge")
                abrirPantallaLogin.putExtra("apellido", "Android")
                abrirPantallaLogin.putExtra("acepto_tyC", true)
                startActivity(abrirPantallaLogin)
            }
        }

        val timer = Timer()
        timer.schedule(task, 2000)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo de Vida", "on Start" )
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo de Vida", "on Resume" )
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo de Vida", "on Pause" )
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo de Vida", "on Stop" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo de Vida", "on Destroy" )
    }

}