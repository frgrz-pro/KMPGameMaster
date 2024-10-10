package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.wolf_game
import org.frgrz.kmpgamemaster.material.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

class WGHomeScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<WGHomeViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = stringResource(Res.string.wolf_game)) })
            },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)

                ) {
                    Column {
                        Text(viewModel.playerLabel.value)
                        Slider(
                            value = viewModel.playerCount.value,
                            onValueChange = { viewModel.onPlayerCountChanged(it) },
                            valueRange = 7f..18f,
                            steps = 11, // (18 - 7) to have 1 step for each integer value
                        )
                        Row {

                        }
                    }
                }
            }
        )
    }
}
