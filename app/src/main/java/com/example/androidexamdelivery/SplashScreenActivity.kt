package com.example.androidexamdelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidexamdelivery.databinding.ActivityMainBinding
import java.util.*

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currencyId = ""
    val viewModel: ViewAssetsViewModel by viewModels()
    private val adapter = CurrencyAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.allAssetsList.observe(this){ assetList ->
            adapter.setCurrencyList(assetList.data)
        }
        viewModel.fetchCurrencyData()

        binding.currencyRecyclerView.adapter = adapter
        binding.currencyRecyclerView.layoutManager = LinearLayoutManager(this)


        //val button = findViewById<Button>(R.id.button1)

        //button.setOnClickListener{
         //   val intent1 = Intent(this, CryptocurrencyMainActivity::class.java)
           // startActivity(intent1)
       // }
    }
}