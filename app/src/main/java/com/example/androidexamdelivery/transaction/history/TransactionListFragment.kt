package com.example.androidexamdelivery.transaction.history


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.databinding.TransactionListFragmentBinding
import com.example.androidexamdelivery.transaction.buy.BuyCurrencyScreenFragment

class TransactionListFragment : Fragment(R.layout.transaction_list_fragment) {

    companion object {
        fun newInstance() = TransactionListFragment()
    }

    private val adapter = WalletAdapter { wallet ->
        parentFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            BuyCurrencyScreenFragment.newInstance(walletID = wallet.id))
            .addToBackStack("BuyScreenFragment")
            .commit()
    }
    private lateinit var binding: TransactionListFragmentBinding
    private val viewModel: TransactionListViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = TransactionListFragmentBinding.bind(view)

        viewModel.init(requireContext())

        observe()
        configureList()
    }

    private fun observe() {
        viewModel.transactionListLiveData.observe(viewLifecycleOwner){
            adapter.setTransactionList(it)
        }
    }

    private fun configureList() {
        binding.TransactionList.layoutManager = LinearLayoutManager(requireContext())
        binding.TransactionList.adapter = adapter

    }

}