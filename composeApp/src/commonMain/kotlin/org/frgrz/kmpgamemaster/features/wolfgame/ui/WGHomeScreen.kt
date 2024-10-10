package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import androidx.constraintlayout.compose.ConstraintLayout

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
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    val box = createRef()

                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .constrainAs(box) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }

                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = viewModel.playerLabel.value,
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Slider(
                                value = viewModel.playerCount.value.toFloat(),
                                onValueChange = { viewModel.onPlayerCountChanged(it.toInt()) },
                                valueRange = viewModel.minPlayers.toFloat()..viewModel.maxPlayers.toFloat(),
                                steps = viewModel.maxPlayers - viewModel.minPlayers,
                                modifier = Modifier.width(240.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                SmallFloatingActionButton(
                                    onClick = { viewModel.onRemoveWolvesClicked() }
                                ) {}
                                Text(
                                    text = viewModel.wolvesLabel.value,
                                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                                    style = MaterialTheme.typography.titleLarge
                                )
                                SmallFloatingActionButton(
                                    onClick = { viewModel.onAddWolvesClicked() }
                                ) {}
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = viewModel.isSolosEnabled.value,
                                    onCheckedChange = { viewModel.onSolosCheckedChanged(it) },

                                    )
                                Text("Solos")

                                Checkbox(
                                    checked = viewModel.isMayorEnabled.value,
                                    onCheckedChange = { viewModel.onMayorCheckedChanged(it) },

                                    )
                                Text("Maire")
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            TextButton(
                                onClick = { navigator.push(WGRolesScreen()) }
                            ) {
                                Text("Choisir les rôles")
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            FilledTonalButton(
                                onClick = { }
                            ) {
                                Text("Lancer la partie")
                            }

                        }
                    }
                }
            }
        )
    }
}
