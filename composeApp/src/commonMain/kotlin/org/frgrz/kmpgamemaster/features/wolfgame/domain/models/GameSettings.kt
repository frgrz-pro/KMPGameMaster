package org.frgrz.kmpgamemaster.features.wolfgame.domain.models

//TODO Rename game configuration

data class GameSettings(
    var players: List<String> = listOf(),
    var wolvesCount: Int = 0,
    var selectedRoles: List<WGRole> = listOf(),
)