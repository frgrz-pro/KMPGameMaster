package org.frgrz.kmpgamemaster.features.wolfgame.models

import org.frgrz.kmpgamemaster.data.entities.WGRole

data class WGRoleModel(
    val role: WGRole,
    val isSelected: Boolean,
    val isDefault: Boolean,
    val playsWith: PlaysWith,
    val winsWith: WinsWith,
    val filters: List<RoleFilter>
)

enum class PlaysWith {
    WOLVES,
    VILLAGE,
    WOLVES_OR_VILLAGE,
    SOLO;
}

enum class WinsWith {
    WOLVES,
    VILLAGE,
    WOLVES_OR_VILLAGE,
    SOLO;
}

enum class RoleFilter {
    ALL,
    CLASSIC,
    WOLVES,
    VILLAGE,
    SOLO,
    TRANSFORM,
    TEAM,
}