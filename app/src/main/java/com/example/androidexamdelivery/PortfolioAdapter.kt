package com.example.androidexamdelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_portfolio.view.*

class PortfolioAdapter : RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder>() {

    private val portfolioList = mutableListOf<Asset>()
    var currencyId = ""
    inner class PortfolioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_portfolio, parent, false)
        return PortfolioViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        holder.itemView.apply {
            currency_portfolio.text = portfolioList[position].name
            currencyId = portfolioList[position].symbol.toLowerCase()
            val imageUrl = "https://static.coincap.io/assets/icons/$currencyId@2x.png"
            Glide.with(this).load(imageUrl).into(portfolio_img)
        }
    }

    override fun getItemCount(): Int {
        return portfolioList.size
    }

    fun setPortfolioList(list: List<Asset>){
        portfolioList.clear()
        portfolioList.addAll(list)
        notifyDataSetChanged()
    }
}