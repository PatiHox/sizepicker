package com.example.sizepicker.fragments.main.recycler_view

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sizepicker.R
import com.example.sizepicker.data.entities.ClothingType
import com.example.sizepicker.databinding.ClothingTypeItemBinding


class ClothingTypeAdapter(
    private var clothingTypes: MutableList<ClothingType>,
    private val navController: NavController
) : RecyclerView.Adapter<ClothingTypeViewHolder>() {
    /*lateinit var R: Resources
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        R = recyclerView.context.resources
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothingTypeViewHolder {
        return ClothingTypeViewHolder(
            ClothingTypeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ClothingTypeViewHolder, position: Int) {
        holder.bind(this, position)
    }

    override fun getItemCount(): Int {
        return clothingTypes.size
    }

    fun getItemAt(position: Int): ClothingType {
        return clothingTypes[position]
    }

    fun getItems(): MutableList<ClothingType> {
        return clothingTypes
    }

    fun removeItemAt(position: Int): ClothingType {
//        notifyItemRemoved(position)
        notifyDataSetChanged()
        return clothingTypes.removeAt(position)
    }

    fun updateItemAt(position: Int, clothingType: ClothingType) {
        clothingTypes[position] = clothingType
        notifyDataSetChanged()
        // notifyItemChanged(position)
    }

    fun setTransactions(vararg clothingTypes: ClothingType) {
        this.clothingTypes = clothingTypes.toMutableList()
        notifyDataSetChanged()
    }


    fun navigateToClothingTypeFragment(bundle: Bundle){
        navController.navigate(R.id.action_MainFragment_to_ClothingTypeFragment, bundle)
    }
}