package com.example.androidexamdelivery.transaction.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.databinding.CryptoCurrencyMainFragmentBinding
import com.example.androidexamdelivery.transaction.buy.BuyCurrencyScreenFragment

class CryptoCurrencyMainFragment : Fragment() {

    companion object {
        fun newInstance() = CryptoCurrencyMainFragment()
    }

    private lateinit var binding: CryptoCurrencyMainFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding = CryptoCurrencyMainFragmentBinding.bind(view)


    }
}