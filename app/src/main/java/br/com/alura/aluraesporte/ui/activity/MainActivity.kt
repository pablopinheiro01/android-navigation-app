package br.com.alura.aluraesporte.ui.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.android.viewmodel.ext.android.viewModel
import android.view.View.*

class MainActivity : AppCompatActivity() {

    private val viewModel: EstadoAppViewModel by viewModel()

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

//            when(destination.id){
//                R.id.listaProdutos -> supportActionBar?.show()
//                R.id.login -> supportActionBar?.hide()
//                R.id.cadastroUsuario -> supportActionBar?.show()
//            }
        viewModel.appBar.observe(this, Observer {
            it?.let{
                temComponentes ->
                if(temComponentes.appBar){
                    supportActionBar?.show()
                }else{
                    supportActionBar?.hide()
                }
                if(temComponentes.bottomNavigation){
                    main_activity_bottom_navigation.visibility = VISIBLE
                }else
                    main_activity_bottom_navigation.visibility = GONE
            }
        })
        }

        main_activity_bottom_navigation
            .setupWithNavController(controlador)

    }



}
