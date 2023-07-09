package com.berkkanb.boyner.data.api

import com.berkkanb.boyner.data.model.SourceResponseUI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/top-headlines/sources")
    suspend fun getSourceList(
        @Query("language") language: String,
        @Query("apiKey") apiKey: String
    ): Response<List<SourceResponseUI>>
}