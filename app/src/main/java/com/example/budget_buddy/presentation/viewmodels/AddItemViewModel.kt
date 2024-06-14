package com.example.budget_buddy.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.presentation.data.mappers.toPresentation

class AddItemViewModel : ViewModel() {

    val itemIncome = FinanceType.Income.toPresentation()

    val itemExpenses = FinanceType.Expense.toPresentation()

    val itemFutureExpense = FinanceType.FutureExpense.toPresentation()

    val itemInvestment = FinanceType.Investment.toPresentation()
}