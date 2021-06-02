package com.example.sizepicker.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.sizepicker.data.entities.ClothingType
import com.example.sizepicker.data.entities.SizeByStandard

data class SizesOfClothingType(
    @Embedded
    val clothingType: ClothingType,
    @Relation(parentColumn = "id", entity = SizeByStandard::class, entityColumn = "clothingTypeId")
    val sizesOfStandard: List<SizeByStandard>
)
