package com.example.sizepicker.data.data_holders

import com.example.sizepicker.data.entities.BodyPart

data class SizeDataHolder(
    val sizeId: Int,
    val bodyPart: BodyPart,
    val minSizeCm: Float,
    val maxSizeCm: Float,
//    val sizesByStandards: MutableList<SizeByStandardDataHolder>
)
