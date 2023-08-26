package com.judahben149.countrycookbook.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    title: String = "",
    isHomeDestination: Boolean = false,
    shouldCollapse: Boolean = false,
    onNavIconClick: () -> Unit,
) {

    val scrollBehaviour = if (shouldCollapse) {
        TopAppBarDefaults.enterAlwaysScrollBehavior()
    } else {
        TopAppBarDefaults.pinnedScrollBehavior()
    }

    TopAppBar(
        title = { Text(text = title) },
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = if (isHomeDestination) {
            { Spacer(modifier = Modifier.width(8.dp)) }
        } else {
            {
                IconButton(onClick = { onNavIconClick() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back button"
                    )
                }
            }
        },
        scrollBehavior = scrollBehaviour
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarComponentPreview() {
    TopAppBarComponent("Continents", true) {}
}
