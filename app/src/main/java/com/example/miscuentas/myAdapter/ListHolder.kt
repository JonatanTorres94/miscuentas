package com.example.miscuentas.myAdapter

import android.widget.TextView
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.miscuentas.R
import com.example.miscuentas.model.SuperMarketModel

class ListHolder(view:View):RecyclerView.ViewHolder(view) {

    val name = view.findViewById<TextView>(R.id.tvNameProduct)
    val price = view.findViewById<TextView>(R.id.tvPrice)
    val buttonDelete = view.findViewById<Button>(R.id.button7)
    

    fun render(superMarketModel: SuperMarketModel){
        name.text = superMarketModel.nameProduct
        price.text = superMarketModel.price.toString()
    }


}