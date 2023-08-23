package com.judahben149.countrycookbook.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = "continentCode") {
        withContext(Dispatchers.IO) {
            viewModel.getContinentList()
        }
    }

    when (state) {
        ContinentListUIState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LoadingProgress()
            }
        }

        is ContinentListUIState.Loaded -> {
            ContinentListScreenContent(state = state, onClick = {

            })
        }

        is ContinentListUIState.Error -> {

        }
    }
}

@Composable
fun ContinentListScreenContent(state: ContinentListUIState, onClick: (id: String) -> Unit) {
    val continentList = (state as ContinentListUIState.Loaded).continentList

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(
                count = continentList.size
            ) { itemIndex ->
                ItemContinent(
                    continent = state.continentList[itemIndex],
                    onItemClick = { onClick(state.continentList[itemIndex].id) })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun ContinentListPreview() {
    ContinentListScreen()
}
