package com.example.miscuentas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miscuentas.R
import com.example.miscuentas.model.SuperMarkerModel
import com.example.miscuentas.myAdapter.MyAdapterList
import com.example.miscuentas.model.superMarkerProvider.Companion as modelSuperMarkerProvider


class SuperMarker : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_marker)
        initRecyclerView()
        val objetoSUperMercado = modelSuperMarkerProvider
        var listArray: Array<SuperMarkerModel>
        /*
        val tvPrice = findViewById<EditText>(R.id.tvPrice)
        tvPrice.addTextChangedListener{
            if (tvPrice.length() == 0) tvPrice.setError("Campo vacio")
        }
        */

        var lOf = listOf<SuperMarkerModel>()
        //add_list("NOFUNCIONA",12378.11)
        var total = 0.0
        //view_array(objetoSUperMercado.markerList)
        objetoSUperMercado.markerList.forEach {
           // println("Valor = $it")
            //val num = it.price
            //val num2 = it.price
            //println("Total: $total")
            listArray = arrayOf(SuperMarkerModel(it.nameProduct,it.price))
            lOf = arrayOf(SuperMarkerModel("gkljaklfgjsdlkfjñlasdfa",12321231.5)).toList()

            println(lOf[0].nameProduct)

           // println(iter)
            println(listArray[0].price)
            println(listArray[0].nameProduct)


            //objetoSUperMercado.markerList = listOf<SuperMarkerModel>(SuperMarkerModel(objetoSUperMercado.markerList[0].nameProduct,it.price),SuperMarkerModel("Heladito",5000.00))
            //view_array(objetoSUperMercado.markerList,"hola",456687.00)
             //listOf(smModel,objetoSUperMercado.markerList)
            //objetoSUperMercado.markerList = listOf<SuperMarkerModel>(SuperMarkerModel("fsfa",455657.00))
            total += it.price
        }


       // print(listArray)

        //println(total)

    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapterList(modelSuperMarkerProvider.markerList)

        }




    fun showHide(view:View) {
        view.visibility = if (view.visibility == View.VISIBLE){
            View.INVISIBLE
        } else {
            View.VISIBLE
        }
    }

    fun view_array(list: List<SuperMarkerModel>,name:String , price:Double): List<SuperMarkerModel> {

        var newList = listOf<SuperMarkerModel>()
        for (i in list){newList = listOf<SuperMarkerModel>(SuperMarkerModel(i.nameProduct,i.price))}
            //listOf<SuperMarkerModel>(SuperMarkerModel(i.nameProduct,i.price),SuperMarkerModel(name,price))

            //newList = listOf()
       // println(newList)
        return newList
    }

    fun add_list (name:String, precio:Double){
        for (i in listOf<SuperMarkerModel>(SuperMarkerModel(name,58844.11)))
            print(i)
    }

}

