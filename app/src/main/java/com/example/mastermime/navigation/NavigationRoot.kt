@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mastermime.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mastermime.meme.presentation.meme_list.MemeListScreen
import com.example.mastermime.meme.presentation.meme_list.MemeListViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Route.MEME) {
        memeGraph(navController)
    }
}

private fun NavGraphBuilder.memeGraph(navController: NavHostController) {
    navigation(startDestination = Route.MEME_LIST_SCREEN, route = Route.MEME) {
        composable(Route.MEME_LIST_SCREEN) {
            val viewModel = koinViewModel<MemeListViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            MemeListScreen(state = state)
        }

    }
}