package org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

data class RoleCategories(
    val wolves: List<WGRole> = listOf(),
    val villagers: List<WGRole> = listOf(),
    val solos: List<WGRole> = listOf(),
    val notPlayed: List<WGRole> = listOf(),
)

data class RoleDeck(
    val roles: List<WGRoleModel>,
    val extraRoles: List<WGRoleModel>,
)