package org.frgrz.kmpgamemaster.features.wolfgame.models

import org.frgrz.kmpgamemaster.data.entities.WGRole
import org.frgrz.kmpgamemaster.data.mappers.PlaysWith
import org.frgrz.kmpgamemaster.data.mappers.WinsWith

data class WGRoleModel(
    val role: WGRole,
    val isSelected: Boolean,
    val isDefault: Boolean,
    val playsWith: PlaysWith,
    val winsWith: WinsWith
)