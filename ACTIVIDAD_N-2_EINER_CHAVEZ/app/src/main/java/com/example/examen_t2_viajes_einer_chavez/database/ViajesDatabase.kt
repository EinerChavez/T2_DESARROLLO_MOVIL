package com.example.examen_t2_viajes_einer_chavez.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Viajes::class], version = 1)
abstract class ViajesDatabase : RoomDatabase() {

    abstract fun viajesDAO(): ViajesDAO

    companion object {
        private const val DATABASE_NAME = "viajes_database"

        @Volatile
        private var INSTANCE: ViajesDatabase? = null

        fun getInstance(context: Context): ViajesDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): ViajesDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ViajesDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}
