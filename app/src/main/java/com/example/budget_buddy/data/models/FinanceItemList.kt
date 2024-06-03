package com.example.budget_buddy.data.models

import java.io.Serializable

data class FinanceItemList(
    val description: String,
    val financeType: FinanceType,
    val value: Double,
    val title: String
) : Serializable