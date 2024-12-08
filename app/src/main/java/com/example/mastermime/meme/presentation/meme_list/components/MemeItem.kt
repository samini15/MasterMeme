package com.example.mastermime.meme.presentation.meme_list.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mastermime.meme.util.loadBitmapFromAssets
import com.example.mastermime.ui.theme.LocalSpacing
import com.example.mastermime.ui.theme.MasterMimeTheme

@Composable
fun MemeItem(bitmap: Bitmap) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(spacing.spaceSmall)),
    ) {
        bitmap.let {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                bitmap = bitmap.asImageBitmap(),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
        }
    }

}

@Preview
@Composable
private fun MemeItemPreview() {
    val bitmap = loadBitmapFromAssets(context = LocalContext.current, fileName = "c1hh_48.webp")
    MasterMimeTheme {
        bitmap?.let { MemeItem(bitmap = bitmap) }
    }
}