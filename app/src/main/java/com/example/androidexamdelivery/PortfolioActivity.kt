package com.example.androidexamdelivery

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexamdelivery.databinding.ActivityMainBinding

class PortfolioActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private var currencyId = ""
    val viewModel: ViewAssetsViewModel by viewModels()
    private val adapter = PortfolioAdapter()
    private val currencyList = mutableListOf<Asset>()


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.allAssetsList.observe(this){ assetList ->
            adapter.setPortfolioList(assetList.data)
        }
        viewModel.fetchCurrencyData()

        binding.currencyRecyclerView.adapter = adapter
        binding.currencyRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}