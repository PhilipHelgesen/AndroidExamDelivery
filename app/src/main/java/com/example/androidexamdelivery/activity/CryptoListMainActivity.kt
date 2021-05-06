package com.example.androidexamdelivery.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexamdelivery.Data
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.viewmodel.ViewAssetsViewModel
import com.example.androidexamdelivery.adapter.CurrencyAdapter
import com.example.androidexamdelivery.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.item_currency.*

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

    class CustomViewHolder(val view: View, var crypto: Data? = null) : RecyclerView.ViewHolder(view) {

        companion object {
            const val CRYPTO_NAME_KEY = "CRYPTO_NAME"
            const val CRYPTO_ID_KEY = "CRYPTO_ID"
            const val CRYPTO_SYMBOL_KEY = "CRYPTO_SYMBOL"
            const val CRYPTO_PRICE_KEY = "CRYPTO_PRICE"
        }


    }

   override fun onItemClick(position: Int) {
        val intent = Intent(this, CryptocurrencyMainActivity::class.java)

        intent.putExtra(CustomViewHolder.CRYPTO_ID_KEY, currencyList[position].id)
        startActivity(intent)
    }


}

