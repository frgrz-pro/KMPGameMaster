package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.PlaysWith
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole


class PlaysWithMapper : Mapper<WGRole, PlaysWith> {
    override fun map(input: WGRole): PlaysWith {
        return when (input) {
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAD_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
            WGRole.WHITE_WOLF,
            WGRole.WOLF_BERSERK,
                -> PlaysWith.WOLVES

            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.MAYOR,
            WGRole.WILD_KID,
            WGRole.TRAITOR,
            WGRole.WOLF_FAN,
                -> PlaysWith.WOLVES_OR_VILLAGE

            WGRole.ASSASSIN,
            WGRole.BERSERK,
            WGRole.CORRUPTER,
            WGRole.HITMAN,
            WGRole.PIED_PIPER,
                -> PlaysWith.SOLO

            WGRole.ANGEL,
            WGRole.ASTRONOMER,
            WGRole.BEAR_HANDLER,
            WGRole.BLACKSMITH,
            WGRole.BULLY,
            WGRole.COMEDIAN,
            WGRole.CUPID,
            WGRole.DEFLECTOR,
            WGRole.DEMONIAC_SOUL,
            WGRole.DRUGGIST,
            WGRole.GURU,
            WGRole.DUELISTS,
            WGRole.FOX,
            WGRole.GUARD,
            WGRole.HUNTER,
            WGRole.IDIOT,
            WGRole.LITTLE_GIRL,
            WGRole.MARSHALL,
            WGRole.MOON_SON,
            WGRole.NOCTAMBUL,
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
}