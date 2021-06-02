package com.example.sizepicker.data.entities

import androidx.room.Entity

@Entity(primaryKeys = ["clothingTypeId", "bodyPartId"])
data class ClothingTypeToBodyPart(
    val clothingTypeId: Int,
    val bodyPartId: Int
)
