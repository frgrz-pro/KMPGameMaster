package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleAction
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionFrequency
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionType

object PreviewData {

    val sampleWGRoleAction = WGRoleAction(
        name = "Action Name",
        desc = "Action description of the role",
        type = WGRoleActionType.SPY,
        frequency = WGRoleActionFrequency.START_GAME
    )
}