package com.example.androidexamdelivery.transaction.history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidexamdelivery.R
import com.example.androidexamdelivery.databinding.TransactionListFragmentBinding

class TransactionListFragment : Fragment(R.layout.transaction_list_fragment) {

    companion object {
        fun newInstance() = TransactionListFragment()
    }
    private lateinit var adapter: WalletAdapter
    private lateinit var binding: TransactionListFragmentBinding
    private val viewModel: TransactionListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = TransactionListFragmentBinding.bind(view)

        viewModel.init(requireContext())
        configureList()

        viewModel.transactionListLiveData.observe(viewLifecycleOwner){
            adapter.setTransactionList(it)
        }

    }
    private fun viewListeners() {

    }

    private fun observers() {

    }

    private fun configureList() {

    }

}