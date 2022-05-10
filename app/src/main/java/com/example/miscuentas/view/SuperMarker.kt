package com.example.miscuentas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
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

        binding.button4.setOnClickListener {
            //Asignacion de valores
            val builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.layput_diag,null)
            //creando vista
            builder.setView(view)
            //creando dialog
            val dialog = builder.create()
            dialog.show()
        }




        objetSuperMarker.markerList.forEach {
            total += it.price
            println(it.nameProduct + " " + it.price)
        }
       /* ## Agregar un objeto a la lista por codigo
        objetSuperMarkProvi.markerList.add(SuperMarkerModel("Queso frescoo",5555.55))
        */

        println(total)

    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapterList(modelSuperMarkerProvider.markerList)

        }


}

