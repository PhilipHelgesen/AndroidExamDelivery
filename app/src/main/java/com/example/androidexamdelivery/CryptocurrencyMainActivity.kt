package com.example.androidexamdelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.androidexamdelivery.databinding.ActivityCryptocurrencyMainBinding
import com.example.androidexamdelivery.transaction.main.CryptoCurrencyMainFragment
import java.util.*

class CryptocurrencyMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCryptocurrencyMainBinding
    private var currencyId = ""
    val viewModel: CryptocurrencyMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptocurrencyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, CryptoCurrencyMainFragment.newInstance(), "MainCurrencyFragment")
            .commit()

        viewModel.currentAsset.observe(this) { JsonRes ->
            binding.CurrencyName.text = (JsonRes.data.name + "(" + JsonRes.data.symbol + ")")
        }
        viewModel.currentAsset.observe(this) { JsonRes ->
            binding.RecentRate.text = ("$ " + JsonRes.data.priceUsd.substring(0, 7))
        }
        viewModel.currentAsset.observe(this) { JsonRes ->
            currencyId = JsonRes.data.symbol.toLowerCase(Locale.ROOT)

            val bitcoinUrl = "https://static.coincap.io/assets/icons/$currencyId@2x.png"

            Glide.with(this).load(bitcoinUrl).into(binding.CurrencyImage)
        }



    }
}
