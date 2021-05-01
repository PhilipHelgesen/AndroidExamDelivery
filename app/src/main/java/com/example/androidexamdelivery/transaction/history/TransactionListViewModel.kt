package com.example.androidexamdelivery.transaction.history

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexamdelivery.db.DataBase
import com.example.androidexamdelivery.db.WalletDAO
import com.example.androidexamdelivery.entities.Wallet

import kotlinx.coroutines.launch

class TransactionListViewModel : ViewModel() {

    private val _transactionListLiveData : MutableLiveData<List<Wallet>> = MutableLiveData()
    val transactionListLiveData : LiveData<List<Wallet>> = _transactionListLiveData

    private lateinit var walletDAO: WalletDAO

    fun init(context: Context){
        walletDAO = DataBase.getDatabase(context).getWalletDAO()
        fetchData()
    }

    fun fetchData(){
        viewModelScope.launch{
            val list = walletDAO.fetchAll()
            _transactionListLiveData.value = list
        }
    }
}