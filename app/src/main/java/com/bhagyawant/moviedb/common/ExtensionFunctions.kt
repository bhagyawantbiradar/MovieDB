package com.bhagyawant.moviedb.common

import android.R
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun AppCompatImageView.loadImageUrl(imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Picasso.get().load(imageUrl).into(this)
    }
}



fun String.toListOfStrings(): List<String> {
    return this.split(",").map { it.trim() }
}