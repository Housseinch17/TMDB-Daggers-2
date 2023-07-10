package com.example.mvvmcleanarchitecture.domain.movie

import com.example.mvvmcleanarchitecture.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() : List<Movie>?=movieRepository.updateMovies()

}