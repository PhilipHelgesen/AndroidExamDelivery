package com.example.androidexamdelivery.transaction.buy


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.databinding.BuyCurrencyScreenFragmentBinding

class BuyCurrencyScreenFragment : Fragment(R.layout.buy_currency_screen_fragment) {

    private var walletID: Long? = null
    private lateinit var binding: BuyCurrencyScreenFragmentBinding
    private val viewModel: BuyCurrencyScreenViewModel by viewModels()

    companion object {
        fun newInstance(walletID: Long?) = BuyCurrencyScreenFragment().apply {
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
        binding = BuyCurrencyScreenFragmentBinding.bind(view)
        walletID = arguments?.getLong("walletID")
        // Init view model
        viewModel.init(requireContext(), walletID)
        // View listeners
        initViewListeners()

    }

    private fun initViewListeners() {
        with(binding) {
            BuyAmount.setOnClickListener {
                if (walletID == null) {
                    viewModel.saveData(symbol.text.toString(), amount.text.toString())
                } else {
                    viewModel.updateData(walletID!!, symbol.text.toString(), amount.text.toString())
                }
            }
        }
    }

}