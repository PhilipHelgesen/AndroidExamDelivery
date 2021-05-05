package com.example.androidexamdelivery.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexamdelivery.Data
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.viewmodel.ViewAssetsViewModel
import com.example.androidexamdelivery.adapter.CurrencyAdapter
import com.example.androidexamdelivery.databinding.ActivityMainBinding

class CryptoListMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currencyId = ""
    val viewModel: ViewAssetsViewModel by viewModels()
    private val adapter = CurrencyAdapter()
    private val currencyList = mutableListOf<Data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.allAssetsList.observe(this) { assetList ->
            adapter.setCurrencyList(assetList.data)
        }
        viewModel.fetchCurrencyData()

        binding.currencyRecyclerView.adapter = adapter
        binding.currencyRecyclerView.layoutManager = LinearLayoutManager(this)

        val headerElement = findViewById<TextView>(R.id.header_click_element)
        headerElement.setOnClickListener {
            val intent = Intent(this, PortfolioActivity::class.java)
            startActivity(intent)

        }

    }

}

