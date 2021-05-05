package com.example.androidexamdelivery.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidexamdelivery.Data
import com.example.androidexamdelivery.R
import kotlinx.android.synthetic.main.item_currency.view.*


class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private val currencyList = mutableListOf<Data>()
    private var currencyId = ""


    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        

        holder.itemView.apply{
            cryptoName.text = currencyList[position].name
            cryptoRate.text = currencyList[position].priceUsd.substring(0,10)
            cryptoSymbol.text = currencyList[position].symbol
            cryptoRateChange.text = currencyList[position].changePercent24Hr.substring(0,6)

            currencyId = currencyList[position].symbol.toLowerCase()
            val imageUrl = "https://static.coincap.io/assets/icons/$currencyId@2x.png"
            Glide.with(this).load(imageUrl).into(cryptoImage)


            if (currencyList[position].changePercent24Hr!! >= "0.00"){
                cryptoRateChange.setTextColor(
                    Color.GREEN)
            }
            else{
                cryptoRateChange.setTextColor(
                    Color.RED)
            }
        }
    }


    override fun getItemCount(): Int {
        return currencyList.size
    }

    fun setCurrencyList(list: List<Data>){
        currencyList.clear()
        currencyList.addAll(list)
        notifyDataSetChanged()
    }


}