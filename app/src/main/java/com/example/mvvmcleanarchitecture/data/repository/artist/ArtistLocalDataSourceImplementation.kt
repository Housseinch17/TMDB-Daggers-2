package com.example.mvvmcleanarchitecture.data.repository.artist

import com.example.mvvmcleanarchitecture.data.db.ArtistDao
import com.example.mvvmcleanarchitecture.data.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImplementation(private val artistDao: ArtistDao)
    : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
        artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
         artistDao.deleteAllArtists()
    }
}


}