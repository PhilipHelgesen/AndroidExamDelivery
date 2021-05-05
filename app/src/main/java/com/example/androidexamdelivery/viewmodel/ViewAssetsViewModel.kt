package com.example.androidexamdelivery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexamdelivery.API
import com.example.androidexamdelivery.AllAssetsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewAssetsViewModel : ViewModel() {

    val coincapService = API.coincapService

    private val _allAssets = MutableLiveData<AllAssetsList>()
    val allAssetsList: LiveData<AllAssetsList> get() = _allAssets

    fun fetchCurrencyData() {
        viewModelScope.launch(Dispatchers.IO) {
            val assets = coincapService.getAllCurrencyAssets()
            _allAssets.postValue(assets)
        }

    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val assets = coincapService.getAllCurrencyAssets()
            _allAssets.postValue(assets)
        }
    }

}