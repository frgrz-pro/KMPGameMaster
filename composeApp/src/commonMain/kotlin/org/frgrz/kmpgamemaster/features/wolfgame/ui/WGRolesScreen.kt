package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.frgrz.kmpgamemaster.material.theme.AppTheme

class WGRolesScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<WGRoleViewModel>()

        Scaffold() {

        }
    }
}
