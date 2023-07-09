package com.berkkanb.boyner.presentation.source

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.berkkanb.boyner.presentation.coreui.LoadingScreen
import com.berkkanb.boyner.presentation.source.components.NewsSourceCard

@Composable
fun SourceScreen(
    sourceScreenViewModel: SourceScreenViewModel = hiltViewModel()
) {
    val uiState by sourceScreenViewModel.uiState.collectAsState()

    if (uiState.isLoading){
        LoadingScreen()
    } else {
        LazyColumn(){
            uiState.sourceList?.let { sourceList ->
                items(sourceList, key = { it.sourceId }){
                    NewsSourceCard(title = it.sourceName, description = it.sourceDescription)
                }
            }
        }
    }
}