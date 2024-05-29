package perez.jaime.alkewalet.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import perez.jaime.alkewalet.AlkeWalletApp.Companion.tokenAcesso
import perez.jaime.alkewalet.AlkeWalletApp.Companion.usuarioLogeado
import perez.jaime.alkewalet.HomeActivity
import perez.jaime.alkewalet.R
import perez.jaime.alkewalet.databinding.ActivityLoginBinding
import perez.jaime.alkewalet.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Vamos a  configurar el Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Vamos a configurar el ViewModel
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        //Vamos a implementar los SharedPreferences
        sharedPreferences = getSharedPreferences("AlkeWalet", Context.MODE_PRIVATE)
        //Vamos a verificar si el usaurio ya me guardo el correo
        val correo = sharedPreferences.getString("correo_ingresado", null)
        //si el dato es distinto de null lo voy a prerrellenar
        if (correo != null) {
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
            viewModel.hacerLogin(correoIngresado, passwordIngresado)
        }

        //Se configura el observador que va a estar observando al sujeto "tokenLiveData"
        viewModel.tokenLiveData.observe(this) { token ->
            if (token != null) {
                //Vamos a guardar el token en la variable global de la aplicación
                tokenAcesso = token
                //vamos a llamar a la API para obtener la informacion del usuario
                viewModel.obtenerDatosUser()
            }
        }

        //Se configura el observador que va a estar observando al sujeto "usuarioLiveData"
        viewModel.usuarioLiveData.observe(this) { usuario ->
            if (usuario != null) {
                usuarioLogeado = usuario
                val irMenuPrincipal = Intent(this, HomeActivity::class.java)
                startActivity(irMenuPrincipal)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}