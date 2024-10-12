package org.frgrz.kmpgamemaster.data.mappers

import org.frgrz.kmpgamemaster.data.entities.WGRole
import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel

class WGRoleModelMapper {
    fun map(entity: WGRoleEntity): WGRoleModel {
        return WGRoleModel(
            role = entity.role,
            isSelected = entity.selected,
            isDefault = entity.default,
            playsWith = mapPlaysWith(entity.role),
            winsWith = mapWinsWith(entity.role)
        )
    }

    private fun mapPlaysWith(role: WGRole): PlaysWith {
        return when (role) {
            WGRole.WOLF_FAN,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAG_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
            WGRole.WHITE_WOLF,
            WGRole.WOLF_BERSERK,
                -> PlaysWith.WOLVES

            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.MAYOR,
            WGRole.WILD_KID,
                -> PlaysWith.WOLVES_OR_VILLAGE

            WGRole.ANGEL,
            WGRole.ASSASSIN,
            WGRole.BERSERK,
            WGRole.CORRUPTER,
            WGRole.TRAITOR,
            WGRole.HITMAN,
            WGRole.PIED_PIPER,
            WGRole.GURU,
                -> PlaysWith.SOLO

            WGRole.ASTRONOMER,
            WGRole.BEAR_HANDLER,
            WGRole.BLACKSMITH,
            WGRole.BULLY,
            WGRole.COMEDIAN,
            WGRole.CUPID,
            WGRole.DEFLECTOR,
            WGRole.DEMONIAC_SOUL,
            WGRole.DRUGGIST,
            WGRole.DUELISTS,
            WGRole.FOX,
            WGRole.GUARD,
            WGRole.HUNTER,
            WGRole.IDIOT,
            WGRole.LITTLE_GIRL,
            WGRole.MARSHALL,
            WGRole.MOON_SON,
            WGRole.NOCTAMBULIST,
            WGRole.OLD_KNIGHT,
            WGRole.PEASANT,
            WGRole.PRIEST,
            WGRole.PYROMANIAC,
            WGRole.RANGER,
            WGRole.SEER,
            WGRole.SORCERER,
            WGRole.THIEF,
            WGRole.THREE_BROTHERS,
            WGRole.TWO_SISTERS,
            WGRole.VILLAGE_ELDER,
            WGRole.WHITE_SOOTHSAYER,
            WGRole.WIZARD,
            WGRole.CASSANDRA,
                -> PlaysWith.VILLAGE
        }
    }

    private fun mapWinsWith(role: WGRole): WinsWith {
        return when (role) {
            WGRole.WOLF_FAN,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAG_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
            WGRole.WOLF_BERSERK,
                -> WinsWith.WOLVES

            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.MAYOR,
            WGRole.WILD_KID,
                -> WinsWith.WOLVES_OR_VILLAGE

            WGRole.ANGEL,
            WGRole.ASSASSIN,
            WGRole.BERSERK,
            WGRole.CORRUPTER,
            WGRole.TRAITOR,
            WGRole.HITMAN,
            WGRole.PIED_PIPER,
            WGRole.GURU,
            WGRole.WHITE_WOLF,
                -> WinsWith.SOLO

            WGRole.ASTRONOMER,
            WGRole.BEAR_HANDLER,
            WGRole.BLACKSMITH,
            WGRole.BULLY,
            WGRole.COMEDIAN,
            WGRole.CUPID,
            WGRole.DEFLECTOR,
            WGRole.DEMONIAC_SOUL,
            WGRole.DRUGGIST,
            WGRole.DUELISTS,
            WGRole.FOX,
            WGRole.GUARD,
            WGRole.HUNTER,
            WGRole.IDIOT,
            WGRole.LITTLE_GIRL,
            WGRole.MARSHALL,
            WGRole.MOON_SON,
            WGRole.NOCTAMBULIST,
            WGRole.OLD_KNIGHT,
            WGRole.PEASANT,
            WGRole.PRIEST,
            WGRole.PYROMANIAC,
            WGRole.RANGER,
            WGRole.SEER,
            WGRole.SORCERER,
            WGRole.THIEF,
            WGRole.THREE_BROTHERS,
            WGRole.TWO_SISTERS,
            WGRole.VILLAGE_ELDER,
            WGRole.WHITE_SOOTHSAYER,
            WGRole.WIZARD,
            WGRole.CASSANDRA,
                -> WinsWith.VILLAGE
        }
    }


}

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
