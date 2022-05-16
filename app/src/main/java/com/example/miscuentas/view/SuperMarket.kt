package com.example.miscuentas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miscuentas.R
import com.example.miscuentas.databinding.ActivitySuperMarkerBinding
import com.example.miscuentas.model.SuperMarketModel
import com.example.miscuentas.model.superMarketProvider
import com.example.miscuentas.myAdapter.MyAdapterList
import kotlinx.android.synthetic.main.layout_view_total.view.*
import kotlinx.android.synthetic.main.layput_diag.view.*
import com.example.miscuentas.model.superMarketProvider.Companion as modelSuperMarkerProvider


class SuperMarket : AppCompatActivity() {

    private lateinit var binding: ActivitySuperMarkerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperMarkerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        val objetSuperMarker = modelSuperMarkerProvider
        val objetSuperMarkProvi = superMarketProvider

        getTotal(objetSuperMarker)
        println("Resultado de funcion ${getTotal(objetSuperMarker)}")

        // Boton de agregar compra
        binding.button4.setOnClickListener {
            //Asignacion de valores
            val builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.layput_diag, null)
            //creando vista
            builder.setView(view)
            //creando dialog
            val dialog = builder.create()
            dialog.show()

            //Obtener cajas de texto
            val boxName = view.tv_name_edit.text
            val boxPrice = view.tv_price_edit.text

            view.button6.setOnClickListener {
                if (boxName.isNotEmpty() && boxPrice.isNotEmpty()) {
                    val boxPriceD = view.tv_price_edit.text.toString()
                    val doublePrice: Double = boxPriceD.toDouble()
                    objetSuperMarkProvi.markerList.add(SuperMarketModel("$boxName", doublePrice))
                    //total += doublePrice esto usaba antes de crear fucion getTotal
                    Toast.makeText(this, "Producto Agregado correctamente", Toast.LENGTH_SHORT)
                        .show()
                    dialog.dismiss()
                } else {
                    Toast.makeText(this, "Faltan campos", Toast.LENGTH_SHORT).show()
                }
            }
        }
        //println(total) ## VER TOTAL POR CONSOLA
        //Boton de ver total
        binding.button5.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.layout_view_total, null)
            builder.setView(view)
            view.tv_total.text = getTotal(objetSuperMarker).toString()
            val dialog = builder.create()
            dialog.show()
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapterList(modelSuperMarkerProvider.markerList)

    }

    fun getTotal(objeT: modelSuperMarkerProvider): Double {
        var total = 0.0
        objeT.markerList.forEach {
            total += it.price
        }
        return total
    }

}




