package com.example.androidexamdelivery.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.androidexamdelivery.entities.Wallet

@Dao
interface WalletDAO {
    @Insert
    suspend fun insert(wallet: Wallet) {
    }
    @Update
    suspend fun update(wallet: Wallet) {
    }
    @Delete
    suspend fun delete(wallet: Wallet) {
    }

}