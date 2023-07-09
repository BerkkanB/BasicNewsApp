package com.berkkanb.boyner.domain

import com.berkkanb.boyner.data.model.NewsResponseUI
import retrofit2.Response

interface GetNewsListRepository {

    suspend fun getNewsList(sourceId: String): Response<NewsResponseUI>
}