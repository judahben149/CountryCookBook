package com.judahben149.countrycookbook.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoadingProgress() {
    Box {
        CircularProgressIndicator()
    }
}

@Composable
fun LoadingProgressFilledScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LoadingProgress()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingProgressPreview() {
    LoadingProgress()
}
