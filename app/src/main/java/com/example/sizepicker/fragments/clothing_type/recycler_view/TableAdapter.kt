package com.example.sizepicker.fragments.clothing_type.recycler_view

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sizepicker.databinding.TableCellBinding

class TableAdapter(
    var head: MutableList<String>,
    var list: MutableList<String>,
    val context: Context
) : RecyclerView.Adapter<TableAdapter.ViewHolder>() {
    class ViewHolder(val binding: TableCellBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TableCellBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position < head.size) {
            holder.binding.textview.setTypeface(holder.binding.textview.typeface, Typeface.BOLD)
            holder.binding.textview.text = head[position]
        } else {
            val metrics = context.resources.displayMetrics
            val heightPixels: Int =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 45f, metrics).toInt()
            val layoutParams = RelativeLayout.LayoutParams(
                holder.binding.root.layoutParams.width,
                heightPixels
            )
            holder.binding.root.layoutParams = layoutParams
            holder.binding.textview.text = list[position - head.size]
        }
    }

    override fun getItemCount(): Int {
        return head.size + list.size
    }
}