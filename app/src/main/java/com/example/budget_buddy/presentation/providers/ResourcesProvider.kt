package com.example.budget_buddy.presentation.providers

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

class ResourcesProvider(private val context: Context) {

    fun getColor(@ColorRes colorResId: Int): Int {
        return ContextCompat.getColor(context, colorResId)
    }

    fun getDrawable(@DrawableRes drawableResId: Int): Drawable? {
        return ContextCompat.getDrawable(context, drawableResId)
    }
}