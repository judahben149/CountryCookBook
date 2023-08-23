package com.judahben149.countrycookbook.presentation.countryList

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
class CountriesViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    private val _uiState: MutableStateFlow<CountryListUIState> = MutableStateFlow(CountryListUIState.Loading)
    val uiState: StateFlow<CountryListUIState> = _uiState.asStateFlow()

    fun getContinentDetails(continentCode: String) {
        isLoading()

        viewModelScope.launch {
            val continent = mainRepository.getContinentDetails(continentCode)

            continent?.let { continentDetails ->
                _uiState.update {
                    CountryListUIState.Loaded(continentDetails)
                }
            } ?: handleErrorMessage("Continent not found")
        }
    }

    private fun isLoading() {
        _uiState.update { CountryListUIState.Loading }
    }

    private fun handleErrorMessage(errorMessage: String) {
        _uiState.update { CountryListUIState.Error(errorMessage) }
    }
}
