package com.berkkanb.boyner.domain

import com.berkkanb.boyner.data.model.SourceResponseUI
import retrofit2.Response

interface GetNewsSourceListRepository {
    suspend fun getNewsSourceList(): Response<SourceResponseUI>
}