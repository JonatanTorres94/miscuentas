package com.example.miscuentas.myAdapter

import android.widget.TextView
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.miscuentas.R
import com.example.miscuentas.model.SuperMarkerModel

class ListHolder(view:View):RecyclerView.ViewHolder(view) {

    val name = view.findViewById<TextView>(R.id.tvNameProduct)
    val price = view.findViewById<TextView>(R.id.tvPrice)

    fun render(superMarkerModel: SuperMarkerModel){
        name.text = superMarkerModel.nameProduct
        price.text = superMarkerModel.price.toString()
    }


}