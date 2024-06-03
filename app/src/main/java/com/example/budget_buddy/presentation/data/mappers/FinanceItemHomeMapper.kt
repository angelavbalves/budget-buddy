package com.example.budget_buddy.presentation.data.mappers

import android.content.Context
import com.example.budget_buddy.data.models.FinanceItemHome
import com.example.budget_buddy.presentation.data.models.FinanceItemHomePresentation

fun FinanceItemHome.toPresentation(context: Context) : FinanceItemHomePresentation =
    FinanceItemHomePresentation(
        title = title,
        balance = balance.toMoney(),
        textColor = type.toPresentation().getColor(context),
        type = type
    )

fun Double.toMoney() = "R$ ${this}"