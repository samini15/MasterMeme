package com.example.mastermime.meme.presentation.meme_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class MemeListViewModel(

): ViewModel() {

    private val _state = MutableStateFlow(MemeListState())
    val state = _state
        .onStart { loadMemes() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L), MemeListState()
        )


    private fun loadMemes() {}
}