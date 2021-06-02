package com.example.sizepicker.data.entities

import androidx.room.PrimaryKey

data class BodyPart(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String
)