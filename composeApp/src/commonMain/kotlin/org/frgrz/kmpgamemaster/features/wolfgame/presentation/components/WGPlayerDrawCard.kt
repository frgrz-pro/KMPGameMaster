package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.material.theme.AppTheme


data class CardItemViewModel(
    val id: Int,
    val playerName: MutableState<String> = mutableStateOf(""),
    val isClickable: MutableState<Boolean> = mutableStateOf(true),
    val role: WGRoleModel,
    val onCardClicked: (Int) -> Unit,
)

@Composable
fun WGPlayerDrawCard(viewModel: CardItemViewModel) {
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
            Text(
                text = viewModel.playerName.value,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.titleLarge,
                color = if (viewModel.isClickable.value) {
                    MaterialTheme.colorScheme.onPrimaryContainer
                } else {
                    MaterialTheme.colorScheme.primaryContainer
                }
            )

        }
    }
}

@Composable
@Preview
fun WGPlayerDrawCard_Unselected_Preview() {
    AppTheme {
        WGPlayerDrawCard(
            CardItemViewModel(
                id = 0,
                playerName = mutableStateOf("Card 1"),
                isClickable = mutableStateOf(true),
                role = PreviewData.roleModel,
                onCardClicked = {}
            )
        )
    }
}

@Composable
@Preview
fun WGPlayerDrawCard_Selected_Preview() {
    AppTheme {
        WGPlayerDrawCard(
            CardItemViewModel(
                id = 0,
                playerName = mutableStateOf("Player 1"),
                isClickable = mutableStateOf(false),
                role = PreviewData.roleModel,
                onCardClicked = {}
            )
        )
    }
}