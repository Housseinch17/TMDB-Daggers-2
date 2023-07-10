package com.example.mvvmcleanarchitecture.domain.artist

import com.example.mvvmcleanarchitecture.data.model.artist.Artist

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>?=artistRepository.getArtists()

}