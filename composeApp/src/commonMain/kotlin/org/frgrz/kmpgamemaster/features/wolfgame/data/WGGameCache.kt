package org.frgrz.kmpgamemaster.features.wolfgame.data

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

class WGGameCache {

    private val gameSettings = GameSettings()

    val players: List<String>
        get() = gameSettings.players

    val wolvesCount: Int
        get() = gameSettings.wolvesCount

    val selectedRoles: List<WGRole>
        get() = gameSettings.selectedRoles

    fun savePlayers(players: List<String>) {
        gameSettings.players = players
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

    fun test()

}

data class GameSettings(
    var players: List<String> = listOf(),
    var wolvesCount: Int = 0,
    var selectedRoles: List<WGRole> = listOf(),
)