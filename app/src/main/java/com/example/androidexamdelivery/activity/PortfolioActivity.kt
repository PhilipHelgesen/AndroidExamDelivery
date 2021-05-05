package com.example.androidexamdelivery.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexamdelivery.Data
import com.example.androidexamdelivery.viewmodel.ViewAssetsViewModel
import com.example.androidexamdelivery.adapter.PortfolioAdapter
import com.example.androidexamdelivery.databinding.ActivityPortfolioBinding

class PortfolioActivity : AppCompatActivity(){

    private lateinit var binding: ActivityPortfolioBinding
    private var currencyId = ""
    val viewModel: ViewAssetsViewModel by viewModels()
    private val adapter = PortfolioAdapter()
    private val currencyList = mutableListOf<Data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityPortfolioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.allAssetsList.observe(this){ assetList ->
            adapter.setPortfolioList(assetList.data)
        }
        viewModel.fetchCurrencyData()

        binding.portfolioview.adapter = adapter
        binding.portfolioview.layoutManager = LinearLayoutManager(this)

    }
}