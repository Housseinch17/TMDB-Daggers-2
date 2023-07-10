package com.example.mvvmcleanarchitecture.data.repository.movie

import com.example.mvvmcleanarchitecture.data.model.movie.Movie

class MovieCacheDataSourceImplementation
    : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)

    }
}