package com.example.mvvmcleanarchitecture.data.repository.tvshow

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvCacheDataSource {
    suspend fun getTvShowsFromCache() : List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)

}