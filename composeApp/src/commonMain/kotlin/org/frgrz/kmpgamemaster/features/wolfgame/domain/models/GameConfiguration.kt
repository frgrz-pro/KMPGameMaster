package org.frgrz.kmpgamemaster.features.wolfgame.domain.models


data class GameConfiguration(
    var players: List<String> = listOf(),
    var playersCount: Int = 0,
    var wolvesCount: Int = 0,
    var peasantCount: Int =0,
    var villagersCount: Int = 0,
    var soloCount: Int = 0,
    var roles: List<WGRole> = listOf(),
    var roleCategories: RoleCategories = RoleCategories()
)
