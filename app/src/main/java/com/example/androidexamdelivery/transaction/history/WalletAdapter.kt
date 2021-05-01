package com.example.androidexamdelivery.transaction.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexamdelivery.databinding.WalletItemBinding
import com.example.androidexamdelivery.entities.Wallet


class WalletAdapter(val lambdaFunction: (Wallet) -> Unit) :
    RecyclerView.Adapter<WalletAdapter.ViewHolder>() {

    private val transactionList = mutableListOf<Wallet>()

    class ViewHolder(val binding: WalletItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(wallet: Wallet) {
            binding.CurrencySymbol.text = wallet.amount
            binding.CurrencyAmount.text = wallet.symbol
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(WalletItemBinding.inflate(LayoutInflater.from(parent.context)))
        holder.itemView.setOnClickListener{
            lambdaFunction(transactionList[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(transactionList[position])
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    fun setTransactionList(list: List<Wallet>) {
        transactionList.clear()
        transactionList.addAll(list)
        notifyDataSetChanged()
    }

}