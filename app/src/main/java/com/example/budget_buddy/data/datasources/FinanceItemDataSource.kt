package com.example.budget_buddy.data.datasources

import com.example.budget_buddy.data.database.FinanceItemEntity
import com.example.budget_buddy.data.models.FinanceType

interface FinanceItemDataSource {
    fun fetchAllFinanceItems(): List<FinanceItemEntity>
    suspend fun getAllItemsByType(type: FinanceType): List<FinanceItemEntity>
    suspend fun getTotalValueByType(type: FinanceType): Double?
    suspend fun addFinanceItem(item: FinanceItemEntity)
}