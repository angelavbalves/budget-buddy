package com.example.budget_buddy.data.repositories

import com.example.budget_buddy.data.database.FinanceItemEntity
import com.example.budget_buddy.data.datasources.FinanceItemDataSource
import com.example.budget_buddy.data.models.FinanceType
import javax.inject.Inject

class FinanceItemRepository @Inject constructor(
    private val dataSource: FinanceItemDataSource
) {

    fun fetchAllFinanceItems(): List<FinanceItemEntity> {
        return dataSource.fetchAllFinanceItems()
    }

    suspend fun addFinanceItem(item: FinanceItemEntity) {
        dataSource.addFinanceItem(item)
    }

    suspend fun getAllItemsByType(type: FinanceType): List<FinanceItemEntity> {
        return dataSource.getAllItemsByType(type)
    }

    suspend fun getTotalValueByType(type: FinanceType): Double {
        return dataSource.getTotalValueByType(type) ?: 0.0
    }
}
