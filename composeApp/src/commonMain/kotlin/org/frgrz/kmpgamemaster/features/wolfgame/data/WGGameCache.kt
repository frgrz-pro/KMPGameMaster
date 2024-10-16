package org.frgrz.kmpgamemaster.features.wolfgame.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameSettings
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

class WGGameCache {

    private val _gameSettings = MutableStateFlow(GameSettings())
    val gameSettings: StateFlow<GameSettings> = _gameSettings.asStateFlow()

    private val _players = MutableStateFlow<List<String>>(emptyList())
    val players: StateFlow<List<String>> = _players.asStateFlow()

    init {
        _players.value = gameSettings.value.players
    }

    fun savePlayers(players: List<String>) {
        _gameSettings.value.players = players
        _players.value = players
    }


    fun saveWolvesCount(wolvesCount: Int) {
        gameSettings.value.wolvesCount = wolvesCount
    }

    fun saveGameRoles(roles: List<WGRole>) {
        gameSettings.value.selectedRoles = roles
    }


}

