package com.berkkanb.boyner.data.api

import com.berkkanb.boyner.data.model.NewsResponseUI
import com.berkkanb.boyner.data.model.SourceResponseUI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines/sources")
    suspend fun getSourceList(
        @Query("apiKey") apiKey: String,
        @Query("language") language: String

    ): Response<SourceResponseUI>

    @GET("top-headlines")
    suspend fun getNewsList(
        @Query("apiKey") apiKey: String,
        @Query("sources") sources: String

    ): Response<NewsResponseUI>
}