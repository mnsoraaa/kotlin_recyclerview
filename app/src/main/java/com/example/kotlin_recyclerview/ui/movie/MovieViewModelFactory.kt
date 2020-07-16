package com.example.kotlin_recyclerview.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_recyclerview.data.repositories.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(private val repository: MoviesRepository) :
    ViewModelProvider.NewInstanceFactory() {

    // override fun create which return,
    // or in this case pass MoviesRepository to the MoviesViewModel
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(repository) as T
    }
}