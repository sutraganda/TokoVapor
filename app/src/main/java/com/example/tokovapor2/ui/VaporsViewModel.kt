package com.example.tokovapor2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tokovapor2.model.Vapors
import com.example.tokovapor2.repository.VaporsRepository
import kotlinx.coroutines.launch

class VaporsViewModel(private val repository: VaporsRepository): ViewModel() {
    val allVapors: LiveData<List<Vapors>> = repository.allVapors.asLiveData()

    fun insert(vapors: Vapors) = viewModelScope.launch {
        repository.insertVapors(vapors)
    }

    fun delete(vapors: Vapors) = viewModelScope.launch {
        repository.deleteVapors(vapors)
    }

    fun update(vapors: Vapors) = viewModelScope.launch {
        repository.deleteVapors(vapors)
    }
}

class VaporViewModelFactory(private  val repository: VaporsRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((VaporsViewModel::class.java))) {
            return VaporsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}