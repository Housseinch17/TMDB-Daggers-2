package com.example.mvvmcleanarchitecture.data.repository.tvshow

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvLocalDataSource {
    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShow:List<TvShow>)
    suspend fun clearAll()
}