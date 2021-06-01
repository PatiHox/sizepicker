package com.example.budgetplanning.data.repositories

import androidx.lifecycle.LiveData
import com.example.budgetplanning.data.daos.ClothingTypeDao
import com.example.budgetplanning.data.entities.BalanceChange

class ClothingTypeRepository(private val clothingTypeDao: ClothingTypeDao) {
    val getAll: LiveData<List<BalanceChange>> = clothingTypeDao.getAll()
    val getLast: LiveData<BalanceChange> = clothingTypeDao.getLast()

    suspend fun insertAll(vararg balanceChanges: BalanceChange) {
        clothingTypeDao.insertAll(*balanceChanges)
    }

    suspend fun delete(balanceChange: BalanceChange) {
        clothingTypeDao.delete(balanceChange)
    }

    suspend fun update(balanceChange: BalanceChange){
        clothingTypeDao.update(balanceChange)
    }
}