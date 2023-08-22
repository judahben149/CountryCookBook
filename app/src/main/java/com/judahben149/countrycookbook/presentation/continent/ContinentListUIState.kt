package com.judahben149.countrycookbook.presentation.continent

import com.judahben149.countrycookbook.domain.model.Continent


sealed class ContinentListUIState {
    object Loading : ContinentListUIState()
    data class Loaded(val continentList: List<Continent>) : ContinentListUIState()
    data class Error(val errorMessage: String) : ContinentListUIState()
}
