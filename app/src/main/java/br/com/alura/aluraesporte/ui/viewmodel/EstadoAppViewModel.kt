package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadoAppViewModel: ViewModel() {
    //para acessos externos
    val appBar: LiveData<ComponentesVisuais> get() = _componentes

    //so pode ser alterado pela propria classe
    private var _componentes: MutableLiveData<ComponentesVisuais> = MutableLiveData<ComponentesVisuais>()
        //funcao devolve o valor que ela mesma vai alterar
        .also{
        it.value = temComponentes
    }

    var temComponentes: ComponentesVisuais = ComponentesVisuais()
    set(value){
        field = value
        _componentes.value = value
    }

}

class ComponentesVisuais(
    val appBar: Boolean = false,
    val bottomNavigation: Boolean = false
)
