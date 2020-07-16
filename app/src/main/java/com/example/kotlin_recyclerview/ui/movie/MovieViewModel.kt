package com.example.kotlin_recyclerview.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_recyclerview.data.models.Movie
import com.example.kotlin_recyclerview.data.repositories.MoviesRepository
import com.example.kotlin_recyclerview.utils.DispatchJob
import kotlinx.coroutines.Job

class MovieViewModel(private val repository: MoviesRepository) : ViewModel() {
    // This view model will communicate with our MoviesRepository
    // So we need an instance of MoviesRepository inside our MoviesViewModel class

    // Define private val of mutable live data of movies, type List<Movie>
    // Mutable data can be change/update(set), however not from outside of this view model
    private val _movieList = MutableLiveData<List<Movie>>()

    // Define public live data which can be access from outside of this view model
    // Live data only can be view(get), and cannot be update(set)
    // At the end we define getter which assigned to moviesList
    val moviesList: LiveData<List<Movie>> get() = _movieList

    private lateinit var job : Job

    fun getMovies() {
        job = DispatchJob.ioThenMain(
            { repository.getMovies() }, // execute the job
            { _movieList.value = it } // callback when the job finished,
            // we set to the mutable live data here
        )
    }

    override fun onCleared() {
        super.onCleared()
        // if the job is initialized then we cancel the job
        if(::job.isInitialized) job.cancel()
    }
}