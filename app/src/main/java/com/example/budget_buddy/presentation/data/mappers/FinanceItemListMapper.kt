package com.example.budget_buddy.presentation.data.mappers

import android.content.Context
import com.example.budget_buddy.data.models.FinanceItemList
import com.example.budget_buddy.presentation.data.models.FinanceItemListPresentation

fun FinanceItemList.toPresentation(context: Context) : FinanceItemListPresentation =
    FinanceItemListPresentation(
        description = description,
        icon = financeType.toPresentation().getIcon(context),
        value = value,
        title = title,
        color = financeType.toPresentation().getColor(context)
    )