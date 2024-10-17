package org.frgrz.kmpgamemaster.features.wolfgame.domain.models


data class GameConfiguration(
    var players: List<String> = listOf(),
    var playersCount: Int = 0,
    var wolvesCount: Int = 0,
    var villagersCount: Int = 0,
    var soloCount: Int = 0,
    var roles: List<WGRole> = listOf(),
    var roleCategories: RoleCategories = RoleCategories()
)

data class RoleCategories(
    val wolves: List<WGRole> = listOf(),
    val villagers: List<WGRole> = listOf(),
    val solos: List<WGRole> = listOf(),
    val notPlayed: List<WGRole> = listOf(),
)