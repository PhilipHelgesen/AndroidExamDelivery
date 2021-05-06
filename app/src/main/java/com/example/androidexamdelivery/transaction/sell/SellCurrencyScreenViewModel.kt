package com.example.androidexamdelivery.transaction.sell

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexamdelivery.db.DataBase
import com.example.androidexamdelivery.db.WalletDAO
import com.example.androidexamdelivery.entities.Wallet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class SellCurrencyScreenViewModel : ViewModel() {
    private lateinit var walletDAO: WalletDAO

    private val _transactionListLiveData: MutableLiveData<Wallet> = MutableLiveData()

    fun init(context: Context, walletID: Long?){
        walletDAO = DataBase.getDatabase(context).getWalletDAO()
        if (walletID != null){
            getWallet(walletID)
        }
    }

    private fun getWallet(walletID: Long?){
        viewModelScope.launch(Dispatchers.IO){
            _transactionListLiveData.postValue(walletDAO.getWalletWithID(walletID))
        }

    }

    fun sellData(symbol: String?, amount: String?){
        viewModelScope.launch(Dispatchers.IO) {
            if (!symbol.isNullOrEmpty() && !amount.isNullOrEmpty()) {
                try {
                    walletDAO.delete(Wallet(symbol = symbol, amount = amount))
                    Log.d("Delete","delete happened with symbol: $symbol and amount: $amount ")
                    walletDAO.fetchAll()
                }catch (e: Exception) {
                    e.fillInStackTrace()
                }
            }
        }
    }

    fun updateData(id: Long, symbol : String?, amount : String?){
        viewModelScope.launch(Dispatchers.IO) {
            if (!symbol.isNullOrEmpty() && !amount.isNullOrEmpty()) {
                walletDAO.update(Wallet(id, symbol = symbol, amount = amount))
                Log.d("update", "insert happened")
            }
        }
    }
}