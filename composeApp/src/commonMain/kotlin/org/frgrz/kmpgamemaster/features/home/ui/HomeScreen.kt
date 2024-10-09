package org.frgrz.kmpgamemaster.features.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGHomeScreen
import org.jetbrains.compose.resources.stringResource

class HomeScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<HomeViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = stringResource(Res.string.home)) })
            },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues) // Use padding values from the Scaffold
                ) {
                    // Spacer to push the button down to 2/3 of the screen height
                    Button(
                        onClick = {
                            navigator.push(WGHomeScreen())
                        },
                        modifier = Modifier
                            .padding(bottom = 16.dp) // Optional padding
                    ) {
                        Text("Werewolf Game")
                    }

                }
            }

        )

    }
}
