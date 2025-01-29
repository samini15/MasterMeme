@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mastermime.meme.presentation.create_meme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.mastermime.R
import com.example.mastermime.meme.util.loadBitmapFromAssets
import com.example.mastermime.ui.theme.LocalSpacing
import com.example.mastermime.ui.theme.MasterMimeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateMemeScreen(
    modifier: Modifier = Modifier,
    memeTemplateId: String,
    onNavigateUp: () -> Unit = {}
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.new_meme)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = MaterialTheme.colorScheme.surface),
                navigationIcon = {
                    IconButton(onClick = { onNavigateUp() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->

        val bitmap = loadBitmapFromAssets(context, memeTemplateId)

        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            bitmap?.asImageBitmap()?.let {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .padding(spacing.spaceMedium)
                        .size(width = 390.dp, height = 390.dp),
                    bitmap = it,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview
@PreviewLightDark
@Composable
private fun CreateMemeScreenPreview() {
    MasterMimeTheme {
        CreateMemeScreen(memeTemplateId = "ajtl_46.webp")
    }
}