package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import androidx.compose.ui.graphics.vector.ImageVector
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionType
import org.frgrz.kmpgamemaster.material.components.icons.Deck
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Kill
import org.frgrz.kmpgamemaster.material.components.icons.Spy
import org.frgrz.kmpgamemaster.material.components.icons.Team
import org.frgrz.kmpgamemaster.material.components.icons.Virus

class RoleActionIconMapper : Mapper<WGRoleActionType, ImageVector> {
    override fun map(input: WGRoleActionType): ImageVector {
        return when (input) {
            WGRoleActionType.SPY -> IconPack.Spy
            WGRoleActionType.KILL -> IconPack.Kill
            WGRoleActionType.INFECT -> IconPack.Virus
            WGRoleActionType.TEAM -> IconPack.Team
            else -> IconPack.Deck

            /* WGRoleActionType.KILL_PROTECTOR -> TODO()
             WGRoleActionType.TRANSFORM -> TODO()
             WGRoleActionType.CANCEL_ABILITY -> TODO()
             WGRoleActionType.REVIVE -> TODO()
             WGRoleActionType.BOUND_FATE -> TODO()
             WGRoleActionType.VOTED -> TODO()
             WGRoleActionType.NONE -> TODO()
             WGRoleActionType.DOUBLE_VOTE -> TODO()
             WGRoleActionType.VOTE_PROTECTION -> TODO()
             WGRoleActionType.VOTE_CANCEL -> TODO()
             WGRoleActionType.REDIRECT_ATTACK -> TODO()
             WGRoleActionType.REFILL_POTION -> TODO()*/
        }
    }
}
