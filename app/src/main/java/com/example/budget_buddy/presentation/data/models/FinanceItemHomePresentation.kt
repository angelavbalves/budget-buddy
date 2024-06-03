package com.example.budget_buddy.presentation.data.models

import com.example.budget_buddy.data.models.FinanceType

data class FinanceItemHomePresentation(
    val title: String,
    val balance: String,
    val textColor: Int,
    val type: FinanceType
)