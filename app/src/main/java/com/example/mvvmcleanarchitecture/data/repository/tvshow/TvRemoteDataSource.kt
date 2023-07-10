package com.example.mvvmcleanarchitecture.data.repository.tvshow

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvRemoteDataSource {
    suspend fun getTvShows() : Response<TvShowList>

}