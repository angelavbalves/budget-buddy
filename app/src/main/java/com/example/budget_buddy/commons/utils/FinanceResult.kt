package com.example.budget_buddy.commons.utils

sealed class FinanceResult<out T> {
    data object Loading: FinanceResult<Nothing>()
    data class Success<out T>(val data: T): FinanceResult<T>()
    data class Error(val e: Exception): FinanceResult<Nothing>()
}