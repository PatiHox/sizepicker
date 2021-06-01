package com.example.sizepicker.fragments.main.recycler_view

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.sizepicker.data.entities.ClothingType
import com.example.sizepicker.databinding.ClothingTypeItemBinding
import kotlin.properties.Delegates


class ClothingTypeViewHolder(private val binding: ClothingTypeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var parentAdapter: ClothingTypeAdapter
    private var positionInAdapter by Delegates.notNull<Int>()
    private lateinit var boundClothingType: ClothingType

    fun bind(adapter: ClothingTypeAdapter, position: Int) {
        parentAdapter = adapter
        positionInAdapter = position
        boundClothingType = parentAdapter.getItemAt(positionInAdapter)

        onBind()
    }

    private fun onBind() {
//        val context = binding.root.context

        binding.tvClothingTitle.text = boundClothingType.name

        // ibOpen
        binding.ibOpen.setOnClickListener {
            val bundle = Bundle(1)
            bundle.putParcelable(
                "clothingType",
                boundClothingType
            )
            parentAdapter.navigateToClothingTypeFragment(bundle)
        }
    }


}