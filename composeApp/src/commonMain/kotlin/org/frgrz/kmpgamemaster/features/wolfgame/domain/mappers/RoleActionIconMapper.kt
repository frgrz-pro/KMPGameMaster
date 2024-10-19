package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers


import androidx.compose.ui.graphics.vector.ImageVector
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionType
import org.frgrz.kmpgamemaster.material.components.icons.CancelRole
import org.frgrz.kmpgamemaster.material.components.icons.ChangeSide
import org.frgrz.kmpgamemaster.material.components.icons.Double
import org.frgrz.kmpgamemaster.material.components.icons.Health
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Kill
import org.frgrz.kmpgamemaster.material.components.icons.Link
import org.frgrz.kmpgamemaster.material.components.icons.Moon
import org.frgrz.kmpgamemaster.material.components.icons.None
import org.frgrz.kmpgamemaster.material.components.icons.Radar
import org.frgrz.kmpgamemaster.material.components.icons.Reset
import org.frgrz.kmpgamemaster.material.components.icons.Shield
import org.frgrz.kmpgamemaster.material.components.icons.Spy
import org.frgrz.kmpgamemaster.material.components.icons.Team
import org.frgrz.kmpgamemaster.material.components.icons.Transform
import org.frgrz.kmpgamemaster.material.components.icons.Virus
import org.frgrz.kmpgamemaster.material.components.icons.Vote


class RoleActionIconMapper : Mapper<WGRoleActionType, ImageVector> {

    override fun map(input: WGRoleActionType): ImageVector {
        return when (input) {
            WGRoleActionType.SPY -> IconPack.Spy
            WGRoleActionType.KILL -> IconPack.Kill
            WGRoleActionType.CANCEL_WOLVES -> IconPack.Moon
            WGRoleActionType.DETECTION -> IconPack.Radar
            WGRoleActionType.CONVERT_GROUP,
            WGRoleActionType.INFECT,
                -> IconPack.Virus

            WGRoleActionType.REDIRECT_ATTACK,
            WGRoleActionType.PROTECT,
                -> IconPack.Shield

            WGRoleActionType.CANCEL_ABILITY,
            WGRoleActionType.CANCEL_VILLAGERS,
            WGRoleActionType.VOTE_CANCEL,
            WGRoleActionType.CANCEL_DAY_AND_NIGHT,
                -> IconPack.CancelRole

            WGRoleActionType.VOTED -> IconPack.Vote
            WGRoleActionType.TRANSFORM_WOLF -> IconPack.ChangeSide
            WGRoleActionType.CHANGE_ROLE -> IconPack.Transform
            WGRoleActionType.REVIVE -> IconPack.Health
            WGRoleActionType.BOUND_FATE -> IconPack.Link
            WGRoleActionType.NONE -> IconPack.None
            WGRoleActionType.TEAM -> IconPack.Team
            WGRoleActionType.DOUBLE_VOTE -> IconPack.Double
            WGRoleActionType.RESET_ABILITY -> IconPack.Reset
        }
    }
}
