package com.berkkanb.boyner.presentation.source

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

    init {
        getNewsSourceList()
    }

    private fun getNewsSourceList(){
        viewModelScope.launch {
            setLoadingStatus()
            val response = getNewsSourceListRepository.getNewsSourceList()
            if (response.isSuccessful){
                val sourceList = response.body()?.sources
                _uiState.update {
                    it.copy(
                        sourceList = sourceList,
                        isLoading = false
                    )
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

    private fun setLoadingStatus(){
        _uiState.update {
            it.copy(isLoading = true)
        }
    }


}

data class SourceScreenUIState(
    val sourceList: List<SourceUI>? = null,
    val isLoading:Boolean = false,
    val hasError:Boolean = false
)