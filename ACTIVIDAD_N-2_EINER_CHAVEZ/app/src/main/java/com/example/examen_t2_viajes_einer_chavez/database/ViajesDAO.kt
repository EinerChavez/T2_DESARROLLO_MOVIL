package com.example.examen_t2_viajes_einer_chavez.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ViajesDAO {
    @Insert
    fun insert(viajes: Viajes)

    @Update
    fun update(viajes: Viajes)

    @Delete
    fun delete(viajes: Viajes)

    @Query("SELECT * FROM " + Viajes.TABLE_NAME)
    fun list(): LiveData<List<Viajes>>
}
