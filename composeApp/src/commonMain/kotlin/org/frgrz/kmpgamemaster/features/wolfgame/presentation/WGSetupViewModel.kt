package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.core.RequestState
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.db.GetRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.cache.CacheGameSettingsUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.cache.GetCachedPlayersUseCase

class WGSetupViewModel(
    private val getRoleSelectionUseCase: GetRoleSelectionUseCase,
    getCachedPlayersUseCase: GetCachedPlayersUseCase,
    private val cacheGameSettingsUseCase: CacheGameSettingsUseCase,
) : ScreenModel {

    private val players: StateFlow<List<String>> = getCachedPlayersUseCase.invoke()
    private var playerCount = mutableStateOf(WGRules.OPTIMAL_PLAYER_COUNT)
    var playerLabel = mutableStateOf("Joueurs : " + playerCount.value.toString())
    var canStartGame = mutableStateOf(playerCount.value > WGRules.MIN_PLAYER)

    private var _selectedRoles: MutableState<RequestState<List<WGRoleModel>>> =
        mutableStateOf(RequestState.Idle)
    val selectedRoles: MutableState<RequestState<List<WGRoleModel>>> = _selectedRoles

    private var wolvesCount = mutableStateOf(WGRules.OPTIMAL_WOLVES_COUNT)
    var wolvesLabel = mutableStateOf("${wolvesCount.value} Loups")
    var canAddWolves = mutableStateOf(true)
    var canRemoveWolves = mutableStateOf(true)

    init {
        _selectedRoles.value = RequestState.Loading
        screenModelScope.launch(Dispatchers.Main) {
            getRoleSelectionUseCase.invoke(true)
                .collectLatest {
                    _selectedRoles.value = it
                }
        }

        screenModelScope.launch(Dispatchers.Main) {
            players.collectLatest {
                onPlayerCountChanged(it.size)
            }
        }
    }

    fun onAddWolvesClicked() {
        if (!canAddWolves.value)
            return

        updateWolvesCount(wolvesCount.value + 1)
    }

    fun onRemoveWolvesClicked() {
        if (!canRemoveWolves.value)
            return

        updateWolvesCount(wolvesCount.value - 1)
    }

    fun saveGameSettings() {
        cacheGameSettingsUseCase.invoke(selectedRoles.value.getSuccessData(), wolvesCount.value)
    }

    private fun onPlayerCountChanged(count: Int) {
        playerCount.value = count
        playerLabel.value = "Joueurs : " + playerCount.value
        canStartGame.value = playerCount.value > WGRules.MIN_PLAYER
        val optimalWolvesCount = WGRules.getOptimalWolvesCount(count)
        updateWolvesCount(optimalWolvesCount)
    }

    private fun updateWolvesCount(wolves: Int) {
        wolvesCount.value = wolves
        wolvesLabel.value = "${wolvesCount.value} Loups"
        updateAddRemoveWolves()
    }

    private fun updateAddRemoveWolves() {
        canAddWolves.value = WGRules.canAddWolves(playerCount.value, wolvesCount.value)
        canRemoveWolves.value = WGRules.canRemoveWolves(wolvesCount.value)
    }

}
