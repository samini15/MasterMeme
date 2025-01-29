package com.example.mastermime.meme.presentation.meme_list

import android.graphics.Bitmap
import com.example.mastermime.meme.presentation.meme_list.model.MemeTemplateUi

data class MemeListState(
    val memeTemplates: List<MemeTemplateUi> = emptyList(),
    val selectedMemeTemplate: Bitmap? = null
)
