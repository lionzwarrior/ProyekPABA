package com.paba.projectpaba.getyoutubevideo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApiService {
    @GET("videos")
    fun getVideoDetails(
        @Query("id") id: String,
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("fields") fields: String
    ) : Call<YoutubeResponse>
}