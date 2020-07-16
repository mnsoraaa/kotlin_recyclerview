package com.example.kotlin_recyclerview.data.interfaces

import com.example.kotlin_recyclerview.data.models.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    // Wherever we called MoviesApi(), meaning that we call this invoke() function
    // From there we can call any function inside this interface
    // Example: MoviesApi().getMovies(), below function
    companion object {
        operator fun invoke() : MoviesApi {
            // Create retrofit instance
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(MoviesApi::class.java)
        }
    }

    @GET("movies")
    suspend fun getMovies() : Response<List<Movie>>
}