package com.example.miscuentas.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miscuentas.databinding.ActivityMainBinding
enum class ProviderType {
    BASIC
}

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent: Intent = Intent(this, SuperMarket::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent: Intent = Intent(this, PurchaseHistory::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent: Intent = Intent(this, ActivityAuth::class.java)
            startActivity(intent)
        }

    }


}