package com.example.sizepicker.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "standards")
data class Standard(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String
)