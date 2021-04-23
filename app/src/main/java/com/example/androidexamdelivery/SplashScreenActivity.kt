package com.example.androidexamdelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.androidexamdelivery.databinding.ActivityCryptocurrencyMainBinding
import com.example.androidexamdelivery.databinding.CoinViewFragmentBinding
import java.util.*

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: CoinViewFragmentBinding
    private var currencyId = ""
    val viewModel: ViewAssetsViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = CoinViewFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.allAssets.observe(this){ListAllAssets ->
            binding.CurrencyName.text = ListAllAssets.data.name
        }

        viewModel.allAssets.observe(this){ListAllAssets ->
            binding.RecentRate.text = ListAllAssets.data.priceUsd
        }

        viewModel.allAssets.observe(this){ListAllAssets ->
            currencyId = ListAllAssets.data.symbol.toLowerCase(Locale.ROOT)

            val assetsURL = "https://static.coincap.io/assets/icons/$currencyId@2x.png"

            Glide.with(this).load(assetsURL).into(binding.imageView)
        }



        //val button = findViewById<Button>(R.id.button1)

        //button.setOnClickListener{
         //   val intent1 = Intent(this, CryptocurrencyMainActivity::class.java)
           // startActivity(intent1)
       // }
    }
}