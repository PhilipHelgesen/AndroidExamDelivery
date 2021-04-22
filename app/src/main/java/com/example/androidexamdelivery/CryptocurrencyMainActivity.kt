package com.example.androidexamdelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.androidexamdelivery.databinding.ActivityCryptocurrencyMainBinding

class CryptocurrencyMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCryptocurrencyMainBinding

    val viewModel: CryptocurrencyMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptocurrencyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.currentAsset.observe(this){ JsonRes ->
            binding.textView.text = JsonRes.data.name
        }
    }

}

