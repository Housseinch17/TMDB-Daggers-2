package com.example.mvvmcleanarchitecture.data.repository.tvshow

import com.example.mvvmcleanarchitecture.data.api.TMDBService
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShowList
import retrofit2.Response

class TvRemoteSourceImplementation(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : TvRemoteDataSource {

    override suspend fun getTvShows()
    : Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}