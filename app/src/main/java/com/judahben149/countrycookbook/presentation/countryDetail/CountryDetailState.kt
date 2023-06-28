package com.judahben149.countrycookbook.presentation.countryDetail

import com.judahben149.countrycookbook.domain.model.Country

data class CountryDetailState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val country: Country = Country(),
)
