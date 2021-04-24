package com.example.androidexamdelivery

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private val CurrencyList = mutableListOf<Asset>()

    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name : TextView = itemView.findViewById(R.id.CurrencyName)
        var recentRate : TextView = itemView.findViewById(R.id.RecentRate)
        var symbol : TextView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        TODO("Not yet implemented")

    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        //Verdiene settes her
        holder.name.text = CurrencyList[position].toString()
        holder.recentRate.text = CurrencyList[position].toString()
        holder.symbol.text = CurrencyList[position].toString()
    }

    override fun getItemCount(): Int {
        return CurrencyList.size
    }

    fun setCurrencyList(list: List<Asset>){
        CurrencyList.clear()
        CurrencyList.addAll(list)
        notifyDataSetChanged()
    }

}