package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.core.moveItemsBeforeIndexToEnd
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleDeck
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetGameConfigurationUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.GenerateRoleDeckUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.LogCacheGameSettingsUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.LogRoleAssignedUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.PlayerRoleCardDrawViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleDialogViewModel
import org.frgrz.kmpgamemaster.material.components.TextDialogViewModel

class GameScreenViewModel(
    getGameConfigurationUseCase: GetGameConfigurationUseCase,
    getRoleDeckUseCase: GenerateRoleDeckUseCase,
    private val logCacheGameSettingsUseCase: LogCacheGameSettingsUseCase,
    private val logRoleAssignedUseCase: LogRoleAssignedUseCase,
) : ScreenModel {

    private val isDebug = mutableStateOf(false)
    private val state = mutableStateOf(if (isDebug.value) ScreenState.REVEAL else ScreenState.NORMAL)


    private val gameConfiguration = getGameConfigurationUseCase.invoke()
    private var deck = RoleDeck()

    private val _cardItems = mutableStateListOf<PlayerRoleCardDrawViewModel>()
    val cardItems: List<PlayerRoleCardDrawViewModel> = _cardItems

    var isPlayerDialogVisible = mutableStateOf(!isDebug.value)
    var isRoleDialogVisible = mutableStateOf(false)

    private val startingPlayerIndex = getStartingPlayerIndex()
    private var orderedPlayers = orderPlayerList()
    private var playerToCall = orderedPlayers.first()

    var playerDialogViewModel = TextDialogViewModel(playerToCall) {
        isPlayerDialogVisible.value = false
    }

    private var roles: List<WGRoleModel> = listOf()



    private val _roleDialogModel = mutableStateOf<RoleDialogViewModel?>(null)
    val roleDialogModel: State<RoleDialogViewModel?> = _roleDialogModel


    init {
        screenModelScope.launch {
            getRoleDeckUseCase.setGameConfiguration(gameConfiguration.value)
            logCacheGameSettingsUseCase.log(gameConfiguration.value)
            deck = getRoleDeckUseCase.generateRoleDeck()
            roles = deck.roles
            _cardItems.addAll(createPlayerCardItems())

            if (isDebug.value) {
                autoDealRoles()
            }
        }
    }

    private fun autoDealRoles() {
        orderedPlayers.forEachIndexed { index, player ->
            _cardItems[index].playerName.value = player
            _cardItems[index].role.value = roles[index]
            logRoleAssignedUseCase.log(player, roles[index].role)
            _cardItems[index].isClickable.value = false
        }

        if (deck.extraRoles.isNotEmpty()) {
            _cardItems.addAll(addExtraRolesCardItems())

            for (i in roles.size until _cardItems.size) {
                _cardItems[i].playerName.value = "Extra #${i - roles.size + 1}"
                _cardItems[i].role.value = deck.extraRoles[i - roles.size]
                logRoleAssignedUseCase.log(_cardItems[i].playerName.value, _cardItems[i].role.value.role)

                _cardItems[i].isClickable.value = false
            }
        }
    }

    private fun getStartingPlayerIndex() = (0..gameConfiguration.value.players.size).random()

    private fun orderPlayerList() =
        gameConfiguration.value.players.moveItemsBeforeIndexToEnd(startingPlayerIndex)

    private fun onRoleDrawn(cardId: Int) {
        if (cardId in _cardItems.indices && _cardItems[cardId].isClickable.value) {
            _cardItems[cardId].isClickable.value = false
            _cardItems[cardId].playerName.value = playerToCall
            logRoleAssignedUseCase.log(playerToCall, _cardItems[cardId].role.value.role)
        }

        callNextPlayer()
    }

    private fun callNextPlayer() {
        orderedPlayers = orderedPlayers.drop(1)
        if (orderedPlayers.isNotEmpty()) {
            playerToCall = orderedPlayers.first()
            playerDialogViewModel = TextDialogViewModel(playerToCall) {
                isPlayerDialogVisible.value = false
            }
            isPlayerDialogVisible.value = true
        }
    }

    private fun addExtraRolesCardItems(): List<PlayerRoleCardDrawViewModel> {
        return List(deck.extraRoles.size) { index ->
            PlayerRoleCardDrawViewModel(
                index + _cardItems.size,
                role = mutableStateOf(deck.extraRoles[index]),
                state = state,
                onCardClicked = {},
                isExtraRole = true
            )
        }
    }

    private var revealClickCount = 0
    val isWarningDialogVisible = mutableStateOf(false)
    val warningDialogViewModel = TextDialogViewModel("Accès réservé au maitre du jeu") {
        isWarningDialogVisible.value = false
    }

    private var accessLogClickCount = 0

    fun onAccessLogClicked(onAccessAuthorized: () -> Unit) {
        accessLogClickCount++
        if (accessLogClickCount == 5 || isDebug.value) {
            accessLogClickCount = 0
            onAccessAuthorized.invoke()
        } else {
            isWarningDialogVisible.value = true
        }

    }

    fun toggleState() {
        if (state.value == ScreenState.NORMAL) {
            revealClickCount++
            if (revealClickCount == 5 || isDebug.value) {
                revealClickCount = 0
                state.value = ScreenState.REVEAL
            } else {
                isWarningDialogVisible.value = true
            }
        } else {
            state.value = ScreenState.NORMAL
        }
    }

    private fun createPlayerCardItems(): List<PlayerRoleCardDrawViewModel> {
        return List(gameConfiguration.value.players.size) { index ->
            PlayerRoleCardDrawViewModel(
                index,
                role = mutableStateOf(roles[index]),
                state = state,
                onCardClicked = { cardId ->
                    if (!isDebug.value) {
                        _roleDialogModel.value = RoleDialogViewModel(roles[cardId], ::dismissRoleDialog)
                        showRoleDialog()
                        onRoleDrawn(cardId)
                    }
                }
            )
        }
    }

    private fun dismissRoleDialog() {
        isRoleDialogVisible.value = false
    }

    private fun showRoleDialog() {
        isRoleDialogVisible.value = true
    }

    enum class ScreenState {
        NORMAL, REVEAL
    }
}
