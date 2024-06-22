package com.example.budget_buddy.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.budget_buddy.data.models.FinanceType

@Dao
interface FinanceItemDao {

    @Query("SELECT * FROM finance_items WHERE financeType = :type")
    suspend fun getAllItemsByType(type: FinanceType): List<FinanceItemEntity>

    @Query("SELECT SUM(value) FROM finance_items WHERE financeType = :type")
    suspend fun getTotalValueByType(type: FinanceType): Double?

    @Query("SELECT * FROM finance_items")
    fun fetchAllFinanceItems(): List<FinanceItemEntity>

    @Insert
    suspend fun addFinanceItem(financeItemEntity: FinanceItemEntity)
}
