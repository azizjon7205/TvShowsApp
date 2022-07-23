package com.example.android_imperative.repository

import com.example.android_imperative.db.TVShowDao
import com.example.android_imperative.model.TVShow
import com.example.android_imperative.network.TVShowService
import javax.inject.Inject

class TVShowRepository @Inject constructor(
    private val tvShowService: TVShowService,
    private val tvShowDao: TVShowDao
) {

    /**
     * Retrofit Related
     * */

    suspend fun apiTVShowPopular(page: Int) = tvShowService.apiTVShowPopular(page)
    suspend fun apiTVShowDetails(q: Int) = tvShowService.apiTVShowDetails(q)


    /**
     * Retrofit Related
     * */

    suspend fun getTvShowsFromDB() = tvShowDao.getTVShowFromDB()
    suspend fun insertTvShowToDB(tvShow: TVShow) = tvShowDao.insertTVShowToDB(tvShow)
    suspend fun deleteTvShowsFromDB() = tvShowDao.deleteTvShowsFromDB()

}