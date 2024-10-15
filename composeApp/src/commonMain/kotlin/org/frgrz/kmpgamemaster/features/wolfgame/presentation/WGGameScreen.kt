package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetGameSettingsUseCase
import kotlin.collections.addAll
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
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(viewModel.cards) { card ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable(enabled = card.isClickable) {
                                    viewModel.onCardClick(card.id)
                                },
                            //elevation = 2.dp
                        ) {
                            // Empty card content for now
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .background(if (card.isClickable) Color.White else Color.DarkGray)
                            )
                        }
                    }
                }
            }
        )
    }
}

class WGGameViewModel(private val getGameSettingsUseCase: GetGameSettingsUseCase) : ScreenModel {
    private val gameSettings = getGameSettingsUseCase.invoke()

    private val _cards = mutableStateListOf<CardItem>()
    val cards: List<CardItem> = _cards

    init {
        // Initialize with some initial cards
        _cards.addAll((1..10).map { CardItem(it) })
    }

    fun onCardClick(cardId: Int) {
        val cardIndex = _cards.indexOfFirst { it.id == cardId }
        if (cardIndex != -1 && _cards[cardIndex].isClickable) {
            val card = _cards.removeAt(cardIndex)
            card.isClickable = false
            _cards.add(card)
        }
    }


}

data class CardItem(val id: Int, var isClickable: Boolean = true)