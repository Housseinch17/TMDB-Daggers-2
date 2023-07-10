package com.example.mvvmcleanarchitecture.domain.movie

import com.example.mvvmcleanarchitecture.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}