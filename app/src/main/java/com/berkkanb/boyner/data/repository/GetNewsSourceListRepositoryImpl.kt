package com.berkkanb.boyner.data.repository

import com.berkkanb.boyner.data.api.ApiService
import com.berkkanb.boyner.data.model.SourceResponseUI
import com.berkkanb.boyner.domain.GetNewsSourceListRepository
import retrofit2.Response
import javax.inject.Inject

class GetNewsSourceListRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GetNewsSourceListRepository {
    override suspend fun getNewsSourceList(): Response<SourceResponseUI> {
        return apiService.getSourceList("905e0f9c7cbe45309320bd2678d00d03", "en") // TODO
    }
}