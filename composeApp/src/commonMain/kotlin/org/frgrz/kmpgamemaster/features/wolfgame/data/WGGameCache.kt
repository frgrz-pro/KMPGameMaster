package org.frgrz.kmpgamemaster.features.wolfgame.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

class WGGameCache {

    private val gameSettings = GameSettings()

    private val _players = MutableStateFlow<List<String>>(emptyList())
    val players: StateFlow<List<String>> = _players.asStateFlow()

    init {
        _players.value = gameSettings.players
    }

    fun savePlayers(players: List<String>) {
        gameSettings.players = players
        _players.value = players
    }


    fun saveWolvesCount(wolvesCount: Int) {
        gameSettings.wolvesCount = wolvesCount
    }

    fun saveGameRoles(roles: List<WGRole>) {
        gameSettings.selectedRoles = roles
    }

    fun getGameSettings(): GameSettings {
        return gameSettings
    }


}

data class GameSettings(
    var players: List<String> = listOf(),
    var wolvesCount: Int = 0,
    var selectedRoles: List<WGRole> = listOf(),
)