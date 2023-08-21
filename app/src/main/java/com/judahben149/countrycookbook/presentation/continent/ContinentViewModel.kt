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
class ContinentViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    private val _continentList: MutableStateFlow<ContinentListUIState> =
        MutableStateFlow(ContinentListUIState())
    val continentList: StateFlow<ContinentListUIState> = _continentList.asStateFlow()

    fun getContinentList() {
        isLoading()
        viewModelScope.launch {
            _continentList.update {
                it.copy(
                    continentList = mainRepository.getContinentList(),
                    isLoaded = true
                )
            }
        }
    }

    private fun isLoading() {
        _continentList.update { it.copy(isLoading = true, isLoaded = false) }
    }

    private fun handleErrorMessage(errorMessage: String) {
        _continentList.update { it.copy(isError = true, errorMessage = errorMessage) }
    }
}
