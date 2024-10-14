package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.angel_action
import kmpgamemaster.composeapp.generated.resources.angel_action_desc
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleAction
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionFrequency
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionType

object PreviewData {

    val sampleWGRoleAction = WGRoleAction(
        name = Res.string.angel_action,
        desc = Res.string.angel_action_desc,
        type = WGRoleActionType.SPY,
        frequency = WGRoleActionFrequency.START_GAME
    )
}