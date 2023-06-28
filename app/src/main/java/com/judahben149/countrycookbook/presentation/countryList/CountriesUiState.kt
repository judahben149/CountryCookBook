package com.judahben149.countrycookbook.presentation.countryList

import com.judahben149.countrycookbook.domain.model.Country

data class CountriesUiState(
    val isLoading: Boolean = true,
    val continentName: String = "",
    val countryList: List<Country> = emptyList()
)