package com.berkkanb.boyner.presentation.newslist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsListScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val sourceId: String = checkNotNull(savedStateHandle["sourceId"])

}