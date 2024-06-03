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

class MainViewModel(val context: Context) : ViewModel() {
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
    ).map { it.toPresentation(context = context) }
}

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
