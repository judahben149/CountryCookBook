package com.judahben149.countrycookbook.presentation.countryList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.judahben149.countrycookbook.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    private val _uiState: MutableLiveData<CountriesUiState> = MutableLiveData(CountriesUiState())
    val uiState: LiveData<CountriesUiState> get() = _uiState

    fun getContinentDetails(continentCode: String) {
        viewModelScope.launch {
            val continent = mainRepository.getContinentDetails(continentCode)

            continent?.let {
                _uiState.value = _uiState.value?.copy(
                    isLoading = false,
                    continentName = it.name,
                    countryList = it.countryList
                )
            }
        }
    }
}