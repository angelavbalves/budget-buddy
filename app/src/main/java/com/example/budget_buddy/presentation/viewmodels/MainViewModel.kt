package com.example.budget_buddy.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.budget_buddy.data.models.FinanceItemHome
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.presentation.data.mappers.toPresentation
import com.example.budget_buddy.presentation.providers.ResourcesProvider

class MainViewModel(private val resourcesProvider: ResourcesProvider) : ViewModel() {
    val financeItems = listOf(
        FinanceItemHome(
            title = "Balanço total",
            balance = 0.000,
            type = FinanceType.Balance
        ),
        FinanceItemHome(
            title = "Receitas",
            balance = 5.000,
            type = FinanceType.Income
        ),
        FinanceItemHome(
            title = "Despesas",
            balance = 5.000,
            type = FinanceType.Expense
        ),
        FinanceItemHome(
            title = "Investimetnos",
            balance = 5.000,
            type = FinanceType.Investment
        ),
        FinanceItemHome(
            title = "Futuros Gastos",
            balance = 5.000,
            type = FinanceType.FutureExpense
        ),
    ).map { it.toPresentation(resourcesProvider = resourcesProvider) }
}

class MainViewModelFactory(private val resourcesProvider: ResourcesProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(resourcesProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
