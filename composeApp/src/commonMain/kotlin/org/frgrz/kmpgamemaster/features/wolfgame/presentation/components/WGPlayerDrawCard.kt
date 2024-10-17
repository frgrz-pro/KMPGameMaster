package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.material.theme.AppTheme


data class CardItemViewModel(
    val id: Int,
    val playerName: MutableState<String> = mutableStateOf(""),
    val isClickable: MutableState<Boolean> = mutableStateOf(true),
    val role: MutableState<WGRoleModel>,
    val onCardClicked: (Int) -> Unit,
    val isDebug: MutableState<Boolean>,
)

@Composable
fun WGPlayerDrawCard(viewModel: CardItemViewModel) {
    val bg = with(viewModel.role.value.role) {
        when {
           isWolf() && !isWolfAndAddsWolf() -> MaterialTheme.colorScheme.onPrimaryContainer
            isVillager() && !isVillagerAndAddsWolf()-> MaterialTheme.colorScheme.primaryContainer
            isWolfAndAddsWolf() || isVillagerAndAddsWolf()-> MaterialTheme.colorScheme.secondaryContainer
            isSolo() -> MaterialTheme.colorScheme.tertiaryContainer
            else -> MaterialTheme.colorScheme.surfaceBright
        }
    }

    val tx = with(viewModel.role.value.role)  {
        when {
            isWolf() && !isWolfAndAddsWolf() -> MaterialTheme.colorScheme.primaryContainer
            isVillager() && !isVillagerAndAddsWolf()-> MaterialTheme.colorScheme.onPrimaryContainer
            isWolfAndAddsWolf() || isVillagerAndAddsWolf()-> MaterialTheme.colorScheme.onSecondaryContainer
            isSolo() -> MaterialTheme.colorScheme.onTertiaryContainer
            else -> MaterialTheme.colorScheme.onSurface
        }
    }


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
                    bg
                    /*if (viewModel.isClickable.value) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    }*/
                )
        ) {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val text = createRef()
                val image = createRef()
                val text2 = createRef()

                if (viewModel.isDebug.value) {
                    WGRoleImageLarge(
                        role = viewModel.role.value.role,
                        modifier = Modifier.fillMaxHeight()
                            .aspectRatio(1f)
                            .constrainAs(image) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                bottom.linkTo(parent.bottom)
                            }
                    )
                }

                Text(
                    text = viewModel.playerName.value,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .constrainAs(text) {
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                            if(viewModel.isDebug.value) {
                                start.linkTo(image.end)
                            } else {
                                start.linkTo(parent.start)
                            }
                        },
                    style = MaterialTheme.typography.titleLarge,
                    color = tx/*if (viewModel.isClickable.value) {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    } else {
                        MaterialTheme.colorScheme.primaryContainer
                    }*/,
                )
                if (viewModel.isDebug.value) {
                    Text(
                        text = viewModel.role.value.role.name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .constrainAs(text2) {
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                verticalBias = 1f
                                if(viewModel.isDebug.value) {
                                    start.linkTo(image.end)
                                } else {
                                    start.linkTo(parent.start)
                                }
                            },
                        style = MaterialTheme.typography.labelMedium,
                        color = tx /*if (viewModel.isClickable.value) {
                            MaterialTheme.colorScheme.onPrimaryContainer
                        } else {
                            MaterialTheme.colorScheme.primaryContainer
                        },*/
                    )
                }
            }
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
                role = mutableStateOf(PreviewData.roleModel),
                onCardClicked = {},
                isDebug = mutableStateOf(true)
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
                role = mutableStateOf(PreviewData.roleModel),
                onCardClicked = {},
                isDebug = mutableStateOf(true)
            )
        )
    }
}