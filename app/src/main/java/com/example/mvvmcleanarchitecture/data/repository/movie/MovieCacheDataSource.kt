package com.example.mvvmcleanarchitecture.data.repository.movie

import com.example.mvvmcleanarchitecture.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)

}