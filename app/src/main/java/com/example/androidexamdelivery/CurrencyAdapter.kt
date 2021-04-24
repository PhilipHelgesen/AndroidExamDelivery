package com.example.androidexamdelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_currency.view.*



class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private val currencyList = mutableListOf<Asset>()

    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.itemView.apply{
            cryptoName.text = currencyList[position].name
            cryptoRate.text = currencyList[position].priceUsd
        }

    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

    fun setCurrencyList(list: List<Asset>){
        currencyList.clear()
        currencyList.addAll(list)
        notifyDataSetChanged()
    }

}