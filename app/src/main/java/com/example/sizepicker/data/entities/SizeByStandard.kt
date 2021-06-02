package com.example.sizepicker.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "size_by_standard",
    foreignKeys = [
        ForeignKey(
            entity = Standard::class,
            parentColumns = ["id"],
            childColumns = ["standardId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ClothingType::class,
            parentColumns = ["id"],
            childColumns = ["clothingTypeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SizeByStandard(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val size: String,
    val standardId: Int,
    val clothingTypeId: Int
)
