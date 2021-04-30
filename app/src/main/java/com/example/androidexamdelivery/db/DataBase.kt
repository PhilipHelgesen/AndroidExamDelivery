package com.example.androidexamdelivery.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidexamdelivery.entities.Wallet

const val DATABASE_NAME: String = "wallet_database"

@Database(entities = [Wallet::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun getWalletDAO() :WalletDAO

    companion object {
        private var db: DataBase? = null

        fun getDatabase(context: Context): DataBase{

            val newDB = db ?: Room.databaseBuilder(context,
                DataBase::class.java, DATABASE_NAME).build()

            return newDB.also { db = it }
        }
    }
}