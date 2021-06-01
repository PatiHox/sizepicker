package com.example.sizepicker.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sizepicker.data.entities.ClothingType

@Dao
interface ClothingTypeDao {
    @Query("SELECT * FROM `clothing_types` ORDER BY id DESC")
    fun getAll(): LiveData<List<ClothingType>>

    @Query("SELECT * FROM `clothing_types` ORDER BY id DESC LIMIT 1")
    fun getLast(): LiveData<ClothingType>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg clothingTypes: ClothingType)

    @Delete
    suspend fun delete(clothingType: ClothingType)

    @Update
    suspend fun update(clothingType: ClothingType)
}