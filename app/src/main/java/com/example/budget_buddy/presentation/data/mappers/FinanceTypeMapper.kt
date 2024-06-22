package com.example.budget_buddy.presentation.data.mappers

import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.presentation.data.models.FinanceTypePresentation

fun FinanceType.toPresentation() : FinanceTypePresentation =
    when (this) {
        FinanceType.Balance -> FinanceTypePresentation.Balance
        FinanceType.Income -> FinanceTypePresentation.Income
        FinanceType.Investment -> FinanceTypePresentation.Investment
        FinanceType.Expense -> FinanceTypePresentation.Expense
        FinanceType.FutureExpense -> FinanceTypePresentation.FutureExpense
        FinanceType.Unknown -> FinanceTypePresentation.Unknown
    }