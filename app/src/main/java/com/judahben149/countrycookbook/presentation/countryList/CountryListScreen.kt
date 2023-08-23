package com.judahben149.countrycookbook.presentation.countryList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.judahben149.countrycookbook.navigation.Screen
import com.judahben149.countrycookbook.presentation.components.ItemCountry
import com.judahben149.countrycookbook.presentation.components.LoadingProgressFilledScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun CountryListScreen(
    navController: NavController,
    continentId: String,
) {
    val viewModel = viewModel<CountriesViewModel>()
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = continentId) {
        withContext(Dispatchers.IO) {
            viewModel.getContinentDetails(continentId)
        }
    }

    when(state) {
        CountryListUIState.Loading -> {
            LoadingProgressFilledScreen()
        }

        is CountryListUIState.Loaded -> {
            CountryListScreenContent(
                state = state,
                onClick = { countryId ->
                    navController.navigate(
                        Screen.CountryDetailScreen.route.replace(
                            "{countryId}",
                            "${countryId}"
                        )
                    )
                }
            )
        }

        is CountryListUIState.Error -> {

        }
    }
}

@Composable
fun CountryListScreenContent(state: CountryListUIState, onClick: (id: String) -> Unit) {
    val countryList = (state as CountryListUIState.Loaded).continent.countryList

    LazyColumn {
        items(countryList.size) { countryId ->
            ItemCountry(
                country = countryList[countryId],
                onItemClick = { onClick(countryList[countryId].id) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryListScreenPreview() {
//    CountryListScreenContent() { }
}
