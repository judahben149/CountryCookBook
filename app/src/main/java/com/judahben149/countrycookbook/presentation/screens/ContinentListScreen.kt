package com.judahben149.countrycookbook.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.judahben149.countrycookbook.navigation.Screen
import com.judahben149.countrycookbook.presentation.components.ItemContinent
import com.judahben149.countrycookbook.presentation.components.LoadingProgressFilledScreen
import com.judahben149.countrycookbook.presentation.continent.ContinentListUIState
import com.judahben149.countrycookbook.presentation.continent.ContinentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ContinentListScreen(navController: NavHostController) {

    val viewModel = viewModel<ContinentViewModel>()
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = "continentCode") {
        withContext(Dispatchers.IO) {
            viewModel.getContinentList()
        }
    }

    when (state) {
        ContinentListUIState.Loading -> {
            LoadingProgressFilledScreen()
        }

        is ContinentListUIState.Loaded -> {
            ContinentListScreenContent(
                state = state,
                onClick = { continentId ->
                    navController.navigate(
                        Screen.CountryListScreen.route.replace(
                            "{continentId}",
                            "${continentId}"
                        )
                    )
                }
            )
        }

        is ContinentListUIState.Error -> {

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContinentListScreenContent(state: ContinentListUIState, onClick: (id: String) -> Unit) {
    val continentList = (state as ContinentListUIState.Loaded).continentList

    LazyVerticalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(
            count = continentList.size
        ) { itemIndex ->
            ItemContinent(
                continent = state.continentList[itemIndex],
                onItemClick = { onClick(state.continentList[itemIndex].id) })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ContinentListPreview() {
//    ContinentListScreen(NavHostController())
}
