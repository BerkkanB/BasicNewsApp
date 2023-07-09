package com.berkkanb.boyner.data.model

data class SourceResponseUI(
    val status: String,
    val sourceList:List<SourceUI>
)
data class SourceUI(
    val id:String,
    val name:String,
    val description:String,
    val category:String
)