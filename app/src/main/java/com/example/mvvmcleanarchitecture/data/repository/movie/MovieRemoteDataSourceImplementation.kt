package com.example.mvvmcleanarchitecture.data.repository.movie

import com.example.mvvmcleanarchitecture.data.api.TMDBService
import com.example.mvvmcleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImplementation(
    private val tmdbService: TMDBService,
    private val apiKey:String)
: MovieRemoteDataSource {

    override suspend fun getMovies()
    : Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}