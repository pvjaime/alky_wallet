package perez.jaime.alkewalet

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer
import java.util.TimerTask

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Esta es la linea que dice que xml va a mostrar
        setContentView(R.layout.activity_splash_screen)
        /**
         * Abiendo la pantalla con un click

         */
        //Se declara la imagen como una variable
        val logoApp = findViewById<ImageView>(R.id.logoApp)
        logoApp.setOnClickListener {
            val abrirPantallaLogin = Intent(this, LoginSignupActivity::class.java)
            abrirPantallaLogin.putExtra("nombre", "Jaime")
            abrirPantallaLogin.putExtra("apellido", "Perez")
            abrirPantallaLogin.putExtra("acepto_tyC", false)
            startActivity(abrirPantallaLogin)
        }

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

}