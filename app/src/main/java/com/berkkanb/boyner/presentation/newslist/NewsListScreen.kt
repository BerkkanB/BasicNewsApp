package com.berkkanb.boyner.presentation.newslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.berkkanb.boyner.presentation.coreui.LoadingScreen
import com.berkkanb.boyner.presentation.newslist.components.NewsCard

@Composable
fun NewsListScreen(
    newsListScreenViewModel: NewsListScreenViewModel = hiltViewModel()
) {
    val uiState by newsListScreenViewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        LoadingScreen()
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            uiState.newsList?.let { newsList ->
                items(newsList){
                    NewsCard(title = it.title, imageURL = it.urlToImage, isBookmarked = false, onClickBookmark = {})
                }
            }
        }
    }
}