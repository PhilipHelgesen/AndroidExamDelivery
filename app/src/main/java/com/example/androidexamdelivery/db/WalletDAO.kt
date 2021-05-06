package com.example.androidexamdelivery.db

import androidx.room.*
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
    @Query("select * from wallet_table")
    suspend fun fetchAll() : List<Wallet>

    @Query("select * from wallet_table where id = :walletID")
    suspend fun getWalletWithID(walletID: Long?) : Wallet


}