package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.features.wolfgame.ui.components.WGRoleCardSmall
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Remove


class WGHomeScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<WGHomeViewModel>()
        val selectedRoles by viewModel.selectedRoles
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Loup Garou") })
            },
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            content = { innerPadding ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(32.dp)
                ) {
                    Text(
                        text = viewModel.playerLabel.value,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

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
                        IconButton(
                            onClick = { viewModel.onRemoveWolvesClicked() },
                            enabled = viewModel.canRemoveWolves.value
                        ) {
                            val icon = rememberVectorPainter(image = IconPack.Remove)
                            Icon(
                                painter = icon,
                                contentDescription = "Remove"
                            )
                        }

                        Text(
                            text = viewModel.wolvesLabel.value,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                            style = MaterialTheme.typography.titleLarge
                        )

                        IconButton(
                            onClick = { viewModel.onAddWolvesClicked() },
                            enabled = viewModel.canAddWolves.value
                        ) {
                            val icon = rememberVectorPainter(image = Icons.Filled.Add)
                            Icon(
                                painter = icon,
                                contentDescription = "Remove"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Rôles",
                            modifier = Modifier.padding(end = 8.dp),
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    selectedRoles.DisplayResult(
                        onLoading = { /*TODO*/ },
                        onError = { /*TODO*/ },
                        onSuccess = {
                            if (it.isNotEmpty()) {
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(5),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                    modifier = Modifier.padding(12.dp)
                                ) {
                                    itemsIndexed(it) { _, item ->
                                        WGRoleCardSmall(item.role) {
                                            //TODO Replace with tooltip
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "${item.role.name} : ${item.isSelected}",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    )

                    TextButton(
                        onClick = { navigator.push(WGRolesScreen()) },
                    ) {
                        Text(
                            text = "Plus de rôles",
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                    Spacer(modifier = Modifier.height(48.dp))

                    FilledTonalButton(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "Lancer la partie",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

            }
        )
    }
}
