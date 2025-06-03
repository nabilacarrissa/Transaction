package com.nabilacarrissa.transaction.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.nabilacarrissa.transaction.data.database.TransactionDatabase
import com.nabilacarrissa.transaction.data.model.TransactionItem
import kotlinx.coroutines.launch

class TransactionViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = TransactionDatabase.getDatabase(application).transactionDao()
    val allTransactions = dao.getAllTransactions()

    fun insert(transaction: TransactionItem) {
        viewModelScope.launch {
            dao.insert(transaction)
        }
    }

    fun delete(transaction: TransactionItem) {
        viewModelScope.launch {
            dao.delete(transaction)
        }
    }
}
