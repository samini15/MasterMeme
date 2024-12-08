@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mastermime.meme.presentation.meme_list

import com.example.mastermime.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.example.mastermime.meme.presentation.meme_list.components.MemeItem
import com.example.mastermime.meme.util.getImagesFromAssets
import com.example.mastermime.meme.util.loadBitmapFromAssets
import com.example.mastermime.ui.theme.LocalSpacing
import com.example.mastermime.ui.theme.MasterMimeTheme

@Composable
fun MemeListScreen(
    modifier: Modifier = Modifier,
    state: MemeListState
) {
    val context = LocalContext.current
    val spacing = LocalSpacing.current
    val sheetState = rememberModalBottomSheetState()

    val scrollBehaviour = TopAppBarDefaults.pinnedScrollBehavior()
    var isTemplateSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.your_memes)) },
                scrollBehavior = scrollBehaviour,
                colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isTemplateSheetOpen = true
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add", tint = MaterialTheme.colorScheme.onPrimary)
            }
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            if (isTemplateSheetOpen) {
                ModalBottomSheet(
                    onDismissRequest = { isTemplateSheetOpen = false },
                    sheetState = sheetState
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacing.spaceMedium),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = stringResource(R.string.choose_template),
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(spacing.spaceMedium))
                        Text(
                            text = stringResource(R.string.choose_template_for_your_next_meme_masterpiece),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = modifier.fillMaxSize(),
                            contentPadding = PaddingValues(spacing.spaceMedium),
                            verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                            horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
                        ) {
                            items(getImagesFromAssets(context)) { image ->
                                loadBitmapFromAssets(context, image)?.let { bitmap ->
                                    MemeItem(bitmap = bitmap)
                                }
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (state.memes.isEmpty()) {
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.empty_list), contentDescription = null)
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    Text(
                        stringResource(R.string.tap_to_create_your_first_meme),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                } else {
                    // TODO add a list of memes from DB (Local storage, External storage)???
                }
            }
        }
    }
}

@Preview
@PreviewLightDark
@Composable
private fun MemeListScreenPreview() {
    MasterMimeTheme {
        MemeListScreen(state = MemeListState())
    }
}