package com.judahben149.countrycookbook.presentation.countryList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.judahben149.countrycookbook.navigation.Screen
import com.judahben149.countrycookbook.presentation.components.ItemCountry
import com.judahben149.countrycookbook.presentation.components.LoadingProgressFilledScreen
import com.judahben149.countrycookbook.presentation.components.TopAppBarComponent
import com.judahben149.countrycookbook.utils.toContinentName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun CountryListScreen(
    navController: NavController,
    continentId: String,
) {
    val viewModel: CountriesViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = continentId) {
        withContext(Dispatchers.IO) {
            viewModel.getContinentDetails(continentId)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBarComponent(
            title = "Countries in ${continentId.toContinentName()}",
            isHomeDestination = false,
            shouldCollapse = true,
            onNavIconClick = { navController.popBackStack() }
        )

        when (state) {
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
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CountryListScreenContent(state: CountryListUIState, onClick: (id: String) -> Unit) {
    val countryList = (state as CountryListUIState.Loaded).continent.countryList

    LazyVerticalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(countryList.size) { countryId ->
            ItemCountry(
                country = countryList[countryId],
                context = LocalContext.current,
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
