package com.example.mastermime.meme.presentation.meme_list

import android.graphics.Bitmap

data class MemeListState(
    val memes: List<Bitmap> = emptyList()
)
