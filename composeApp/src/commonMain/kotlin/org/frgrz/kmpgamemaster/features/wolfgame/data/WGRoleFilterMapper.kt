package org.frgrz.kmpgamemaster.features.wolfgame.data

import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter

class WGRoleFilterMapper {
    fun map(filter: RoleFilter): List<WGRoleDBEntity.WGRole> {
        return when (filter) {
            RoleFilter.SELECTED, RoleFilter.UNSELECTED -> listOf()
            RoleFilter.ALL -> WGRoleDBEntity.WGRole.entries
            RoleFilter.CLASSIC -> listOf(
                WGRoleDBEntity.WGRole.LITTLE_GIRL,
                WGRoleDBEntity.WGRole.HUNTER,
                WGRoleDBEntity.WGRole.MAYOR,
                WGRoleDBEntity.WGRole.CUPID,
                WGRoleDBEntity.WGRole.PEASANT,
                WGRoleDBEntity.WGRole.SEER,
                WGRoleDBEntity.WGRole.SORCERER,
                WGRoleDBEntity.WGRole.THIEF,
                WGRoleDBEntity.WGRole.WOLF
            )

            RoleFilter.WOLVES -> listOf(
                WGRoleDBEntity.WGRole.WOLF_FAN,
                WGRoleDBEntity.WGRole.WOLF_KITTEN,
                WGRoleDBEntity.WGRole.WOLF,
                WGRoleDBEntity.WGRole.BIG_BAG_WOLF,
                WGRoleDBEntity.WGRole.BLACK_WOLF,
                WGRoleDBEntity.WGRole.BLUE_WOLF,
                WGRoleDBEntity.WGRole.WOLF_BERSERK,
                WGRoleDBEntity.WGRole.WOLF_DOG,
                WGRoleDBEntity.WGRole.GENTLEMAN,
                WGRoleDBEntity.WGRole.WILD_KID,
                WGRoleDBEntity.WGRole.WOLF_FAN,
                WGRoleDBEntity.WGRole.WHITE_WOLF
            )

            RoleFilter.VILLAGE -> listOf(
                WGRoleDBEntity.WGRole.ASTRONOMER,
                WGRoleDBEntity.WGRole.BEAR_HANDLER,
                WGRoleDBEntity.WGRole.BLACKSMITH,
                WGRoleDBEntity.WGRole.BULLY,
                WGRoleDBEntity.WGRole.COMEDIAN,
                WGRoleDBEntity.WGRole.CUPID,
                WGRoleDBEntity.WGRole.TWO_SISTERS,
                WGRoleDBEntity.WGRole.THREE_BROTHERS,
                WGRoleDBEntity.WGRole.GURU,
                WGRoleDBEntity.WGRole.DUELISTS,
                WGRoleDBEntity.WGRole.WOLF_DOG,
                WGRoleDBEntity.WGRole.GENTLEMAN,
                WGRoleDBEntity.WGRole.WILD_KID,
                WGRoleDBEntity.WGRole.THIEF,
                WGRoleDBEntity.WGRole.COMEDIAN,
                WGRoleDBEntity.WGRole.WOLF_FAN,
                WGRoleDBEntity.WGRole.DEFLECTOR,
                WGRoleDBEntity.WGRole.DEMONIAC_SOUL,
                WGRoleDBEntity.WGRole.DRUGGIST,
                WGRoleDBEntity.WGRole.GURU,
                WGRoleDBEntity.WGRole.DUELISTS,
                WGRoleDBEntity.WGRole.FOX,
                WGRoleDBEntity.WGRole.GUARD,
                WGRoleDBEntity.WGRole.HUNTER,
                WGRoleDBEntity.WGRole.IDIOT,
                WGRoleDBEntity.WGRole.LITTLE_GIRL,
                WGRoleDBEntity.WGRole.MARSHALL,
                WGRoleDBEntity.WGRole.MOON_SON,
                WGRoleDBEntity.WGRole.NOCTAMBULIST,
                WGRoleDBEntity.WGRole.OLD_KNIGHT,
                WGRoleDBEntity.WGRole.PEASANT,
                WGRoleDBEntity.WGRole.PRIEST,
                WGRoleDBEntity.WGRole.PYROMANIAC,
                WGRoleDBEntity.WGRole.RANGER,
                WGRoleDBEntity.WGRole.SEER,
                WGRoleDBEntity.WGRole.SORCERER,
                WGRoleDBEntity.WGRole.THIEF,
                WGRoleDBEntity.WGRole.THREE_BROTHERS,
                WGRoleDBEntity.WGRole.TWO_SISTERS,
                WGRoleDBEntity.WGRole.VILLAGE_ELDER,
                WGRoleDBEntity.WGRole.WHITE_SOOTHSAYER,
                WGRoleDBEntity.WGRole.WIZARD,
                WGRoleDBEntity.WGRole.CASSANDRA,
            )

            RoleFilter.SOLO -> listOf(
                WGRoleDBEntity.WGRole.ANGEL,
                WGRoleDBEntity.WGRole.BERSERK,
                WGRoleDBEntity.WGRole.ASSASSIN,
                WGRoleDBEntity.WGRole.CORRUPTER,
                WGRoleDBEntity.WGRole.TRAITOR,
                WGRoleDBEntity.WGRole.HITMAN,
                WGRoleDBEntity.WGRole.PIED_PIPER,
                WGRoleDBEntity.WGRole.CASSANDRA,
                WGRoleDBEntity.WGRole.WHITE_WOLF
            )

            RoleFilter.TRANSFORM -> listOf(
                WGRoleDBEntity.WGRole.WOLF_DOG,
                WGRoleDBEntity.WGRole.GENTLEMAN,
                WGRoleDBEntity.WGRole.WILD_KID,
                WGRoleDBEntity.WGRole.THIEF,
                WGRoleDBEntity.WGRole.COMEDIAN,
                WGRoleDBEntity.WGRole.WOLF_FAN
            )

            RoleFilter.TEAM -> listOf(
                WGRoleDBEntity.WGRole.TWO_SISTERS,
                WGRoleDBEntity.WGRole.THREE_BROTHERS,
                WGRoleDBEntity.WGRole.GURU,
                WGRoleDBEntity.WGRole.DUELISTS
            )
        }
    }
}