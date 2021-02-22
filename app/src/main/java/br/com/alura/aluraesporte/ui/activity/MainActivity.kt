package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.com.alura.aluraesporte.R

class MainActivity : AppCompatActivity() {

    private val controlador by lazy {
        findNavController(R.id.main_activity_nav_host)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        controlador.addOnDestinationChangedListener(){
            controller, destination, arguments ->
            Log.i("Controller", "${controller}")
            Log.i("Destination", "${destination}")
            Log.i("Arguments", "${arguments}")

            //titulo da tela e definido conforme o destino que esta sendo navegado
            //o retorno da label identificará a tela.
            //a label e definida de acordo com oq foi configurado no grafo
            title = destination.label

            when(destination.id){
                R.id.listaProdutos -> supportActionBar?.show()
                R.id.login -> supportActionBar?.hide()
            }
        }
    }



}
