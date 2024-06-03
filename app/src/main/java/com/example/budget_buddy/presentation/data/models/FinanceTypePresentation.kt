package com.example.budget_buddy.presentation.data.models

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.example.budget_buddy.R

enum class FinanceTypePresentation(
    val title: String,
    @ColorRes val colorResId: Int,
    @DrawableRes val iconResId: Int?
) {
    Balance("Balanço Total", R.color.blue, null),
    Income("Receitas", R.color.green, R.drawable.cash_in),
    Expense("Despesas", R.color.red, R.drawable.cash_out),
    Investment("Investimentos", R.color.pink, R.drawable.invest),
    FutureExpense("Gastos Futuros", R.color.purple, R.drawable.future_expense);

    fun getColor(context: Context): Int {
        return ContextCompat.getColor(context, colorResId)
    }

    fun getIcon(context: Context): Drawable? {
        return iconResId?.let { ContextCompat.getDrawable(context, it) }
    }
}