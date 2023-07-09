package com.berkkanb.boyner.data.model

import com.google.gson.annotations.SerializedName

data class SourceResponseUI(
    @SerializedName("status")
    val status: String,
    @SerializedName("sources")
    val sources: List<SourceUI>
)

data class SourceUI(
    @SerializedName("id")
    val sourceId: String,
    @SerializedName("name")
    val sourceName: String,
    @SerializedName("description")
    val sourceDescription: String,
    @SerializedName("url")
    val sourceUrl: String,
    @SerializedName("category")
    val sourceCategory: String,
    @SerializedName("language")
    val sourceLanguage: String,
    @SerializedName("country")
    val sourceCountry: String
)