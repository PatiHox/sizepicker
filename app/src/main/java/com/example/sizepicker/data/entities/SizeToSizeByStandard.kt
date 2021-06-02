package com.example.sizepicker.data.entities

import androidx.room.Entity

@Entity(primaryKeys = ["sizeId", "sizeByStandardId"])
data class SizeToSizeByStandard(
    val sizeId: Int,
    val sizeByStandardId: Int
)
