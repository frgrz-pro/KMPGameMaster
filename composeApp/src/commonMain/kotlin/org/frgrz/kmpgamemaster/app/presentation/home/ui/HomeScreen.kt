package org.frgrz.kmpgamemaster.app.presentation.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.sporz
import kmpgamemaster.composeapp.generated.resources.two_rooms_and_a_boom
import kmpgamemaster.composeapp.generated.resources.werewolf
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGPlayersScreen
import org.frgrz.kmpgamemaster.material.components.ColorsScreen
import org.jetbrains.compose.resources.stringResource

class HomeScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<HomeViewModel>()


        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Home") })
            },
            content = { paddingValues ->
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues), // Use padding values from the Scaffold
                ) {
                    FilledTonalButton(
                        onClick = { navigator.push(WGPlayersScreen()) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text(stringResource(Res.string.werewolf))
                    }

                    //TODO: Implement Two Rooms & a boom
                    FilledTonalButton(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        enabled = false
                    ) {
                        Text(stringResource(Res.string.two_rooms_and_a_boom))
                    }

                    //TODO: Implement Sporz
                    FilledTonalButton(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        enabled = false
                    ) {
                        Text(stringResource(Res.string.sporz))
                    }

                    //TODO: Implement Reset Database
                    OutlinedButton(
                        onClick = { viewModel.onResetDatabaseClicked()},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text("Reset Database") //TODO Add string reset database
                    }

                    OutlinedButton(
                        onClick = { navigator.push(ColorsScreen())},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text("Colors") //TODO Add string colors
                    }
                }
            }
        )
    }
}

