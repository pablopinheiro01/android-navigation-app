package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private val controlador by lazy{
        findNavController()
    }

    private val viewModel: LoginViewModel by viewModel()

    private val estadoAppViewModel: EstadoAppViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_botao_logar.setOnClickListener(){
            viewModel.loga()
            vaiParaListaDeProdutos()
        }

        login_botao_cadastrar_usuario.setOnClickListener(){
            val direcao =
                LoginFragmentDirections.actionLoginToCadastroUsuario()
            controlador.navigate(direcao)
        }

        estadoAppViewModel.temAppBar = true
    }

    private fun vaiParaListaDeProdutos() {
        val direcao = LoginFragmentDirections.actionLoginToListaProdutos()
        controlador.navigate(direcao)
    }


}