package com.example.mvvmcleanarchitecture.data.repository.artist

import com.example.mvvmcleanarchitecture.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}