package com.example.examen_t2_viajes_einer_chavez.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = Viajes.TABLE_NAME)
data class Viajes(
    @ColumnInfo(name = "fecha")
    val fecha: String,

    @ColumnInfo(name = "lugar")
    val lugar: String,

    @ColumnInfo(name = "Ida")
    val ida: String,

    @ColumnInfo(name = "Retorno")
    val retorno: String,

    @ColumnInfo(name = "presupuesto")
    val precio: Double,

    @ColumnInfo(name = "hotel")
    val hotel: String,

    @ColumnInfo(name = "Actividades")
    val activities: String
) : Serializable {
    companion object {
        const val TABLE_NAME = "viajes_table"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_viajes")
    var viajesId: Int = 0
}
