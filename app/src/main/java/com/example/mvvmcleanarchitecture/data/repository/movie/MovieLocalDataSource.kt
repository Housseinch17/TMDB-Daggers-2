package com.example.mvvmcleanarchitecture.data.repository.movie

import com.example.mvvmcleanarchitecture.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()

}