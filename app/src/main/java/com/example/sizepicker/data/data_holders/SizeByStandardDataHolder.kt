package com.example.sizepicker.data.data_holders

import com.example.sizepicker.data.entities.ClothingType
import com.example.sizepicker.data.entities.Standard

data class SizeByStandardDataHolder(
    val clothingType: ClothingType,
    val standard: Standard,
    val size: String,
    val sizes: MutableList<SizeDataHolder>
    )