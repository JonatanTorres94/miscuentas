package com.example.miscuentas.myAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miscuentas.R
import com.example.miscuentas.model.SuperMarkerModel

class MyAdapterList (private val superMarkerList:List<SuperMarkerModel>): RecyclerView.Adapter<ListHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return ListHolder(layoutInflater.inflate(R.layout.item_list_marker, parent, false))
        }

        // este metodo recorre los items y llamar al render
        override fun onBindViewHolder(holder: ListHolder, position: Int) {
            val item =  superMarkerList[position]
            holder.render(item)
        }

        override fun getItemCount(): Int = superMarkerList.size

}