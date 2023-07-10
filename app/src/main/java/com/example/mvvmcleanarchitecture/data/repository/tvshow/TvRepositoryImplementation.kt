package com.example.mvvmcleanarchitecture.data.repository.tvshow

import android.util.Log
import com.example.mvvmcleanarchitecture.domain.tvshow.TvShowRepository
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShowList

class TvRepositoryImplementation(
private val tvRemoteDataSource:TvRemoteDataSource,
private val tvLocalDataSource: TvLocalDataSource,
private val tvCacheDataSource: TvCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvLocalDataSource.clearAll()
        tvLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvCacheDataSource.saveTvShowsToCache(newListOfTvShows)

        return newListOfTvShows

    }

    suspend fun getTvShowsFromApi() : List<TvShow>{
        lateinit var tvShowList:List<TvShow>

        try{
            val response=tvRemoteDataSource.getTvShows()
            val body=response.body()
            if(body!=null){
                tvShowList= body.tvshows
            }

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>

        try{
            tvShowList=tvLocalDataSource.getTvShowsFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        }
        else{
            tvShowList=getTvShowsFromApi()
            tvLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowsList:List<TvShow>

        try{
            tvShowsList=tvCacheDataSource.getTvShowsFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(tvShowsList.size>0){
            return tvShowsList
        }
        else{
            tvShowsList=getTvShowsFromDB()
            tvCacheDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }
}