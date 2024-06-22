package com.example.budget_buddy.data

import com.example.budget_buddy.data.database.FinanceItemEntity
import com.example.budget_buddy.data.models.FinanceType
import java.io.Serializable


data class FinanceItem(
    val title: String,
    val description: String? = null,
    val value: Double,
    val type: FinanceType
) : Serializable

fun FinanceItem.mapperToEntity() = FinanceItemEntity(
    title = this.title,
    description = this.description,
    value = this.value,
    financeType = this.type
)
