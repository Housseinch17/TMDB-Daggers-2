package com.example.mvvmcleanarchitecture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmcleanarchitecture.data.model.artist.Artist
import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

@Database(entities= [Movie::class, Artist::class, TvShow::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun moviesDao() : MovieDao
    abstract fun artistDao() : ArtistDao
    abstract fun tvDao() : TvShowDao
}