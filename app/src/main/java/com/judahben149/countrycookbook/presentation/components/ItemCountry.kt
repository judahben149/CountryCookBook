package com.judahben149.countrycookbook.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.judahben149.countrycookbook.domain.model.Country

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCountry(country: Country, onItemClick: (countryCode: String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onItemClick(country.id) }
    ) {
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = country.name
            )

            Text(text = country.capital)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCountryPreview() {
    ItemCountry(Country().copy(name = "Nigeria", capital = "Abuja"), { })
}
