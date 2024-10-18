package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGPlayerDrawCard
import org.frgrz.kmpgamemaster.material.components.TextDialog
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGRoleDialog
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Eye
import org.frgrz.kmpgamemaster.material.components.icons.Notes

class GameScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<GameScreenViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Game") },
                    actions = {
                        IconButton(
                            onClick = { viewModel.toggleState() },
                        ) {
                            Icon(imageVector = IconPack.Eye, contentDescription = "")
                        }
                        IconButton(
                            onClick = {
                                viewModel.onAccessLogClicked {
                                    navigator.push(LogScreen())
                                }
                            },
                        ) {
                            Icon(imageVector = IconPack.Notes, contentDescription = "")
                        }
                    }
                )
            },
            content = { innerPadding ->
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    val grid = createRef()

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .padding(innerPadding)
                            .constrainAs(grid) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                verticalBias = 0f
                            }
                    ) {
                        items(viewModel.cardItems) { item ->
                            WGPlayerDrawCard(item)
                        }
                    }
                }

            }
        )


        if (viewModel.isPlayerDialogVisible.value) {
            TextDialog(viewModel.playerDialogViewModel)
        }

        if (viewModel.isRoleDialogVisible.value) {
            WGRoleDialog(viewModel.selectedRole!!) {
                viewModel.isRoleDialogVisible.value = false
            }
        }

        if(viewModel.isWarningDialogVisible.value) {
            TextDialog(viewModel.warningDialogViewModel)
        }
    }
}

