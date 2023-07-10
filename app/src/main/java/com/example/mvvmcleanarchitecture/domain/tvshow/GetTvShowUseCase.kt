package com.example.mvvmcleanarchitecture.domain.tvshow

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>?=tvShowRepository.getTvShows()
}