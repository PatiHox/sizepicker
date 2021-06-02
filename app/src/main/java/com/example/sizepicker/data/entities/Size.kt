package com.example.sizepicker.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["bodyPartId", "sizeByStandardId"])
data class Size (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val bodyPartId: Int,
    val minSizeCm: Float,
    val maxSizeCm: Float
        )