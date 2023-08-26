package com.judahben149.countrycookbook.presentation.components

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.countrycookbook.domain.model.Country
import com.judahben149.countrycookbook.utils.getEmojiDrawable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCountry(context: Context, country: Country, onItemClick: (countryCode: String) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp),
        onClick = { onItemClick(country.id) }
    ) {

        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp),
            contentScale = ContentScale.Inside,
            bitmap = (country.flag.getEmojiDrawable(context) as BitmapDrawable).bitmap.asImageBitmap(),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .align(Alignment.CenterHorizontally),
            text = country.name,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCountryPreview() {
//    ItemCountry(Country().copy(name = "Nigeria", capital = "Abuja"), { })
}
