package com.example.budget_buddy.presentation.data.models

import android.graphics.Color
import android.graphics.drawable.Drawable

data class FinanceItemListPresentation(
    val description: String,
    val icon: Drawable? = null,
    val value: Double,
    val title: String,
    val color: Int
)
