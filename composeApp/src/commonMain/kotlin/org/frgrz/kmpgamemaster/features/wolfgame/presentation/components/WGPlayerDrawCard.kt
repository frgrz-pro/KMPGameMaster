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
import androidx.compose.foundation.layout.wrapContentHeight
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
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.GameScreenViewModel
import org.frgrz.kmpgamemaster.material.theme.AppTheme


data class CardItemViewModel(
    val id: Int,
    val playerName: MutableState<String> = mutableStateOf(""),
    val isClickable: MutableState<Boolean> = mutableStateOf(true),
    val role: MutableState<WGRoleModel>,
    val onCardClicked: (Int) -> Unit,
    val state: MutableState<GameScreenViewModel.ScreenState>,
    val isExtraRole: Boolean = false,
)

@Composable
fun WGPlayerDrawCard(viewModel: CardItemViewModel) {
    val bg = if (viewModel.state.value == GameScreenViewModel.ScreenState.REVEAL) {
        with(viewModel.role.value.role) {


            if(viewModel.isExtraRole){
                MaterialTheme.colorScheme.secondary
            } else {
                when {
                    isWolf() && !isWolfAndAddsWolf() -> MaterialTheme.colorScheme.onPrimaryContainer
                    isVillager() && !(isVillagerAndAddsWolf() || isExtraRole()) -> MaterialTheme.colorScheme.primaryContainer
                    isVillager() && isVillagerAndAddsWolf() -> MaterialTheme.colorScheme.primary
                    (isVillager() && isExtraRole()) || viewModel.isExtraRole -> MaterialTheme.colorScheme.secondary
                    isWolfAndAddsWolf() || isVillagerAndAddsWolf() -> MaterialTheme.colorScheme.secondaryContainer
                    isSolo() -> MaterialTheme.colorScheme.tertiaryContainer
                    else -> MaterialTheme.colorScheme.surfaceBright
                }
            }
        }
    } else {
        if (viewModel.isClickable.value) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.onPrimaryContainer
        }
    }

    val tx = if (viewModel.state.value == GameScreenViewModel.ScreenState.REVEAL) {
        with(viewModel.role.value.role) {
            if(viewModel.isExtraRole){
                MaterialTheme.colorScheme.onSecondary
            } else {
                when {
                    isWolf() && !isWolfAndAddsWolf() -> MaterialTheme.colorScheme.primaryContainer
                    isVillager() && !(isVillagerAndAddsWolf() || isExtraRole()) -> MaterialTheme.colorScheme.onPrimaryContainer
                    isVillager() && isVillagerAndAddsWolf() -> MaterialTheme.colorScheme.onPrimary
                    (isVillager() && isExtraRole()) || viewModel.isExtraRole -> MaterialTheme.colorScheme.onSecondary
                    isWolfAndAddsWolf() || isVillagerAndAddsWolf() -> MaterialTheme.colorScheme.onSecondaryContainer
                    isSolo() -> MaterialTheme.colorScheme.onTertiaryContainer
                    else -> MaterialTheme.colorScheme.onSurface
                }
            }
        }
    } else {
        if (viewModel.isClickable.value) {
            MaterialTheme.colorScheme.onPrimaryContainer
        } else {
            MaterialTheme.colorScheme.primaryContainer
        }
    }

    val heightModifier = when {
        viewModel.state.value == GameScreenViewModel.ScreenState.NORMAL && viewModel.isExtraRole -> Modifier.height(0.dp)
        viewModel.state.value == GameScreenViewModel.ScreenState.NORMAL && !viewModel.isExtraRole -> Modifier.wrapContentHeight()
        viewModel.state.value == GameScreenViewModel.ScreenState.REVEAL && viewModel.isExtraRole -> Modifier.wrapContentHeight()
        viewModel.state.value == GameScreenViewModel.ScreenState.REVEAL && !viewModel.isExtraRole -> Modifier.wrapContentHeight()
        else -> Modifier.wrapContentHeight()
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(enabled = viewModel.isClickable.value) {
                viewModel.onCardClicked(viewModel.id)
            }.then(heightModifier)

    ) {
        Box(
            modifier = Modifier
                .height(72.dp)
                .fillMaxWidth()
                .background(bg)
        ) {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val text = createRef()
                val image = createRef()
                val text2 = createRef()

                if (viewModel.state.value == GameScreenViewModel.ScreenState.REVEAL) {
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
                            if (viewModel.state.value == GameScreenViewModel.ScreenState.REVEAL) {
                                start.linkTo(image.end)
                            } else {
                                start.linkTo(parent.start)
                            }
                        },
                    style = MaterialTheme.typography.titleLarge,
                    color = tx
                )
                if (viewModel.state.value == GameScreenViewModel.ScreenState.REVEAL) {
                    Text(
                        text = viewModel.role.value.role.name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .constrainAs(text2) {
                                top.linkTo(text.bottom)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                if (viewModel.state.value == GameScreenViewModel.ScreenState.REVEAL) {
                                    start.linkTo(image.end)
                                } else {
                                    start.linkTo(parent.start)
                                }
                            },
                        style = MaterialTheme.typography.labelMedium,
                        color = tx
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
                state = mutableStateOf(GameScreenViewModel.ScreenState.NORMAL)
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
                state = mutableStateOf(GameScreenViewModel.ScreenState.NORMAL)
            )
        )
    }
}