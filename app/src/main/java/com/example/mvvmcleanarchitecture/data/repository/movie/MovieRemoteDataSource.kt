package com.example.mvvmcleanarchitecture.data.repository.movie

import com.example.mvvmcleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>

}