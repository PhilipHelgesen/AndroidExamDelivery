package com.example.androidexamdelivery.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.androidexamdelivery.API

import androidx.recyclerview.widget.RecyclerView

import com.example.androidexamdelivery.Data
import com.example.androidexamdelivery.JsonRes
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.viewmodel.ViewAssetsViewModel
import com.example.androidexamdelivery.adapter.CurrencyAdapter
import com.example.androidexamdelivery.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.item_currency.*

import kotlinx.android.synthetic.main.item_currency.view.*



class CryptoListMainActivity : AppCompatActivity(), CurrencyAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    val viewModel: ViewAssetsViewModel by viewModels()
    private val adapter = CurrencyAdapter(this)
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



   override fun onItemClick(position: Int) {
        val intent = Intent(this, CryptocurrencyMainActivity::class.java)

        val id = adapter.currencyName
        println(" value $id")
        intent.putExtra("id", id)

 master
        startActivity(intent)
    }


}

