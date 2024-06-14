package com.example.budget_buddy.presentation.data.mappers

import com.example.budget_buddy.data.models.FinanceItemHome
import com.example.budget_buddy.presentation.data.models.FinanceItemHomePresentation
import com.example.budget_buddy.presentation.providers.ResourcesProvider

fun FinanceItemHome.toPresentation(resourcesProvider: ResourcesProvider): FinanceItemHomePresentation {
    val typePresentation = type.toPresentation()
    return FinanceItemHomePresentation(
        title = title,
        balance = balance.toMoney(),
        textColor = resourcesProvider.getColor(typePresentation.colorResId),
        type = type
    )
}

fun Double.toMoney() = "R$ ${this}"
