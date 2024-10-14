package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Remove

class WGPlayersScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {

        val viewModel = getScreenModel<WGPlayersViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Players") })
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(innerPadding)
                        .padding(24.dp)

                ) {
                    Row {
                        TextField(
                            value = viewModel.currentInput.value,
                            onValueChange = { newValue ->
                                viewModel.currentInput.value = newValue
                            },
                            label = { Text("Add a player") },
                            modifier = Modifier.weight(1f)
                                .background(MaterialTheme.colorScheme.background),
                            maxLines = 1,

                            )

                        IconButton(
                            onClick = { viewModel.addEntry() },
                            modifier = Modifier
                                .size(48.dp) // Set size for square shape
                                .aspectRatio(1f) // Ensure aspect ratio for square
                                .padding(start = 16.dp)
                                .align(Alignment.CenterVertically)
                                .combinedClickable(
                                    onClick = { viewModel.addEntry() },
                                    onLongClick = { viewModel.seed() }
                                )
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add, // Replace with your icon
                                contentDescription = "More options",
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn {
                        itemsIndexed(viewModel.entries) { index, entry ->

                            Card(
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                                shape = RoundedCornerShape(4.dp),
                                modifier = Modifier.fillMaxWidth()
                                    .padding(horizontal = 0.dp, vertical = 2.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.onTertiaryContainer)
                                        .padding(horizontal = 4.dp, vertical = 2.dp)

                                ) {
                                    Row(modifier = Modifier.fillMaxWidth()) {
                                        Text(
                                            text = entry,
                                            modifier = Modifier.weight(1f)
                                                .padding(start = 8.dp)
                                                .align(Alignment.CenterVertically),

                                            style = MaterialTheme.typography.titleLarge,
                                            color = MaterialTheme.colorScheme.tertiaryContainer
                                        )

                                        IconButton(
                                            onClick = { viewModel.removeEntry(index) },
                                            modifier = Modifier
                                                .size(48.dp) // Set size for square shape
                                                .aspectRatio(1f) // Ensure aspect ratio for square
                                                .padding(start = 16.dp)

                                        ) {
                                            Icon(
                                                imageVector = IconPack.Remove, // Replace with your icon
                                                contentDescription = "More options",
                                                tint = MaterialTheme.colorScheme.tertiaryContainer
                                            )
                                        }
                                    }

                                }

                            }
                        }
                    }
                }
            }
        )
    }
}

class WGPlayersViewModel : ScreenModel {
    private val _entries = mutableStateListOf<String>()
    val entries: List<String> = _entries
    var currentInput = mutableStateOf("")


    fun addEntry() {
        if (currentInput.value.length >= 3) {
            _entries.add(currentInput.value)
            currentInput.value = ""
        }
    }

    fun removeEntry(index: Int) {
        _entries.removeAt(index)
    }

    fun seed() {
        _entries.add("Emile")
        _entries.add("Bonaventure")
        _entries.add("Francois")
        _entries.add("Marion")
        _entries.add("Florence")
        _entries.add("Faouzi")
        _entries.add("Salim")
        _entries.add("Matthieu")
        _entries.add("Hedi")
        _entries.add("Tom")
        _entries.add("Kelly")
        _entries.add("Amaïa")
    }

}

