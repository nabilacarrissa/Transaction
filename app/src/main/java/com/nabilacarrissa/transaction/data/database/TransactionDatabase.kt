package com.nabilacarrissa.transaction.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nabilacarrissa.transaction.data.dao.TransactionDao
import com.nabilacarrissa.transaction.data.model.TransactionItem

@Database(entities = [TransactionItem::class], version = 1, exportSchema = false)
abstract class TransactionDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

    companion object {
        @Volatile private var instance: TransactionDatabase? = null

        fun getDatabase(context: Context): TransactionDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    TransactionDatabase::class.java,
                    "transaction_db"
                ).build().also { instance = it }
            }
    }
}
