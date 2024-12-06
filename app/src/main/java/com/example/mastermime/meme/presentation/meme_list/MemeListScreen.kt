package com.example.mastermime.meme.presentation.meme_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.mastermime.ui.theme.MasterMimeTheme

@Composable
fun MemeListScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    )
}

@Preview
@PreviewLightDark
@Composable
private fun MemeListScreenPreview() {
    MasterMimeTheme {
        MemeListScreen()
    }
}