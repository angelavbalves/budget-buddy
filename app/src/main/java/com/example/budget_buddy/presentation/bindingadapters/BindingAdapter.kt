package com.example.budget_buddy.presentation.bindingadapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:srcCompatDrawable")
fun ImageView.setSrcCompatDrawable(drawable: Drawable?) {
    drawable?.let {
        this.setImageDrawable(it)
    }
}
