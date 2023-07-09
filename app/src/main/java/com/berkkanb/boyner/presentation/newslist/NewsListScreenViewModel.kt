package com.berkkanb.boyner.presentation.newslist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkkanb.boyner.data.model.NewsUI
import com.berkkanb.boyner.domain.GetNewsListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListScreenViewModel @Inject constructor(
    private val getNewsListRepository: GetNewsListRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val sourceId: String = checkNotNull(savedStateHandle["sourceId"])

    private val _uiState = MutableStateFlow(NewsListScreenUIState())
    val uiState = _uiState.asStateFlow()

    init {
        getNewsList()
    }

    private fun getNewsList() {
        viewModelScope.launch {
            setLoadingStatus()
            val response = getNewsListRepository.getNewsList(sourceId)
            if (response.isSuccessful){
                val newsList = response.body()?.articles
                if (newsList != null) {
                    setNewsList(newsList)
                }
            }
            else {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        hasError = true
                    )
                }
            }
        }
    }

    private fun setNewsList(newsList: List<NewsUI>) {
        if (newsList.size > 3){
            _uiState.update {
                it.copy(
                    carouselNewsList = newsList.subList(0,3),
                    newsList = newsList.subList(3,newsList.size.minus(1)),
                    isLoading = false
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    carouselNewsList = newsList,
                    isLoading = false
                )
            }
        }
    }

    private fun setLoadingStatus(){
        _uiState.update {
            it.copy(isLoading = true)
        }
    }

}

data class NewsListScreenUIState(
    val newsList:List<NewsUI>? = null,
    val carouselNewsList:List<NewsUI>? = null,
    val isLoading:Boolean = false,
    val hasError:Boolean = false
)