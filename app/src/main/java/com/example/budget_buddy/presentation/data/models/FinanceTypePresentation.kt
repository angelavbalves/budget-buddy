package com.example.budget_buddy.presentation.data.models

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.example.budget_buddy.R
import com.example.budget_buddy.presentation.providers.ResourcesProvider

enum class FinanceTypePresentation(
    val title: String,
    @ColorRes val colorResId: Int,
    @DrawableRes val iconResId: Int?
) {
    Balance("Balanço", R.color.blue, null),
    Income("Receitas", R.color.green, R.drawable.cash_in),
    Expense("Despesas", R.color.red, R.drawable.cash_out),
    Investment("Investimentos", R.color.pink, R.drawable.invest),
    FutureExpense("Gastos Futuros", R.color.purple, R.drawable.future_expense),
    Unknown("Desconhecido", R.color.black, null);

    fun getColor(resourcesProvider: ResourcesProvider): Int {
        return resourcesProvider.getColor(colorResId)
    }

    fun getIcon(resourcesProvider: ResourcesProvider): Drawable? {
        return iconResId?.let { resourcesProvider.getDrawable(it) }
    }
}
