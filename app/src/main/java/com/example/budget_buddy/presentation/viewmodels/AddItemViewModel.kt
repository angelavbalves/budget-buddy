package com.example.budget_buddy.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budget_buddy.data.FinanceItem
import com.example.budget_buddy.data.mapperToEntity
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.data.repositories.FinanceItemRepository
import com.example.budget_buddy.presentation.data.mappers.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(private val repository: FinanceItemRepository) : ViewModel() {

    val itemIncome = FinanceType.Income.toPresentation()

    val itemExpenses = FinanceType.Expense.toPresentation()

    val itemFutureExpense = FinanceType.FutureExpense.toPresentation()

    val itemInvestment = FinanceType.Investment.toPresentation()

    fun addItem(financeItem: FinanceItem) = viewModelScope.launch(Dispatchers.IO) {
        repository.addFinanceItem(item = financeItem.mapperToEntity())
    }
}