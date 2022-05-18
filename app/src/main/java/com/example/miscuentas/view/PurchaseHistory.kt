package com.example.miscuentas.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miscuentas.databinding.ActivityPurchaseHistoryBinding

class PurchaseHistory : AppCompatActivity() {

    private lateinit var binding: ActivityPurchaseHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}