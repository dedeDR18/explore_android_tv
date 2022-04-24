package com.example.mytrainingtv.util

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun loadBitmapIntoImageView(
    context: Context,
    imageUrl: String?,
    @DrawableRes defaultImage: Int,
    imageView: ImageView
){
    Glide.with(context)
        .load(imageUrl)
        .centerCrop()
        .error(defaultImage)
        .into(imageView)
}