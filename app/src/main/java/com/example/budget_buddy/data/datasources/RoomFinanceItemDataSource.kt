package com.example.budget_buddy.data.datasources

import com.example.budget_buddy.data.database.FinanceItemDao
import com.example.budget_buddy.data.database.FinanceItemEntity
import com.example.budget_buddy.data.models.FinanceType

class RoomFinanceItemDataSource(private val dao: FinanceItemDao) : FinanceItemDataSource {
    override fun fetchAllFinanceItems(): List<FinanceItemEntity> = dao.fetchAllFinanceItems()
    override suspend fun getAllItemsByType(type: FinanceType): List<FinanceItemEntity> {
        return dao.getAllItemsByType(type)
    }

    override suspend fun getTotalValueByType(type: FinanceType): Double? {
        return dao.getTotalValueByType(type)
    }

    override suspend fun addFinanceItem(item: FinanceItemEntity) {
        dao.addFinanceItem(item)
    }
}