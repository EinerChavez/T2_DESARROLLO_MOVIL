package com.example.examen_t2_viajes_einer_chavez.Viajes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen_t2_viajes_einer_chavez.database.Viajes
import kotlinx.coroutines.launch

class ViajesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ViajesRepository(application)

    val viajes = repository.getViajes()

    fun saveViaje(viaje: Viajes) {
        viewModelScope.launch {
            repository.insertViaje(viaje)
        }
    }


}
