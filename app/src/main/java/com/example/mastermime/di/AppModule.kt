package com.example.mastermime.di

import com.example.mastermime.meme.presentation.meme_list.MemeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MemeListViewModel)
}