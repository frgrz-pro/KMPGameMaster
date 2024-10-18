package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.more_roles
import kmpgamemaster.composeapp.generated.resources.start_game
import kmpgamemaster.composeapp.generated.resources.werewolf
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.AddRemoveRow
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGRoleCardSmall
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGRoleExtrasCardSmall
import org.jetbrains.compose.resources.stringResource


class SetupScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<SetupScreenViewModel>()

        //TODO : viewModel.onPlayerCountChanged(players.size)

        Scaffold(
            topBar = {
                TopAppBar(title = { Text(stringResource(Res.string.werewolf)) })
            },
            content = { innerPadding ->
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(32.dp)
                ) {
                    val startBtn = createRef()
                    val modifyPlayerBtn = createRef()
                    val playerLabel = createRef()
                    val wolvesCount = createRef()
                    val peasantCunt = createRef()
                    val roleBox = createRef()

                    Text(
                        text = viewModel.playerLabel.value,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.constrainAs(playerLabel) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                    )

                    AddRemoveRow(model = viewModel.wolvesModel, modifier = Modifier
                        .padding(top = 16.dp)
                        .constrainAs(wolvesCount) {
                            top.linkTo(playerLabel.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })

                    AddRemoveRow(model = viewModel.peasantModel, modifier = Modifier
                        .padding(top = 8.dp)
                        .constrainAs(peasantCunt) {
                            top.linkTo(wolvesCount.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                    )

                    Box(modifier = Modifier.constrainAs(roleBox) {
                        top.linkTo(peasantCunt.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(modifyPlayerBtn.top)
                    }) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .padding(32.dp)
                        ) {
                            Text(
                                text = "Rôles",  //TODO String resource
                                modifier = Modifier.padding(end = 8.dp),
                                style = MaterialTheme.typography.headlineMedium
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            viewModel.selectedRoles.value.DisplayResult(
                                onLoading = { /*TODO*/ },
                                onError = { /*TODO*/ },
                                onSuccess = { items ->
                                    if (items.isNotEmpty()) {

                                        //TODO Move logic to VM
                                        val exceedDisplayableLimit = items.size > 15
                                        val extraItems = items.size - 15
                                        val displayedItems = if (exceedDisplayableLimit) {
                                            items.subList(0, 15)
                                        } else {
                                            items
                                        }

                                        LazyVerticalGrid(
                                            columns = GridCells.Fixed(5),
                                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                                            verticalArrangement = Arrangement.spacedBy(4.dp),
                                            modifier = Modifier.padding(12.dp)
                                        ) {
                                            itemsIndexed(displayedItems) { index, item ->
                                                if (extraItems > 0 && index == displayedItems.lastIndex) {
                                                    WGRoleExtrasCardSmall(extraItems)
                                                } else {
                                                    //TODO Add tooltip
                                                    WGRoleCardSmall(item.role) {}
                                                }
                                            }
                                        }
                                    }
                                }
                            )

                            TextButton(
                                onClick = {
                                    navigator.push(RolesScreen())
                                },
                            ) {
                                Text(
                                    text = stringResource(Res.string.more_roles),
                                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                                    style = MaterialTheme.typography.labelLarge
                                )
                            }
                        }
                    }

                    OutlinedButton(
                        onClick = {
                            navigator.push(PlayersScreen())
                        },
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 6.dp)
                            .constrainAs(modifyPlayerBtn) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(startBtn.top)

                            }
                    ) {
                        Text(
                            text = "Modifier les joueurs",  //TODO String resource
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    FilledTonalButton(
                        onClick = {
                            viewModel.saveGameSettings()
                            navigator.push(GameScreen())
                        },
                        modifier = Modifier.fillMaxWidth()
                            .padding(6.dp)
                            .constrainAs(startBtn) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            },
                        enabled = viewModel.canStartGame.value
                    ) {
                        Text(
                            text = stringResource(Res.string.start_game),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        )
    }
}

