package org.frgrz.kmpgamemaster.features.wolfgame.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.frgrz.kmpgamemaster.core.toInt
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

class WGGameCache {

    private val configuration = MutableStateFlow(GameConfiguration())
    val gameConfiguration: StateFlow<GameConfiguration> = configuration.asStateFlow()

    private val _players = MutableStateFlow<List<String>>(emptyList())
    val players: StateFlow<List<String>> = _players.asStateFlow()

    init {
        _players.value = configuration.value.players
    }

    fun savePlayers(players: List<String>) {
        _players.value = configuration.value.players
        configuration.value.players = players
        configuration.value.playersCount = players.size
    }

    fun saveRolesConfiguration(roles: List<WGRole>, wolvesCount: Int) {
        configuration.value.wolvesCount = wolvesCount
        configuration.value.roles = roles
        configuration.value.soloCount = roles.any { it.isSolo() }.toInt()
        configuration.value.villagersCount = configuration.value.players.size - wolvesCount - configuration.value.soloCount
    }


}
