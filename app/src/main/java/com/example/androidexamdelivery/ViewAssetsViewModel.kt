package com.example.androidexamdelivery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewAssetsViewModel : ViewModel() {

    val coincapService = API.coincapService

    val allAssets = MutableLiveData<ListAllAssets>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val assets = coincapService.getAllCurrencyAssets()
            allAssets.postValue(assets)
        }
    }

}