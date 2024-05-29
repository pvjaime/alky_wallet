package perez.jaime.alkewalet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import perez.jaime.alkewalet.AlkeWalletApp.Companion.usuarioLogeado
import perez.jaime.alkewalet.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (usuarioLogeado != null) {
            binding.nombreUsuario.text = "Hola ${usuarioLogeado?.first_name} ${usuarioLogeado?.last_name}"
        }

    }
}