package com.nabilacarrissa.transaction.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nabilacarrissa.transaction.databinding.ItemTransactionBinding
import com.nabilacarrissa.transaction.data.model.TransactionItem

class TransactionAdapter(private val list: List<TransactionItem>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(private val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TransactionItem) {
            binding.tvName.text = item.itemName
            binding.tvQty.text = "Qty: ${item.quantity}"
            binding.tvPrice.text = "Rp ${item.pricePerItem}"
            binding.tvTotal.text = "Total: Rp ${item.totalPrice}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
