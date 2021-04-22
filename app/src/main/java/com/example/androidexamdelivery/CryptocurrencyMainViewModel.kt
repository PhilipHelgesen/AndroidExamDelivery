package com.example.androidexamdelivery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CryptocurrencyMainViewModel : ViewModel() {

    val coincapService = API.coincapService

    val currentAsset = MutableLiveData<JsonRes>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val asset = coincapService.getCurrencyAssets("ethereum")
            currentAsset.postValue(asset)
        }
    }

}