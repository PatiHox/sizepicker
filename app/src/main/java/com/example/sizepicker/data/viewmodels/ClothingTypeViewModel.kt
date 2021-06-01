package com.example.sizepicker.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sizepicker.data.AppDatabase
import com.example.sizepicker.data.entities.ClothingType
import com.example.sizepicker.data.repositories.ClothingTypeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClothingTypeViewModel(application: Application): AndroidViewModel(application) {
    val getAll: LiveData<List<ClothingType>>
    private val repository: ClothingTypeRepository

    init {
        val clothingTypeDao = AppDatabase.getInstance(application).clothingTypeDao()
        repository = ClothingTypeRepository(clothingTypeDao)
        getAll = repository.getAll
    }

    fun insertAll(vararg clothingTypes: ClothingType){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAll(*clothingTypes)
        }
    }

    fun delete(clothingType: ClothingType){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(clothingType)
        }
    }

    fun update(clothingType: ClothingType){
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(clothingType)
        }
    }
}