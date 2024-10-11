package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Remove

class WGHomeScreen : Screen {

    class CardItem

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<WGHomeViewModel>()
        var selectedCardIndex by remember { mutableStateOf<Int?>(null) }

        var dataList by remember {
            mutableStateOf(
                listOf(
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                    CardItem(),
                )
            )
        }

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Loup Garou") })
            },
            content = { _ ->
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    val column = createRef()

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(32.dp)
                            .wrapContentSize()
                            .constrainAs(column) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
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
                                val icon =
                                    rememberVectorPainter(
                                        image = IconPack.Remove
                                    )
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
                                val icon =
                                    rememberVectorPainter(
                                        image = Icons.Filled.Add
                                    )
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

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(5),
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.padding(12.dp)
                        ) {
                            itemsIndexed(dataList) { index, _ ->
                                Card(
                                    onClick = { selectedCardIndex = index },
                                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                                    shape = RoundedCornerShape(4.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1f)
                                        .then(
                                            if (index == selectedCardIndex) {
                                                Modifier.border(
                                                    2.dp,
                                                    Color.Blue,
                                                    RoundedCornerShape(4.dp)
                                                )
                                            } else {
                                                Modifier
                                            }
                                        )
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize()
                                            .background(Color.Red)
                                    )
                                }
                            }
                        }

                        TextButton(
                            onClick = {},
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
            }
        )
    }
}
