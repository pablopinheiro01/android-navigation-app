package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadoAppViewModel: ViewModel() {
    //para acessos externos
    val appBar: LiveData<Boolean> get() = _appBar

    //so pode ser alterado pela propria classe
    private var _appBar: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
        //funcao devolve o valor que ela mesma vai alterar
        .also{
        it.value = temAppBar
    }

    var temAppBar: Boolean = false
    set(value){
        field = value
        _appBar.value = value
    }

    fun configuraAppBar(valor: Boolean){
        _appBar.value = valor
    }



}