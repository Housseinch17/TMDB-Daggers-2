package com.example.mvvmcleanarchitecture.data.repository.movie

import com.example.mvvmcleanarchitecture.data.db.MovieDao
import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImplementation(private val movieDao: MovieDao)
    : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {

        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}