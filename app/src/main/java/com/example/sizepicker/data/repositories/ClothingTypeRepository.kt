package com.example.sizepicker.data.repositories

import androidx.lifecycle.LiveData
import com.example.sizepicker.data.daos.ClothingTypeDao
import com.example.sizepicker.data.entities.ClothingType

class ClothingTypeRepository(private val clothingTypeDao: ClothingTypeDao) {
    val getAll: LiveData<List<ClothingType>> = clothingTypeDao.getAll()
    val getLast: LiveData<ClothingType> = clothingTypeDao.getLast()

    suspend fun insertAll(vararg clothingTypes: ClothingType) {
        clothingTypeDao.insertAll(*clothingTypes)
    }

    suspend fun delete(clothingType: ClothingType) {
        clothingTypeDao.delete(clothingType)
    }

    suspend fun update(clothingType: ClothingType){
        clothingTypeDao.update(clothingType)
    }
}