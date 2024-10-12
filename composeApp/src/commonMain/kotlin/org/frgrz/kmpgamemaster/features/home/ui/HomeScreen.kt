package org.frgrz.kmpgamemaster.features.home.ui

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
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGHomeScreen
import org.frgrz.kmpgamemaster.material.components.icons.ColorsScreen

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
                        onClick = { navigator.push(WGHomeScreen()) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text("Loup Garou")
                    }

                    //TODO: Not Implemented
                    FilledTonalButton(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        enabled = false
                    ) {
                        Text("Two rooms and a boom")
                    }

                    //TODO: Not Implemented
                    FilledTonalButton(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        enabled = false
                    ) {
                        Text("Sporz")
                    }

                    //TODO: Not Implemented
                    OutlinedButton(
                        onClick = { viewModel.onResetDatabaseClicked()},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text("Reset Database")
                    }

                    OutlinedButton(
                        onClick = { navigator.push(ColorsScreen())},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text("Colors")
                    }
                }
            }
        )
    }
}

