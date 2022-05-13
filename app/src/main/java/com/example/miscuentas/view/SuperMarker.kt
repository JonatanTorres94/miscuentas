package com.example.miscuentas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miscuentas.R
import com.example.miscuentas.databinding.ActivityMainBinding
import com.example.miscuentas.databinding.ActivitySuperMarkerBinding
import com.example.miscuentas.model.SuperMarkerModel
import com.example.miscuentas.model.superMarkerProvider
import com.example.miscuentas.myAdapter.MyAdapterList
import kotlinx.android.synthetic.main.activity_super_marker.*
import kotlinx.android.synthetic.main.item_list_marker.view.*
import kotlinx.android.synthetic.main.layout_viewall.view.*
import kotlinx.android.synthetic.main.layput_diag.view.*
import com.example.miscuentas.model.superMarkerProvider.Companion as modelSuperMarkerProvider


class SuperMarker : AppCompatActivity() {

    private lateinit var binding: ActivitySuperMarkerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperMarkerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        val objetSuperMarker = modelSuperMarkerProvider
        val objetSuperMarkProvi = superMarkerProvider
        var total = 0.0



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
                    if (boxName.isNotEmpty() && boxPrice.isNotEmpty()){
                        val boxPriceD = view.tv_price_edit.text.toString()
                        val doublePrice: Double = boxPriceD.toDouble()
                        objetSuperMarkProvi.markerList.add(SuperMarkerModel("$boxName", doublePrice))
                        total += doublePrice
                        Toast.makeText(this, "Producto Agregado correctamente", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }else{
                        Toast.makeText(this, "Faltan campos", Toast.LENGTH_SHORT).show()
                    }

                }


        }

        //println(total) ## VER TOTAL POR CONSOLA

        //Boton de ver total
        binding.button5.setOnClickListener {


            val builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.layout_viewall, null)

            builder.setView(view)
            view.tv_total.text = total.toString()
            val dialog = builder.create()
            dialog.show()



        }
        //Crear funcion para recorrer markerlist y ver si requiere llamdo inicial antes de cargar compras
        objetSuperMarker.markerList.forEach {
            total += it.price
            //println(it.nameProduct + " " + it.price)
        }



    }


    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapterList(modelSuperMarkerProvider.markerList)

    }




}




