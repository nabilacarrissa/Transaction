package com.nabilacarrissa.transaction.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nabilacarrissa.transaction.data.model.TransactionItem

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transaction_items ORDER BY id DESC")
    fun getAllTransactions(): LiveData<List<TransactionItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: TransactionItem)

    @Delete
    suspend fun delete(transaction: TransactionItem)
}
