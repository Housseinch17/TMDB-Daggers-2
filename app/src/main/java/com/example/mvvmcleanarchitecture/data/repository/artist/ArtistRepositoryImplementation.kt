package com.example.mvvmcleanarchitecture.data.repository.artist

import android.util.Log
import com.example.mvvmcleanarchitecture.domain.artist.ArtistRepository
import com.example.mvvmcleanarchitecture.data.model.artist.Artist
import com.example.mvvmcleanarchitecture.data.model.artist.ArtistList


class ArtistRepositoryImplementation(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromApi() : List<Artist>{
        lateinit var artistList:List<Artist>

        try{
            val response=artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList:List<Artist>

        try{
            artistList=artistLocalDataSource.getArtistsFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }
        else{
            artistList=getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList:List<Artist>

        try{
            artistList=artistCacheDataSource.getArtistsFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }
        else{
            artistList=getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }

}