package com.example.mvvmcleanarchitecture.data.repository.artist

import com.example.mvvmcleanarchitecture.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>

}