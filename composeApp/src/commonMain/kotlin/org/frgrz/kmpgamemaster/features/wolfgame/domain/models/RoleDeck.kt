package org.frgrz.kmpgamemaster.features.wolfgame.domain.models


data class RoleDeck(
    val roles: List<WGRoleModel> = listOf(),
    val extraRoles: List<WGRoleModel> = listOf(),
)