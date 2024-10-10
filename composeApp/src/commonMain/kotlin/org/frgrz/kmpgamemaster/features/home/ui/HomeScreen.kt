package org.frgrz.kmpgamemaster.features.home.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.home
import kmpgamemaster.composeapp.generated.resources.sporz
import kmpgamemaster.composeapp.generated.resources.two_rooms_and_a_boom
import kmpgamemaster.composeapp.generated.resources.wolf_game
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGHomeScreen
import org.frgrz.kmpgamemaster.material.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

class HomeScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<HomeViewModel>()

        HomeScreen_Content {
            navigator.push(WGHomeScreen())
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen_Content(onWGButtonClick: () -> Unit, ) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(Res.string.home)) })
        },
        content = { paddingValues ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), // Use padding values from the Scaffold
            ) {
                FilledTonalButton(
                    onClick = { onWGButtonClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(stringResource(Res.string.wolf_game))
                }

                //TODO: Not Implemented
                FilledTonalButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    enabled = false
                ) {
                    Text(stringResource(Res.string.two_rooms_and_a_boom))
                }

                //TODO: Not Implemented
                FilledTonalButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    enabled = false
                ) {
                    Text(stringResource(Res.string.sporz))
                }
            }
        }
    )
}

@Composable
@Preview
fun HomeContent_Preview() {
    AppTheme {
        HomeScreen_Content {}
    }
}