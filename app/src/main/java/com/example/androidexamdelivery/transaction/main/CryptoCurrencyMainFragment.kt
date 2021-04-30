package com.example.androidexamdelivery.transaction.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.databinding.ActivityCryptocurrencyMainBinding
import com.example.androidexamdelivery.databinding.CryptoCurrencyMainFragmentBinding
import com.example.androidexamdelivery.transaction.buy.BuyCurrencyScreenFragment

class CryptoCurrencyMainFragment : Fragment() {

    companion object {
        fun newInstance() = CryptoCurrencyMainFragment()
    }

    private lateinit var binding: CryptoCurrencyMainFragmentBinding
    private lateinit var viewModel: CryptoCurrencyMainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.crypto_currency_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CryptoCurrencyMainFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun viewListeners() {
        binding.Buy.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    BuyCurrencyScreenFragment.newInstance("ETH")
                ).addToBackStack("StudentFragment")
                .commit()
        }
    }
}