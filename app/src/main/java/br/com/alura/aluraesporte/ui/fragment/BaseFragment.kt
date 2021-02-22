package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.NavGraphDirections
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

//esta classe foi definida como abstrata pq ela nao vai ser utilziada por nao ter comportamentos proprios
abstract class BaseFragment: Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()
    private val controlador by lazy {
        findNavController()
    }

    private fun verificaSeEstaLogado() {

        if (loginViewModel.naoEstaLogado()) {
            vaiParaLogin()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        verificaSeEstaLogado()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_principal_deslogar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.menu_principal_deslogar) {
            loginViewModel.desloga()
            vaiParaLogin()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun vaiParaLogin() {
        //NavGraphDirections foi gerado automaticamente dado o nome inserido no xml nav_graph,
        // este grafo é o global e podemos utilizar para navegar em ações globais
        val direcao = NavGraphDirections.actionGlobalLogin()
        controlador.navigate(direcao)
    }

}