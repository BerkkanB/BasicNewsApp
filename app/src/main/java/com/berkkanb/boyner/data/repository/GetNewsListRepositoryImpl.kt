package com.berkkanb.boyner.data.repository

import com.berkkanb.boyner.data.api.ApiService
import com.berkkanb.boyner.data.model.NewsResponseUI
import com.berkkanb.boyner.domain.GetNewsListRepository
import retrofit2.Response
import javax.inject.Inject

class GetNewsListRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GetNewsListRepository {
    override suspend fun getNewsList(sourceId: String): Response<NewsResponseUI> {
        return apiService.getNewsList("905e0f9c7cbe45309320bd2678d00d03", sourceId) // TODO
    }
}