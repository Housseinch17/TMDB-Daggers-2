package com.example.mvvmcleanarchitecture.data.repository.tvshow

import com.example.mvvmcleanarchitecture.data.db.TvShowDao
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvLocalDataSourceImplementation(private val tvShowDao: TvShowDao)
    : TvLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
         tvShowDao.saveTvShows(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}