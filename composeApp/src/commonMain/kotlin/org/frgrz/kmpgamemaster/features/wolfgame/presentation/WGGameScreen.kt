package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
                        items(viewModel.cards) { card ->
                            CardItem(card)
                        }
                    }
                }

            }
        )
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
        }
    }
}

data class CardItemViewModel(
    val id: Int,
    val isClickable: MutableState<Boolean> = mutableStateOf(true),
    val onCardClicked: (Int) -> Unit,
)


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
                        Color.White
                    } else {
                        Color.DarkGray
                    }
                )
        ) {
        }
    }
}