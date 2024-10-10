package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class WGHomeScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<WGHomeViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Loup Garou") })
            },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)

                ) {
                    Column {
                        Text(viewModel.playerLabel.value)
                        Slider(
                            value = viewModel.playerCount.value.toFloat(),
                            onValueChange = { viewModel.onPlayerCountChanged(it.toInt()) },
                            valueRange = viewModel.minPlayers.toFloat()..viewModel.maxPlayers.toFloat(),
                            steps = viewModel.maxPlayers - viewModel.minPlayers
                        )
                        Row {
                            SmallFloatingActionButton(
                                onClick = { viewModel.onRemoveWolvesClicked() }
                            ) {}
                            Text(viewModel.wolvesLabel.value)
                            SmallFloatingActionButton(
                                onClick = { viewModel.onAddWolvesClicked() }
                            ) {}
                        }
                        Row {
                            Checkbox(
                                checked = viewModel.isSolosEnabled.value,
                                onCheckedChange = { viewModel.onSolosCheckedChanged(it) },

                                )
                            Text("Solos")
                        }
                        Row {
                            Checkbox(
                                checked = viewModel.isMayorEnabled.value,
                                onCheckedChange = { viewModel.onMayorCheckedChanged(it) },

                                )
                            Text("Maire")
                        }
                        Button(
                            onClick = { navigator.push(WGRolesScreen()) }
                        ) {
                            Text("Choisir les rôles")
                        }
                        Button(
                            onClick = {  }
                        ) {
                            Text("Lancer la partie")
                        }
                    }
                }
            }
        )
    }
}
