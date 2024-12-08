package com.example.examen_t2_viajes_einer_chavez.Viajes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_t2_viajes_einer_chavez.R
import com.example.examen_t2_viajes_einer_chavez.database.Viajes
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class ViajesActivity : AppCompatActivity(), ViajesAdapter.ItemClickListener {

    private lateinit var viajeViewModel: ViajesViewModel
    private lateinit var adapter: ViajesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viajes)

        viajeViewModel = ViewModelProvider(this)[ViajesViewModel::class.java]

        val recyclerViajes = findViewById<RecyclerView>(R.id.recyclerviajes)
        adapter = ViajesAdapter(this)
        recyclerViajes.adapter = adapter
        recyclerViajes.layoutManager = LinearLayoutManager(this)

        viajeViewModel.viajes.observe(this) { viajes ->
            if (viajes.isNotEmpty()) {
                adapter.setViajes(viajes)
            }
        }

        val floatingButton = findViewById<FloatingActionButton>(R.id.floatingButton)
        floatingButton.setOnClickListener {
            registerViaje()
        }
    }

    private fun registerViaje() {
        val mDialogView = LayoutInflater.from(this)
            .inflate(R.layout.dialog_register, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("")
        val mAlertDialog = mBuilder.show()

        val edtLugar = mDialogView.findViewById<EditText>(R.id.edtLugar)
        val edtFechaIda = mDialogView.findViewById<EditText>(R.id.edtFechaIda)
        val edtFechaRetorno = mDialogView.findViewById<EditText>(R.id.edtFechaRetorno)
        val edtPresupuesto = mDialogView.findViewById<EditText>(R.id.edtPresupuesto)
        val edtHotel = mDialogView.findViewById<EditText>(R.id.edtHotel)
        val edtActividades = mDialogView.findViewById<EditText>(R.id.edtActividades)
        val btnRegistrar = mDialogView.findViewById<Button>(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            mAlertDialog.dismiss()
            val lugar = edtLugar.text.toString()
            val fechaIda = edtFechaIda.text.toString()
            val fechaRetorno = edtFechaRetorno.text.toString()
            val presupuesto = edtPresupuesto.text.toString().toDoubleOrNull() ?: 0.0
            val hotel = edtHotel.text.toString()
            val actividades = edtActividades.text.toString()
            val fechaRegistro = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy HH:mm:ss", Locale("es", "ES"))
            )
            val nuevoViaje = Viajes(
                fecha = fechaRegistro,
                lugar = lugar,
                ida = fechaIda,
                retorno = fechaRetorno,
                precio = presupuesto,
                hotel = hotel,
                activities = actividades
            )

            viajeViewModel.saveViaje(nuevoViaje)
        }
    }

    override fun onItemClick(viaje: Viajes) {
        val intent = Intent(this, DetallesViajeActivity::class.java)
        intent.putExtra("viaje", viaje)
        startActivity(intent)

        Log.v("VIAJE_ITEM", viaje.lugar)
    }
}
