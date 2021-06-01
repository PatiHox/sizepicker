package com.example.sizepicker.fragments.main.recycler_view

import android.text.Editable
import android.text.InputType
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.sizepicker.data.entities.ClothingType
import com.example.sizepicker.databinding.ClothingTypeItemBinding
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import kotlin.properties.Delegates


class ClothingTypeViewHolder(val binding: ClothingTypeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    lateinit var parentAdapter: ClothingTypeAdapter
    var positionInAdapter by Delegates.notNull<Int>()
    lateinit var boundClothingType: ClothingType

    fun bind(adapter: ClothingTypeAdapter, position: Int) {
        parentAdapter = adapter
        positionInAdapter = position
        boundClothingType = parentAdapter.getItemAt(positionInAdapter)

        onBind()
    }

    private fun onBind() {
        val context = binding.root.context

        binding.tvClothingTitle.text = boundClothingType.name

        // bMore
        binding.ibOpen.setOnClickListener {

        }
    }


}