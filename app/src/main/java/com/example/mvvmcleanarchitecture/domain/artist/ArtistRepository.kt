package com.example.mvvmcleanarchitecture.domain.artist

import com.example.mvvmcleanarchitecture.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}