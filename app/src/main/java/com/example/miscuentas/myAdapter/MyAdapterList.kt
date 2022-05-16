package com.example.miscuentas.myAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miscuentas.R
import com.example.miscuentas.model.SuperMarketModel
import com.example.miscuentas.model.superMarketProvider

class MyAdapterList(private val superMarketList: List<SuperMarketModel>) :
    RecyclerView.Adapter<ListHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListHolder(layoutInflater.inflate(R.layout.item_list_marker, parent, false))
    }

    // este metodo recorre los items y llamar al render
    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val item = superMarketList[position]
        holder.render(item)
        holder.buttonDelete.setOnClickListener {
            //Esto sirve para borrar la posicion que tiene el boton del recyclerview
            val pos = holder.adapterPosition.toInt()
            deleteItem(pos)
        }
    }

    override fun getItemCount(): Int = superMarketList.size

    fun deleteItem(i: Int) {
        superMarketProvider.markerList.removeAt(i)
        notifyDataSetChanged()
    }


}

