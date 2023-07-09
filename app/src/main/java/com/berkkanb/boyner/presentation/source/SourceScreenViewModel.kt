package com.berkkanb.boyner.presentation.source

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkkanb.boyner.data.model.SourceUI
import com.berkkanb.boyner.domain.GetNewsSourceListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourceScreenViewModel @Inject constructor(
    private val getNewsSourceListRepository: GetNewsSourceListRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SourceScreenUIState())
    val uiState = _uiState.asStateFlow()

    private val initialSourceList = mutableStateOf(emptyList<SourceUI>())

    init {
        getNewsSourceList()
        setCategoryList()
    }

    private fun getNewsSourceList() {
        viewModelScope.launch {
            setLoadingStatus()
            val response = getNewsSourceListRepository.getNewsSourceList()
            if (response.isSuccessful) {
                val sourceList = response.body()?.sources
                _uiState.update {
                    it.copy(
                        sourceList = sourceList,
                        isLoading = false
                    )
                }
                if (sourceList != null) {
                    initialSourceList.value = sourceList
                }
            } else {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        hasError = true
                    )
                }
            }
        }
    }

    private fun setCategoryList() {
        val categoryList = listOf(
            "business",
            "entertainment",
            "general",
            "health",
            "science",
            "sports",
            "technology"
        )
        _uiState.update {
            it.copy(
                categoryList = categoryList.map { category -> NewsCategory(category) },
                selectedCategories = categoryList.map { category -> NewsCategory(category) }
            )
        }
    }

    private fun setLoadingStatus() {
        _uiState.update {
            it.copy(isLoading = true)
        }
    }

    fun onSelectCategory(category: NewsCategory) {
        if (uiState.value.selectedCategories.contains(category)) {
            val updatedList = uiState.value.selectedCategories.filterNot { it == category }
            _uiState.update {
                it.copy(selectedCategories = updatedList)
            }
        } else {
            val updatedList = uiState.value.selectedCategories.plus(category)
            _uiState.update {
                it.copy(selectedCategories = updatedList)
            }
        }

        val updatedList = initialSourceList.value.filter {
            uiState.value.selectedCategories.contains(
                NewsCategory(it.sourceCategory)
            )
        }
        _uiState.update {
            it.copy(sourceList = updatedList)
        }

    }


}

data class SourceScreenUIState(
    val sourceList: List<SourceUI>? = null,
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val categoryList: List<NewsCategory> = mutableListOf(),
    val selectedCategories: List<NewsCategory> = mutableListOf()
)

data class NewsCategory(
    val category: String
)