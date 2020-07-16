package com.example.kotlin_recyclerview.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(imageView : ImageView, url: String){
    Glide.with(imageView).load(url).into(imageView)
}