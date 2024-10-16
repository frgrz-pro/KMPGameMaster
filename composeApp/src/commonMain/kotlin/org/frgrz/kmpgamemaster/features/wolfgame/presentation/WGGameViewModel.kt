package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.core.moveItemsBeforeIndexToEnd
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetGameSettingsUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRoleDeckUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.CardItemViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGPlayerNameViewModel

class WGGameViewModel(
    getGameSettingsUseCase: GetGameSettingsUseCase,
    getRoleDeckUseCase: GetRoleDeckUseCase,
) : ScreenModel {

    private val isDebug = mutableStateOf(true)

    private val gameSettings = getGameSettingsUseCase.invoke()

    private val _cardItems = mutableStateListOf<CardItemViewModel>()
    val cardItems: List<CardItemViewModel> = _cardItems

    var isPlayerDialogVisible = mutableStateOf(!isDebug.value)
    var isRoleDialogVisible = mutableStateOf(false)

    private val startingPlayerIndex = getStartingPlayerIndex()
    private var orderedPlayers = orderPlayerList()
    private var playerToCall = orderedPlayers.first()

    var playerDialogViewModel = WGPlayerNameViewModel(playerToCall) {
        isPlayerDialogVisible.value = false
    }

    private var roles: List<WGRoleModel> = listOf()
    var selectedRole: WGRoleModel? = null

    init {
        screenModelScope.launch {
            getRoleDeckUseCase.setRoles(
                gameSettings.value.selectedRoles, gameSettings.value.players.size,
                gameSettings.value.wolvesCount
            )

            val deck = getRoleDeckUseCase.buildDeck()
            roles = deck.roles
            _cardItems.addAll(createCardItems())

            if (isDebug.value) {
                autoDealRoles()
            }
        }
    }

    private fun autoDealRoles() {
        orderedPlayers.forEachIndexed { index, player ->
            _cardItems[index].playerName.value = player
            _cardItems[index].role.value = roles[index]
            _cardItems[index].isClickable.value = false
        }
    }

    private fun getStartingPlayerIndex() = (0..gameSettings.value.players.size).random()

    private fun orderPlayerList() =
        gameSettings.value.players.moveItemsBeforeIndexToEnd(startingPlayerIndex)

    private fun onRoleDrawn(cardId: Int) {
        if (cardId in _cardItems.indices && _cardItems[cardId].isClickable.value) {
            _cardItems[cardId].isClickable.value = false
            _cardItems[cardId].playerName.value = playerToCall
        }

        callNextPlayer()
    }

    private fun callNextPlayer() {
        orderedPlayers = orderedPlayers.drop(1)
        if (orderedPlayers.isNotEmpty()) {
            playerToCall = orderedPlayers.first()
            playerDialogViewModel = WGPlayerNameViewModel(playerToCall) {
                isPlayerDialogVisible.value = false
            }
            isPlayerDialogVisible.value = true
        }
    }

    private fun createCardItems(): List<CardItemViewModel> {
        return List(gameSettings.value.players.size) { index ->
            CardItemViewModel(
                index,
                role = mutableStateOf(roles[index]),
                isDebug = isDebug,
                onCardClicked = { cardId ->
                    if (!isDebug.value) {
                        selectedRole = roles[cardId]
                        isRoleDialogVisible.value = true
                        onRoleDrawn(cardId)
                    }
                }
            )
        }
    }
}
