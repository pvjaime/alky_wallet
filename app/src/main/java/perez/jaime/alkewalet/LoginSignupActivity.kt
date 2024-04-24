package perez.jaime.alkewalet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginSignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_signup)
        //Rescatando los valores de la pantalla anterior
        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val tyc = intent.getBooleanExtra("acepto_tyC", false)
        //Vamos a mostrar el dato en toast
        Toast.makeText(this,
            "Hola $nombre $apellido -- Acepto los tyc $tyc",
            Toast.LENGTH_SHORT)
            .show()

        //Vamos a declarar los botones para la interaccion
        val botonYatienesCuenta = findViewById<Button>(R.id.txt_login)
        botonYatienesCuenta.setOnClickListener {
            val irLogin = Intent(this, LoginActivity::class.java)
            startActivity(irLogin)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}