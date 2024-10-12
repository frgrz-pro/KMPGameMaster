package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRules
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.repository.WGRoleRepository
import org.frgrz.kmpgamemaster.utils.RequestState

typealias MutableRoles = MutableState<RequestState<List<WGRoleModel>>>
typealias Roles = MutableState<RequestState<List<WGRoleModel>>>

class WGHomeViewModel(private val repository: WGRoleRepository) : ScreenModel {

    var playerCount = mutableStateOf(WGRules.OPTIMAL_PLAYER_COUNT)
    var playerLabel = mutableStateOf("Joueurs : " + playerCount.value.toString())
    val maxPlayers = WGRules.MAX_PLAYER_COUNT
    val minPlayers = WGRules.MIN_PLAYER
    var wolvesCount = mutableStateOf(WGRules.OPTIMAL_WOLVES_COUNT)
    var wolvesLabel = mutableStateOf("${wolvesCount.value} Loups")
    var canAddWolves = mutableStateOf(true)
    var canRemoveWolves = mutableStateOf(true)


    private var _selectedRoles: MutableRoles = mutableStateOf(RequestState.Idle)
    val selectedRoles: Roles = _selectedRoles

    init {
        _selectedRoles.value = RequestState.Loading
        screenModelScope.launch(Dispatchers.Main) {
            repository.getAllChecked(true)
                .collectLatest {
                    _selectedRoles.value = it
                }
        }
    }

    fun onPlayerCountChanged(count: Int) {
        playerCount.value = count
        playerLabel.value = "Joueurs : " + playerCount.value
        val optimalWolvesCount = WGRules.getOptimalWolvesCount(count)
        updateWolvesCount(optimalWolvesCount)
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
