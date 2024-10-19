package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleCancel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

class RoleCancelMapper : Mapper<WGRole, RoleCancel> {
    override fun map(input: WGRole): RoleCancel {
        return when (input) {
            WGRole.ASSASSIN -> RoleCancel.WOLVES
            WGRole.BLUE_WOLF -> RoleCancel.SEERS
            WGRole.GENTLEMAN -> RoleCancel.POTIONS
            WGRole.WOLF_FAN -> RoleCancel.GURUS
            else -> RoleCancel.NONE
        }
    }
}