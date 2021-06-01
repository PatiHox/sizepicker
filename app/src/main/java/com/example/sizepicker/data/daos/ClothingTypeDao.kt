package com.example.budgetplanning.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.budgetplanning.data.entities.BalanceChange
import com.example.budgetplanning.data.entities.ClothingType

@Dao
interface ClothingTypeDao {
    @Query("SELECT * FROM `bal_change` ORDER BY id DESC")
    fun getAll(): LiveData<List<ClothingType>>

    @Query("SELECT * FROM `bal_change` ORDER BY id DESC LIMIT 1")
    fun getLast(): LiveData<ClothingType>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg balanceChanges: ClothingType)

    @Delete
    suspend fun delete(balanceChange: ClothingType)

    @Update
    suspend fun update(balanceChange: ClothingType)
}