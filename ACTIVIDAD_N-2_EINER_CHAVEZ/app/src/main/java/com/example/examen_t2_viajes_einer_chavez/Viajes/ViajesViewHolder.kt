package com.example.examen_t2_viajes_einer_chavez.Viajes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_t2_viajes_einer_chavez.R
import com.example.examen_t2_viajes_einer_chavez.database.Viajes

class ViajesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_viajes, parent, false)) {

    private var textFecha: TextView? = null
    private var textDestino: TextView? = null
    private var textIda: TextView? = null
    private var textRetorno: TextView? = null
    private var textPresupuesto: TextView? = null
    private var textHotel: TextView? = null

    init {
        textFecha = itemView.findViewById(R.id.fecha)
        textDestino = itemView.findViewById(R.id.txtDestination)
        textIda = itemView.findViewById(R.id.txtIda)
        textRetorno = itemView.findViewById(R.id.txtReturn)
        textPresupuesto = itemView.findViewById(R.id.txtmoney)
        textHotel = itemView.findViewById(R.id.txthouse)
    }

    fun bind(viaje: Viajes) {
        textFecha?.text = viaje.fecha
        textDestino?.text = "Lugar: ${viaje.lugar}"
        textIda?.text = "Ida: ${viaje.ida}"
        textRetorno?.text = "Retorno: ${viaje.retorno}"
        textPresupuesto?.text = "Presupuesto: S/ ${viaje.precio}"
        textHotel?.text = "Hotel: ${viaje.hotel}"
    }
}
