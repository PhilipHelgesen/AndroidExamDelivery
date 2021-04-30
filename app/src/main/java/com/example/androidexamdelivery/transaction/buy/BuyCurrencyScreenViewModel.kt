package com.example.androidexamdelivery.transaction.buy

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexamdelivery.db.DataBase
import com.example.androidexamdelivery.db.WalletDAO
import com.example.androidexamdelivery.entities.Wallet
import kotlinx.coroutines.launch

class BuyCurrencyScreenViewModel : ViewModel() {
    private lateinit var walletDAO: WalletDAO

    fun init(context: Context, symbol: String?){
        walletDAO = DataBase.getDatabase(context).getWalletDAO()
    }
    fun saveData(symbol : String, amount : String){
        viewModelScope.launch {
            walletDAO.insert(Wallet(symbol = symbol, amount = amount))
        }
    }

    fun updateData(symbol : String, amount : String){
        viewModelScope.launch {
            walletDAO.update(Wallet(symbol = symbol, amount = amount))
        }
    }
}