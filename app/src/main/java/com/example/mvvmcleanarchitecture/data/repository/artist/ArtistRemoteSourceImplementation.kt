package com.example.mvvmcleanarchitecture.data.repository.artist

import com.example.mvvmcleanarchitecture.data.api.TMDBService
import com.example.mvvmcleanarchitecture.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteSourceImplementation(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : ArtistRemoteDataSource {
    override suspend fun getArtists()
    : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}