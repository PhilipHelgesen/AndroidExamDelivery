package com.example.androidexamdelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class portfolio_adapter(
        var portfolio: List<Asset>
) : RecyclerView.Adapter<portfolio_adapter.PortfolioViewHolder>() {


    inner class PortfolioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_portfolio, parent, false)
        return PortfolioViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        holder.itemView.apply {

        }
    }

    override fun getItemCount(): Int {
        return portfolio.size
    }
}