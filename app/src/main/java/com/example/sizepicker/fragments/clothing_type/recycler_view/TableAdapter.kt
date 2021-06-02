package com.example.sizepicker.fragments.clothing_type.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sizepicker.databinding.TableCellBinding

class TableAdapter(
    var list: MutableList<String>,
    val context: Context
) : RecyclerView.Adapter<TableAdapter.ViewHolder>() {
    class ViewHolder(val binding: TableCellBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TableCellBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textview.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}