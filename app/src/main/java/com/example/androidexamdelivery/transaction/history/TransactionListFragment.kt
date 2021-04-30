package com.example.androidexamdelivery.transaction.history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexamdelivery.R

class TransactionListFragment : Fragment() {

    companion object {
        fun newInstance() = TransactionListFragment()
    }

    private lateinit var viewModel: TransactionListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.transaction_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TransactionListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}