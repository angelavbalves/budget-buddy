package com.example.budget_buddy.data.models

import com.example.budget_buddy.R
import java.io.Serializable

data class FinanceItemHome(
    val title: String,
    val balance: Double,
    val type: FinanceType
)

enum class FinanceType(val title: String) : Serializable {
    Balance("Balanço"),
    Income("Receitas"),
    Expense("Despesas"),
    Investment("Investimentos"),
    FutureExpense("Gastos Futuros"),
    Unknown("")
}