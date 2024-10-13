package org.frgrz.kmpgamemaster.utils

import org.frgrz.kmpgamemaster.data.mappers.WGRoleAction
import org.frgrz.kmpgamemaster.data.mappers.WGRoleActionFrequency
import org.frgrz.kmpgamemaster.data.mappers.WGRoleActionType

object SampleData {

    val sampleWGRoleAction = WGRoleAction(
        name = "Action Name",
        desc = "Action description of the role",
        type = WGRoleActionType.SPY,
        frequency = WGRoleActionFrequency.START_GAME
    )
}