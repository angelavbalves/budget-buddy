package com.example.budget_buddy.presentation.providers

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import javax.inject.Singleton

class ResourcesProvider(private val context: Context) {

    fun getColor(@ColorRes colorResId: Int): Int {
        val color = ContextCompat.getColor(context, colorResId)
        Log.d("ResourcesProvider", "Color fetched for resId $colorResId: $color")
        return color
    }

    fun getDrawable(@DrawableRes drawableResId: Int): Drawable? {
        val drawable = ContextCompat.getDrawable(context, drawableResId)
        Log.d("ResourcesProvider", "Drawable fetched for resId $drawableResId: $drawable")
        return drawable
    }
}