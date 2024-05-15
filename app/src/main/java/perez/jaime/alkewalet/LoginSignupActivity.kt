package perez.jaime.alkewalet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import perez.jaime.alkewalet.databinding.ActivityLoginSignupBinding

class LoginSignupActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Vamos a declarar los botones para la interaccion
        binding.txtLogin.setOnClickListener {
            val irLogin = Intent(this, LoginActivity::class.java)
            startActivity(irLogin)
        }

        binding.btnCrearCuenta.setOnClickListener {
            val irLogin = Intent(this, CreateAccountActivity::class.java)
            startActivity(irLogin)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}