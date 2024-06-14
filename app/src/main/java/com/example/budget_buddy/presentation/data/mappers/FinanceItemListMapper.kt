package com.example.budget_buddy.presentation.data.mappers

import android.content.Context
import com.example.budget_buddy.data.models.FinanceItemList
import com.example.budget_buddy.presentation.data.models.FinanceItemListPresentation
import com.example.budget_buddy.presentation.providers.ResourcesProvider

fun FinanceItemList.toPresentation(resourcesProvider: ResourcesProvider): FinanceItemListPresentation {
    val typePresentation = financeType.toPresentation()
    return FinanceItemListPresentation(
        description = description,
        icon = typePresentation.getIcon(resourcesProvider),
        value = value,
        title = title,
        color = typePresentation.getColor(resourcesProvider)
    )
}