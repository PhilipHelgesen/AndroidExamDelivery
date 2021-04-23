package com.example.androidexamdelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.androidexamdelivery.databinding.ActivityCryptocurrencyMainBinding
import java.util.*

class CryptocurrencyMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCryptocurrencyMainBinding
   private var currencyId = ""
    val viewModel: CryptocurrencyMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptocurrencyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.currentAsset.observe(this) { JsonRes ->
            binding.CurrencyName.text = JsonRes.data.name
        }
        viewModel.currentAsset.observe(this) { JsonRes ->
            binding.RecentRate.text = JsonRes.data.priceUsd
        }
        viewModel.currentAsset.observe(this) { JsonRes ->
            currencyId = JsonRes.data.symbol.toLowerCase(Locale.ROOT)

            val bitcoinUrl = "https://static.coincap.io/assets/icons/$currencyId@2x.png"

            Glide.with(this).load(bitcoinUrl).into(binding.imageView)
        }
    }
}

