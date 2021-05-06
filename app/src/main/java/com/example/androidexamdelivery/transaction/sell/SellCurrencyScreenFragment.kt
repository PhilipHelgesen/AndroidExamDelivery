package com.example.androidexamdelivery.transaction.sell

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.databinding.SellCurrencyScreenFragmentBinding

class SellCurrencyScreenFragment : Fragment(R.layout.sell_currency_screen_fragment) {

    private var walletID: Long? = null
    private lateinit var binding: SellCurrencyScreenFragmentBinding
    private val viewModel: SellCurrencyScreenViewModel by viewModels()

    companion object {
        fun newInstance(walletID: Long?) = SellCurrencyScreenFragment().apply {
            if (walletID != null) {
                arguments = Bundle().apply {
                    putLong("walletID", walletID)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Init
        binding = SellCurrencyScreenFragmentBinding.bind(view)
        walletID = arguments?.getLong("walletID")
        // Init view model
        viewModel.init(requireContext(), walletID)
        // View listeners
        initViewListeners()

    }

    private fun initViewListeners() {
        with(binding) {
            SellAmount.setOnClickListener {
                if (walletID == null) {
                    viewModel.sellData(symbol.text.toString(), amount.text.toString())
                } else {
                    viewModel.updateData(walletID!!, symbol.text.toString(), amount.text.toString())
                }
            }
        }
    }

}