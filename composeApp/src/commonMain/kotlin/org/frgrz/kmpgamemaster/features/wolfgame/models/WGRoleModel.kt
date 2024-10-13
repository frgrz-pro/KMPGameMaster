package org.frgrz.kmpgamemaster.features.wolfgame.models

import org.frgrz.kmpgamemaster.data.entities.WGRole
import org.frgrz.kmpgamemaster.data.mappers.WGRoleAction
import org.jetbrains.compose.resources.StringResource

data class WGRoleModel(
    val role: WGRole,
    val name: StringResource,
    var isSelected: Boolean,
    val isDefault: Boolean,
    val playsWith: PlaysWith,
    val winsWith: WinsWith,
    val filters: List<RoleFilter>,
    val actions: List<WGRoleAction>
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
    SELECTED,
    UNSELECTED,
    ALL,
    CLASSIC,
    WOLVES,
    VILLAGE,
    SOLO,
    TRANSFORM,
    TEAM,
}


