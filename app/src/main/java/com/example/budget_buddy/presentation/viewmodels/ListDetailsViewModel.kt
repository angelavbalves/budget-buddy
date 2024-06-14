package com.example.budget_buddy.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.budget_buddy.data.models.FinanceItemList
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.presentation.data.mappers.toPresentation
import com.example.budget_buddy.presentation.data.models.FinanceItemListPresentation
import com.example.budget_buddy.presentation.providers.ResourcesProvider

class ListDetailsViewModel(val resourcesProvider: ResourcesProvider) : ViewModel() {
    private val financeItems = listOf(
        FinanceItemList(
            title = "Balanço total",
            description = "Descrição do balanço total",
            value = 0.0,
            financeType = FinanceType.Balance
        ),
        FinanceItemList(
            title = "Receitas",
            description = "Descrição das receitas",
            value = 5000.0,
            financeType = FinanceType.Income
        ),
        FinanceItemList(
            title = "Despesas",
            description = "Descrição das despesas",
            value = 5000.0,
            financeType = FinanceType.Expense
        ),
        FinanceItemList(
            title = "Investimentos",
            description = "Descrição dos investimentos",
            value = 5000.0,
            financeType = FinanceType.Investment
        ),
        FinanceItemList(
            title = "Futuros Gastos",
            description = "Descrição dos futuros gastos",
            value = 5000.0,
            financeType = FinanceType.FutureExpense
        ),
        FinanceItemList(
            title = "Balanço total",
            description = "Descrição do balanço total",
            value = 0.0,
            financeType = FinanceType.Balance
        ),
        FinanceItemList(
            title = "Receitas",
            description = "Descrição das receitas",
            value = 5000.0,
            financeType = FinanceType.Income
        ),
        FinanceItemList(
            title = "Despesas",
            description = "Descrição das despesas",
            value = 5000.0,
            financeType = FinanceType.Expense
        ),
        FinanceItemList(
            title = "Investimentos",
            description = "Descrição dos investimentos",
            value = 5000.0,
            financeType = FinanceType.Investment
        ),
        FinanceItemList(
            title = "Futuros Gastos",
            description = "Descrição dos futuros gastos",
            value = 5000.0,
            financeType = FinanceType.FutureExpense
        ), FinanceItemList(
            title = "Balanço total",
            description = "Descrição do balanço total",
            value = 0.0,
            financeType = FinanceType.Balance
        ),
        FinanceItemList(
            title = "Receitas",
            description = "Descrição das receitas",
            value = 5000.0,
            financeType = FinanceType.Income
        ),
        FinanceItemList(
            title = "Despesas",
            description = "Descrição das despesas",
            value = 5000.0,
            financeType = FinanceType.Expense
        ),
        FinanceItemList(
            title = "Investimentos",
            description = "Descrição dos investimentos",
            value = 5000.0,
            financeType = FinanceType.Investment
        ),
        FinanceItemList(
            title = "Futuros Gastos",
            description = "Descrição dos futuros gastos",
            value = 5000.0,
            financeType = FinanceType.FutureExpense
        )
    )

    fun getForType(type: FinanceType): List<FinanceItemListPresentation> {
        return financeItems.filter { it.financeType == type }.map { it.toPresentation(resourcesProvider) }
    }
}

class ListDetailsViewModelFactory(private val resourcesProvider: ResourcesProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListDetailsViewModel(resourcesProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}