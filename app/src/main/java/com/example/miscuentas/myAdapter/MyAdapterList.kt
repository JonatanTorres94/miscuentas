package com.example.miscuentas.myAdapter

import android.content.Intent.getIntent
import android.content.Intent.makeMainActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.core.app.ActivityCompat.recreate
import androidx.core.app.ActivityCompat.startActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.miscuentas.R
import com.example.miscuentas.model.SuperMarkerModel
import com.example.miscuentas.model.superMarkerProvider
import com.example.miscuentas.view.SuperMarker
import kotlinx.android.synthetic.main.activity_super_marker.view.*

class MyAdapterList(private val superMarkerList: List<SuperMarkerModel>) :
    RecyclerView.Adapter<ListHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListHolder(layoutInflater.inflate(R.layout.item_list_marker, parent, false))
    }

    // este metodo recorre los items y llamar al render
    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val item = superMarkerList[position]
        holder.render(item)
        holder.buttonDelete.setOnClickListener {
            //Esto sirve para borrar la posicion que tiene el boton del recyclerview
            val pos = holder.adapterPosition.toInt()
            deleteItem(pos)
        }
    }

    override fun getItemCount(): Int = superMarkerList.size

    fun deleteItem(i: Int) {
        superMarkerProvider.markerList.removeAt(i)
        notifyDataSetChanged()
    }


}

