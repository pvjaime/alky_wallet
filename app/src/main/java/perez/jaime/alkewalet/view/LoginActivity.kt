package perez.jaime.alkewalet.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import perez.jaime.alkewalet.R
import perez.jaime.alkewalet.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Vamos a implementar los SharedPreferences
        sharedPreferences = getSharedPreferences("AlkeWalet", Context.MODE_PRIVATE)
        //Vamos a verificar si el usaurio ya me guardo el correo
        val correo = sharedPreferences.getString("correo_ingresado", null)
        //si el dato es distinto de null lo voy a prerrellenar
        if (correo != null){
            binding.txtEmail.setText(correo)
        }
        //Configurando en onClick
        binding.btnLogin.setOnClickListener {
            //Vamos a rescartar la informacion que ingreso el usuario
            var correoIngresado = binding.txtEmail.text.toString()
            var passwordIngresado = binding.txtContrasena.text.toString()
            //vamos a guardar el correo en los sharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("correo_ingresado", correoIngresado)
            editor.putBoolean("recuerdame", true)
            editor.apply()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }
}