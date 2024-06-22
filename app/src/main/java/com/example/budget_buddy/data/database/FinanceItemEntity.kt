package com.example.budget_buddy.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.budget_buddy.data.models.FinanceItemHome
import com.example.budget_buddy.data.models.FinanceItemList
import com.example.budget_buddy.data.models.FinanceType

@Entity(tableName = "finance_items")
data class FinanceItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String? = null,
    val value: Double,
    val financeType: FinanceType
)

fun FinanceItemEntity.toDomainModelList(): FinanceItemList {
    return FinanceItemList(
        financeType = this.financeType,
        description = this.description ?: "",
        value = this.value,
        title = this.title
    )
}