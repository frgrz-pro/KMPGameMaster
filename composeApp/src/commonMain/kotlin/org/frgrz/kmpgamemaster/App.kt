package org.frgrz.kmpgamemaster

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.frgrz.kmpgamemaster.di.databaseModule
import org.frgrz.kmpgamemaster.features.home.di.homeViewModelsModule
import org.frgrz.kmpgamemaster.features.home.ui.HomeScreen
import org.frgrz.kmpgamemaster.features.wolfgame.di.wgModule
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGRolesScreen
import org.frgrz.kmpgamemaster.material.theme.AppTheme
import org.koin.core.context.startKoin

@Composable
@Preview
fun App() {

    startKoin()

    AppTheme {
        Navigator(WGRolesScreen()) { navigator ->
            SlideTransition(navigator)
        }
    }
}

fun startKoin() {
    startKoin {
        modules(
            databaseModule,
            homeViewModelsModule,
            wgModule
        )
    }
}

