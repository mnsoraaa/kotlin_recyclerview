package com.example.kotlin_recyclerview.data.repositories

import com.example.kotlin_recyclerview.data.interfaces.MoviesApi
import com.example.kotlin_recyclerview.utils.ApiRequest

class MoviesRepository(private val api : MoviesApi) : ApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }
}