package com.example.mvvmcleanarchitecture.data.repository.movie

import android.util.Log
import com.example.mvvmcleanarchitecture.domain.movie.MovieRepository
import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.data.model.movie.MovieList

class MovieRepositoryImplementation(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromApi() : List<Movie>{
        lateinit var movieList:List<Movie>

        try{
            val response=movieRemoteDataSource.getMovies()
            val body=response.body()
            if(body!=null){
                movieList= body.movies
            }

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>

        try{
            movieList=movieLocalDataSource.getMoviesFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }
        else{
            movieList=getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>

        try{
            movieList=movieCacheDataSource.getMoviesFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }
        else{
            movieList=getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}