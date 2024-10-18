package org.frgrz.kmpgamemaster.features.wolfgame.domain.models

data class RoleCategories(
    val wolves: List<WGRole> = listOf(),
    val villagers: List<WGRole> = listOf(),
    val solos: List<WGRole> = listOf(),
    val notPlayed: List<WGRole> = listOf(),
)