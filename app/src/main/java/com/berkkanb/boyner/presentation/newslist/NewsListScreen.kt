package com.berkkanb.boyner.presentation.newslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.berkkanb.boyner.presentation.coreui.LoadingScreen
import com.berkkanb.boyner.presentation.newslist.components.NewsCard
import com.berkkanb.boyner.presentation.newslist.components.PagerIndicators

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsListScreen(
    newsListScreenViewModel: NewsListScreenViewModel = hiltViewModel()
) {
    val uiState by newsListScreenViewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        LoadingScreen()
    } else {

        val pagerState = rememberPagerState()
        val carouselPageCount = 3

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            uiState.carouselNewsList?.let { newsList ->
                item {
                    HorizontalPager(
                        pageCount = carouselPageCount,
                        pageSpacing = 10.dp,
                        beyondBoundsPageCount = 3,
                        state = pagerState
                    ) {
                        NewsCard(
                            title = newsList[it].title,
                            imageURL = newsList[it].urlToImage,
                            isBookmarked = uiState.bookmarkList.contains(newsList[it].url),
                            onClickBookmark = {
                                newsListScreenViewModel.onClickBookmark(newsList[it].url)
                            })
                    }
                }
                item {
                    PagerIndicators(carouselPageCount, pagerState.currentPage)
                }
            }
            uiState.newsList?.let { newsList ->
                items(newsList) {
                    NewsCard(
                        title = it.title,
                        imageURL = it.urlToImage,
                        isBookmarked = uiState.bookmarkList.contains(it.url),
                        onClickBookmark = {
                            newsListScreenViewModel.onClickBookmark(it.url)
                        })
                }
            }
        }
    }
}