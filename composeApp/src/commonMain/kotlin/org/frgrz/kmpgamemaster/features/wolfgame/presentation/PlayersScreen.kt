package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.AddPlayerField
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.PlayerEntryCard


class PlayersScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<PlayersScreenViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Players") },
                    actions = {
                        IconButton(
                            onClick = { viewModel.seed() },
                        ) {
                            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
                        }
                    })
            },
            content = { innerPadding ->
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                        .padding(innerPadding)
                        .padding(24.dp)
                ) {
                    val column = createRef()
                    val button = createRef()

                    Column(
                        modifier = Modifier.constrainAs(column) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(button.top)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        }.padding(bottom = 4.dp)
                    ) {
                        AddPlayerField(viewModel.currentInput.value, { newValue->
                            viewModel.currentInput.value = newValue
                        }, {
                            viewModel.addEntry()
                        })

                        Spacer(modifier = Modifier.height(8.dp))

                        LazyColumn {
                            itemsIndexed(viewModel.entries) { index, entry ->
                                PlayerEntryCard(entry, index) { viewModel.removeEntry(index) }
                            }
                        }
                    }

                    FilledTonalButton(
                        onClick = {
                            viewModel.savePlayers()
                            navigator.push(SetupScreen())
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .constrainAs(button) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            },
                        enabled = viewModel.isValidateButtonEnabled.value
                    ) {
                        Text("Valider") //TODO String resource
                    }
                }
            }
        )
    }
}
