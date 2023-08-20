package com.judahben149.countrycookbook.presentation.continent

import com.judahben149.countrycookbook.domain.model.Continent


data class ContinentListUIState(
    val isLoading: Boolean = false,
    val  isLoaded: Boolean = false,
    val continentList: List<Continent> = emptyList(),
    val isError: Boolean = false,
    val errorMessage: String = ""
)