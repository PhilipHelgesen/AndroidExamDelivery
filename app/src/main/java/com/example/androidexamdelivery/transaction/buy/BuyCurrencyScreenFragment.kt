package com.example.androidexamdelivery.transaction.buy


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.databinding.BuyCurrencyScreenFragmentBinding

class BuyCurrencyScreenFragment : Fragment(R.layout.buy_currency_screen_fragment) {


    private lateinit var binding: BuyCurrencyScreenFragmentBinding
    private val viewModel: BuyCurrencyScreenViewModel by viewModels()

    companion object {
        fun newInstance(symbol: String) = BuyCurrencyScreenFragment().apply {
            arguments = Bundle().apply {
                putString("symbol", symbol)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Init
        binding = BuyCurrencyScreenFragmentBinding.bind(view)
        val symbol = arguments?.getString("symbol")
        // Init view model
        viewModel.init(requireContext(), symbol)
        // View listeners
        initViewListeners()

    }

    private fun initViewListeners() {
        with(binding) {
            BuyAmount.setOnClickListener {
                if (symbol.text.toString().isEmpty()) {
                    viewModel.saveData(symbol.text.toString(), amount.text.toString())
                } else {
                    viewModel.updateData(symbol.text.toString(), amount.text.toString())
                }
            }
        }
    }

}