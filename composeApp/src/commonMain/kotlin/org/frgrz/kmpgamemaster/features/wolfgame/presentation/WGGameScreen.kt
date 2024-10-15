package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetGameSettingsUseCase
import kotlin.collections.indexOfFirst

class WGGameScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = getScreenModel<WGGameViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Game") })
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
                        items(viewModel.cards) { item ->
                            CardItem(item)
                        }
                    }
                }

            }
        )


        if (viewModel.showDialog.value) {
            SimpleDialog(text = viewModel.playerToCall) {
                viewModel.onDialogDismissed()
            }
        }
    }
}

@Composable
fun SimpleDialog(text: String, onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Card(
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text)
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onDismiss,
                    modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text("Dismiss")
                }
            }
        }
    }
}

class WGGameViewModel(getGameSettingsUseCase: GetGameSettingsUseCase) : ScreenModel {

    private val gameSettings = getGameSettingsUseCase.invoke()

    private val _cards = mutableStateListOf<CardItemViewModel>()
    val cards: List<CardItemViewModel> = _cards


    init {
        screenModelScope.launch {
            _cards.addAll(List(gameSettings.value.players.size) { index ->
                CardItemViewModel(index, onCardClicked = { cardId ->
                    onCardClick(cardId)
                })
            })


        }
    }

    private fun onCardClick(cardId: Int) {
        val cardIndex = _cards.indexOfFirst { it.id == cardId }
        if (cardIndex != -1 && _cards[cardIndex].isClickable.value) {
            _cards[cardIndex].isClickable.value = false
            _cards[cardIndex].playerName.value = playerToCall
        }

        callNextPlayer()
    }

    private val randomFirstPlayerIndex = (0..gameSettings.value.players.size).random()
    private var remainingPlayersToCall =
        gameSettings.value.players.moveItemsBeforeIndexToEnd(randomFirstPlayerIndex)
    var showDialog = mutableStateOf(true)
    var playerToCall = remainingPlayersToCall.first()

    fun onDialogDismissed() {
        showDialog.value = false
        //callNextPlayer()
    }

    private fun callNextPlayer() {
        if (remainingPlayersToCall.isNotEmpty()) {
            remainingPlayersToCall = remainingPlayersToCall.drop(1)
        }

        if(remainingPlayersToCall.isNotEmpty()) {
            playerToCall = remainingPlayersToCall.first()
            showDialog.value = true
        }
    }

    //TODO : Move to use case

    private fun <T> List<T>.moveItemsBeforeIndexToEnd(randomIndex: Int): List<T> {
        if (randomIndex <= 0 || randomIndex >= this.size) {
            return this // Return original list if index is invalid
        }
        return this.subList(randomIndex, this.size) + this.subList(0, randomIndex)
    }

}







 class CardItemViewModel(
    val id: Int,
    val playerName:MutableState<String> = mutableStateOf(""),
    val isClickable: MutableState<Boolean> = mutableStateOf(true),
    val onCardClicked: (Int) -> Unit,
) {
     fun assignPlayerName(name:String) {
         playerName.value = name
     }
 }


@Composable
fun CardItem(viewModel: CardItemViewModel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(enabled = viewModel.isClickable.value) {
                viewModel.onCardClicked(viewModel.id)
            }
    ) {
        Box(
            modifier = Modifier
                .height(72.dp)
                .fillMaxWidth()
                .background(
                    if (viewModel.isClickable.value) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    }
                )
        ) {
            Text(text = viewModel.playerName.value,
                modifier = Modifier.align(Alignment.Center),
                style  = MaterialTheme.typography.titleLarge,
                color = if (viewModel.isClickable.value) {
                    MaterialTheme.colorScheme.onPrimaryContainer
                } else {
                    MaterialTheme.colorScheme.primaryContainer
                })

        }
    }
}