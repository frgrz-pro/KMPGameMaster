package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.little_girl
import kmpgamemaster.composeapp.generated.resources.little_girl_action
import kmpgamemaster.composeapp.generated.resources.little_girl_action_desc
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.PlaysWith
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleAction
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionFrequency
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionType
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinsWith

object PreviewData {

    val rolaAction = WGRoleAction(
        Res.string.little_girl_action,
        Res.string.little_girl_action_desc,
        WGRoleActionType.SPY,
        WGRoleActionFrequency.EVERY_NIGHT
    )

    val roleModel = WGRoleModel(
        WGRole.LITTLE_GIRL,
        Res.string.little_girl,
        isSelected = true,
        isDefault = false,
        playsWith = PlaysWith.VILLAGE,
        winsWith = WinsWith.VILLAGE,
        filters = listOf(RoleFilter.VILLAGE),
        actions = listOf(
            WGRoleAction(
                Res.string.little_girl_action,
                Res.string.little_girl_action_desc,
                WGRoleActionType.SPY,
                WGRoleActionFrequency.EVERY_NIGHT
            )
        )
    )
}