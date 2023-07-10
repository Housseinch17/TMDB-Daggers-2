package com.example.mvvmcleanarchitecture.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvshows: List<TvShow>,
)