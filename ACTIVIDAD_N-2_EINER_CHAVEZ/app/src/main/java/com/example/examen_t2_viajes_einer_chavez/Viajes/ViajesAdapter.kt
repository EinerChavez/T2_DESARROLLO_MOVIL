package com.example.examen_t2_viajes_einer_chavez.Viajes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_t2_viajes_einer_chavez.database.Viajes

class ViajesAdapter(private val mItemListener: ItemClickListener) : RecyclerView.Adapter<ViajesViewHolder>() {

    private var viajeList = emptyList<Viajes>()

    fun setViajes(viajes: List<Viajes>) {
        viajeList = viajes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViajesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViajesViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return viajeList.size
    }

    override fun onBindViewHolder(holder: ViajesViewHolder, position: Int) {
        holder.bind(viajeList[position])

        holder.itemView.setOnClickListener {
            mItemListener.onItemClick(viajeList[position])
        }
    }

    interface ItemClickListener {
        fun onItemClick(viaje: Viajes)
    }
}


