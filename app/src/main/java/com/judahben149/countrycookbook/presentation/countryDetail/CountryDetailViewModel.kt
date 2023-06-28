package com.judahben149.countrycookbook.presentation.countryDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.judahben149.countrycookbook.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    private val _uiState: MutableLiveData<CountryDetailState> = MutableLiveData(CountryDetailState())
    val uiState: LiveData<CountryDetailState> = _uiState

    fun getCountryDetails(countryCode: String) {
        viewModelScope.launch {
            val response = mainRepository.getCountryDetails(countryCode)

            response?.let { country ->
                _uiState.value = _uiState.value?.copy(isLoading = false, country = country)
            }
        }
    }
}