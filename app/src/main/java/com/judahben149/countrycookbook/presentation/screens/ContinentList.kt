package com.judahben149.countrycookbook.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.judahben149.countrycookbook.presentation.components.ItemContinent
import com.judahben149.countrycookbook.presentation.components.LoadingProgress
import com.judahben149.countrycookbook.presentation.continent.ContinentListUIState
import com.judahben149.countrycookbook.presentation.continent.ContinentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ContinentListScreen() {

    val viewModel = viewModel<ContinentViewModel>()
    val state by viewModel.continentList.collectAsState()

    LaunchedEffect(key1 = "continentCode") {
        withContext(Dispatchers.IO) {
            viewModel.getContinentList()
        }
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LoadingProgress()
        }
    } else if (state.isLoaded) {
        ContinentListScreenContent(state = state, onClick = {

        })
    }


}

@Composable
fun ContinentListScreenContent(state: ContinentListUIState, onClick: (id: String) -> Unit) {
    LazyRow {
        items(state.continentList.size) { itemIndex ->
            ItemContinent(
                continent = state.continentList[itemIndex],
                onItemClick = { onClick(state.continentList[itemIndex].id) })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ContinentListPreview() {
    ContinentListScreen()
}
