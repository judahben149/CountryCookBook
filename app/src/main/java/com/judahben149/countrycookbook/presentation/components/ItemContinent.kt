package com.judahben149.countrycookbook.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.judahben149.countrycookbook.domain.model.Continent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemContinent(continent: Continent, onItemClick: (continentCode: String) -> Unit) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onItemClick(continent.id) }
    ) {

        Text(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            text = continent.name
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemContinentPreview() {
    ItemContinent(Continent().copy(name = "Australia")) { }
}
