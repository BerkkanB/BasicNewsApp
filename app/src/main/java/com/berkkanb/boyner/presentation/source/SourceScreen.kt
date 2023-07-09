package com.berkkanb.boyner.presentation.source

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.berkkanb.boyner.presentation.coreui.LoadingScreen
import com.berkkanb.boyner.presentation.source.components.CategoryItem
import com.berkkanb.boyner.presentation.source.components.NewsSourceCard

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SourceScreen(
    sourceScreenViewModel: SourceScreenViewModel = hiltViewModel(),
    navigateToNewsList: (sourceId:String) -> Unit
) {
    val uiState by sourceScreenViewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        LoadingScreen()
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                FlowRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (uiState.categoryList.isNotEmpty()) {
                        uiState.categoryList.forEach { category ->
                            CategoryItem(
                                title = category.category,
                                isSelected = uiState.selectedCategories.any { it == category },
                                onClick = {sourceScreenViewModel.onSelectCategory(category)}
                            )
                        }
                    }
                }
            }
            uiState.sourceList?.let { sourceList ->
                items(sourceList, key = { it.sourceId }) {
                    NewsSourceCard(title = it.sourceName, description = it.sourceDescription, onClick = {navigateToNewsList.invoke(it.sourceId)})
                }
            }
        }
    }
}