package com.example.mvvmcleanarchitecture.data.repository.tvshow

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

class TvCacheDataSourceImplementation
    : TvCacheDataSource {

    private var tvShowList=ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
    return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList=ArrayList(tvShows)
    }
}