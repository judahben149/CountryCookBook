package com.judahben149.countrycookbook.presentation.countryList

import com.judahben149.countrycookbook.domain.model.Continent

sealed class CountryListUIState {
    object Loading : CountryListUIState()
    data class Loaded(val continent: Continent) : CountryListUIState()
    data class Error(val errorMessage: String) : CountryListUIState()
}