package com.nabilacarrissa.transaction.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_items")
data class TransactionItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val itemName: String,
    val quantity: Int,
    val pricePerItem: Double
) {
    val totalPrice: Double
        get() = quantity * pricePerItem
}
