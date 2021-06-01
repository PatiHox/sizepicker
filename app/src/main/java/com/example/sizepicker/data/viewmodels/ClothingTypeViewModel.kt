package com.example.budgetplanning.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.budgetplanning.data.AppDatabase
import com.example.budgetplanning.data.entities.BalanceChange
import com.example.budgetplanning.data.repositories.ClothingTypeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClothingTypeViewModel(application: Application): AndroidViewModel(application) {
    val getAll: LiveData<List<BalanceChange>>
    val getLast: LiveData<BalanceChange>
    private val repository: ClothingTypeRepository

    init {
        val balanceChangeDao = AppDatabase.getInstance(application).balanceChangeDao()
        repository = ClothingTypeRepository(balanceChangeDao)
        getAll = repository.getAll
        getLast = repository.getLast
    }

    fun insertAll(vararg balanceChanges: BalanceChange){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAll(*balanceChanges)
        }
    }

    fun delete(balanceChange: BalanceChange){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(balanceChange)
        }
    }

    fun update(balanceChange: BalanceChange){
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(balanceChange)
        }
    }
}