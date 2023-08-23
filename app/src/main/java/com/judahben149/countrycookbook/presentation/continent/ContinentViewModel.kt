package com.judahben149.countrycookbook.presentation.continent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.judahben149.countrycookbook.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContinentViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<ContinentListUIState> = MutableStateFlow(ContinentListUIState.Loading)
    val uiState: StateFlow<ContinentListUIState> = _uiState.asStateFlow()

    fun getContinentList() {
        isLoading()
        viewModelScope.launch {
            _uiState.update { ContinentListUIState.Loaded(mainRepository.getContinentList()) }
        }
    }

    private fun isLoading() {
        _uiState.update { ContinentListUIState.Loading }
    }

    private fun handleErrorMessage(errorMessage: String) {
        _uiState.update { ContinentListUIState.Error(errorMessage) }
    }
}
