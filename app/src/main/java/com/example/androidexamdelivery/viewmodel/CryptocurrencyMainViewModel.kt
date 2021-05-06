package com.example.androidexamdelivery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexamdelivery.API
import com.example.androidexamdelivery.JsonRes
import com.example.androidexamdelivery.activity.CryptoListMainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CryptocurrencyMainViewModel : ViewModel() {

    val coincapService = API.coincapService

    val currentAsset = MutableLiveData<JsonRes>()

    val navBarTitle = CryptoListMainActivity.CustomViewHolder.CRYPTO_ID_KEY

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val data = coincapService.getCurrencyAssets(navBarTitle)
            currentAsset.postValue(data)
        }
    }

}