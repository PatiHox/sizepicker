package com.example.budgetplanning.fragments.first.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetplanning.databinding.TransactionItemBinding


class ClothingTypeAdapter(
    private var transactions: MutableList<Transaction>,
    val transactionViewModel: TransactionViewModel
) : RecyclerView.Adapter<ClothingTypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothingTypeViewHolder {
        return ClothingTypeViewHolder(
            TransactionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ClothingTypeViewHolder, position: Int) {
        holder.bind(this, position)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    fun getItemAt(position: Int): Transaction {
        return transactions[position]
    }

    fun getItems(): MutableList<Transaction> {
        return transactions
    }

    fun removeItemAt(position: Int): Transaction {
//        notifyItemRemoved(position)
        notifyDataSetChanged()
        return transactions.removeAt(position)
    }

    fun updateItemAt(position: Int, newTransaction: Transaction) {
        transactions[position] = newTransaction
        notifyDataSetChanged()
        // notifyItemChanged(position)
    }

    fun setTransactions(vararg transactions: Transaction) {
        this.transactions = transactions.toMutableList()
        notifyDataSetChanged()
    }

}