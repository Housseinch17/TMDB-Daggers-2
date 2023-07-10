package com.example.mvvmcleanarchitecture.domain.tvshow

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?

}