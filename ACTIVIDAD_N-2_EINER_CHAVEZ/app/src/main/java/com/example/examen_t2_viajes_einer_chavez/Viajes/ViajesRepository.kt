package com.example.examen_t2_viajes_einer_chavez.Viajes

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.examen_t2_viajes_einer_chavez.database.ViajesDAO
import com.example.examen_t2_viajes_einer_chavez.database.Viajes
import com.example.examen_t2_viajes_einer_chavez.database.ViajesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ViajesRepository(application: Application) {

    private val viajesDAO: ViajesDAO =
        ViajesDatabase.getInstance(application).viajesDAO()

    suspend fun insertViaje(viaje: Viajes) {
        processInsertViaje(viaje)
    }

    private suspend fun processInsertViaje(viaje: Viajes) {
        withContext(Dispatchers.Default) {
            viajesDAO.insert(viaje)
        }
    }

    fun getViajes(): LiveData<List<Viajes>> {
        return viajesDAO.list()
    }

    suspend fun updateViaje(viaje: Viajes) {
        processUpdateViaje(viaje)
    }

    private suspend fun processUpdateViaje(viaje: Viajes) {
        withContext(Dispatchers.Default) {
            viajesDAO.update(viaje)
        }
    }

    suspend fun deleteViaje(viaje: Viajes) {
        processDeleteViaje(viaje)
    }

    private suspend fun processDeleteViaje(viaje: Viajes) {
        withContext(Dispatchers.Default) {
            viajesDAO.delete(viaje)
        }
    }
}
