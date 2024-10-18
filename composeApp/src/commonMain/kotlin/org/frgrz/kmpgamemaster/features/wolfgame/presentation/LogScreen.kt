package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.LogEntry
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Assign
import org.frgrz.kmpgamemaster.material.components.icons.Deck
import org.frgrz.kmpgamemaster.material.components.icons.PersonAdd
import org.frgrz.kmpgamemaster.material.components.icons.PersonRemove
import org.frgrz.kmpgamemaster.material.components.icons.Settings

class LogScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = getScreenModel<LogScreenViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Game Log") })
            },
            content = { innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    itemsIndexed(viewModel.log.value) { _, entry ->
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .padding(2.dp),
                        ) {
                            Icon(
                                modifier = Modifier.height(24.dp)
                                    .aspectRatio(1f),
                                imageVector = getImageVector(entry.type),
                                contentDescription = ""
                            )

                            Text(
                                text = entry.text,
                                modifier = Modifier.align(Alignment.CenterVertically)
                                    .padding(start = 8.dp),
                            )
                        }
                    }
                }
            }
        )
    }

    private fun getImageVector(type: LogEntry.Type): ImageVector {
        return when (type) {
            LogEntry.Type.ADD_PLAYER -> IconPack.PersonAdd
            LogEntry.Type.REMOVE_PLAYER -> IconPack.PersonRemove
            LogEntry.Type.GAME_CONFIGURATION -> IconPack.Settings
            LogEntry.Type.ROLE_DECK -> IconPack.Deck
            LogEntry.Type.ROLE_ASSIGNED -> IconPack.Assign
        }
    }
}

