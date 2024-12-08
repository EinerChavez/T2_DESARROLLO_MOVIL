package com.example.examen_t2_viajes_einer_chavez.Viajes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.examen_t2_viajes_einer_chavez.R
import com.example.examen_t2_viajes_einer_chavez.database.Viajes

class DetallesViajeActivity : AppCompatActivity() {

    private lateinit var viaje: Viajes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_viaje)

        val viajeExtra = intent.getSerializableExtra("viaje")
        if (viajeExtra is Viajes) {
            viaje = viajeExtra
        } else {
            finish()
            return
        }

        findViewById<TextView>(R.id.txtLugar).text = "Lugar: ${viaje.lugar ?: "No disponible"}"
        findViewById<TextView>(R.id.txtFechaIda).text = "Fecha de Ida: ${viaje.ida ?: "No disponible"}"
        findViewById<TextView>(R.id.txtFechaRetorno).text = "Fecha de Retorno: ${viaje.retorno ?: "No disponible"}"
        findViewById<TextView>(R.id.txtPresupuesto).text = "S/. ${viaje.precio ?: "N/A"}"
        findViewById<TextView>(R.id.txtHotel).text = " ${viaje.hotel ?: "No disponible"}"
        findViewById<TextView>(R.id.txtActividades).text = " ${viaje.activities ?: "No disponibles"}"

        findViewById<Button>(R.id.btnCerrar).setOnClickListener {
            finish()
        }
    }
}
