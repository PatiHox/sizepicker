package com.example.sizepicker.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.sizepicker.data.entities.SizeByStandard
import com.example.sizepicker.data.entities.Standard

data class SizesOfStandard(
    @Embedded
    val standard: Standard,
    @Relation(parentColumn = "id", entity = SizeByStandard::class, entityColumn = "standardId")
    val sizesOfStandard: List<SizeByStandard>
)
