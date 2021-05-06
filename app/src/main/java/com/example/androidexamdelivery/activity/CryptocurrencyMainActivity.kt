package com.example.androidexamdelivery.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.androidexamdelivery.viewmodel.CryptocurrencyMainViewModel
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.databinding.ActivityCryptocurrencyMainBinding
import com.example.androidexamdelivery.transaction.buy.BuyCurrencyScreenFragment
import com.example.androidexamdelivery.transaction.history.TransactionListFragment
import com.example.androidexamdelivery.transaction.sell.SellCurrencyScreenFragment
import kotlinx.android.synthetic.main.activity_cryptocurrency_main.*
import java.util.*

class CryptocurrencyMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCryptocurrencyMainBinding
    private var currencyId = ""
    val viewModel: CryptocurrencyMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptocurrencyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.fragment_container, CryptoCurrencyMainFragment.newInstance(), "MainCurrencyFragment")
//            .commit()

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

        Buy.setOnClickListener {
            val buyCurrencyScreenFragment = BuyCurrencyScreenFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, buyCurrencyScreenFragment)
                .addToBackStack(null)
                .commit()
        }

        TransactionButton.setOnClickListener {
            val transactionListFragment = TransactionListFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, transactionListFragment)
                .addToBackStack(null)
                .commit()
        }


//        val navBarTitle = intent.getStringExtra(CryptoListMainActivity.CustomViewHolder.CRYPTO_NAME_KEY)
//        val buySellName = intent.getStringExtra(CryptoListMainActivity.CustomViewHolder.CRYPTO_NAME_KEY)
//        val buySellSymbol = intent.getStringExtra(CryptoListMainActivity.CustomViewHolder.CRYPTO_SYMBOL_KEY)
//        val buySellPrice = intent.getStringExtra(CryptoListMainActivity.CustomViewHolder.CRYPTO_PRICE_KEY)
//
//        supportActionBar?.title = navBarTitle
//        findViewById<TextView>(R.id.CurrencyName).text = "$buySellName ($buySellSymbol)"
//        findViewById<TextView>(R.id.RecentRate).text = "$$buySellPrice"
//        findViewById<TextView>(R.id.CurrencySymbol).text = "$$buySellSymbol"

        Sell.setOnClickListener {
            val sellCurrencyScreenFragment = SellCurrencyScreenFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, sellCurrencyScreenFragment)
                .addToBackStack(null)
                .commit()
        }





    }
}
