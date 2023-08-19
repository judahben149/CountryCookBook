package com.judahben149.countrycookbook.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoadingProgress() {
    Box {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingProgressPreview() {
    LoadingProgress()
}
