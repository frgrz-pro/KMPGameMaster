package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.core.RequestState
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.CacheGameSettingsUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetCachedPlayersUseCase

typealias MutableRoles = MutableState<RequestState<List<WGRoleModel>>>
typealias Roles = MutableState<RequestState<List<WGRoleModel>>>


class WGSetupViewModel(
    private val getRoleSelectionUseCase: GetRoleSelectionUseCase,
    private val getCachedPlayersUseCase: GetCachedPlayersUseCase,
    private val cacheGameSettingsUseCase: CacheGameSettingsUseCase
) : ScreenModel {

    var playerCount = mutableStateOf(WGRules.OPTIMAL_PLAYER_COUNT)
    var playerLabel = mutableStateOf("Joueurs : " + playerCount.value.toString())
    var wolvesCount = mutableStateOf(WGRules.OPTIMAL_WOLVES_COUNT)
    var wolvesLabel = mutableStateOf("${wolvesCount.value} Loups")
    var canAddWolves = mutableStateOf(true)
    var canRemoveWolves = mutableStateOf(true)


    private var _selectedRoles: MutableRoles = mutableStateOf(RequestState.Idle)
    val selectedRoles: Roles = _selectedRoles

    init {
        _selectedRoles.value = RequestState.Loading
        screenModelScope.launch(Dispatchers.Main) {
            getRoleSelectionUseCase.invoke(true)
                .collectLatest {
                    _selectedRoles.value = it
                }
        }

        //TODO Should Listen to cache
        val players = getCachedPlayersUseCase.invoke()
        onPlayerCountChanged(players.size)
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
