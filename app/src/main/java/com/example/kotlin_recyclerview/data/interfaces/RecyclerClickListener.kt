package com.example.kotlin_recyclerview.data.interfaces

import android.view.View
import com.example.kotlin_recyclerview.data.models.Movie

interface RecyclerClickListener {

    fun onRecyclerViewClickListener(view: View, movie : Movie)
}