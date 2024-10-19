package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

class RoleFilterMapper : Mapper<WGRole, List<RoleFilter>> {
    override fun map(input: WGRole): List<RoleFilter>{
        val filters = mutableListOf<RoleFilter>()
        filters.add(RoleFilter.ALL)

        val wolves = listOf(
            WGRole.WOLF_FAN,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAD_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
            WGRole.WOLF_BERSERK,
            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.WILD_KID,
            WGRole.WOLF_FAN,
            WGRole.WHITE_WOLF
        )

        if (input in wolves) {
            filters.add(RoleFilter.WOLVES)
        }

        val classics = listOf(
            WGRole.LITTLE_GIRL,
            WGRole.HUNTER,
            WGRole.MAYOR,
            WGRole.CUPID,
            WGRole.PEASANT,
            WGRole.SEER,
            WGRole.SORCERER,
            WGRole.THIEF,
            WGRole.WOLF
        )

        if (input in classics) {
            filters.add(RoleFilter.CLASSIC)
        }

        val transforms = listOf(
            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.WILD_KID,
            WGRole.THIEF,
            WGRole.COMEDIAN,
            WGRole.WOLF_FAN,
        )

        if (input in transforms) {
            filters.add(RoleFilter.TRANSFORM)
        }

        val solos = listOf(
            WGRole.ANGEL,
            WGRole.BERSERK,
            WGRole.ASSASSIN,
            WGRole.CORRUPTER,
            WGRole.TRAITOR,
            WGRole.HITMAN,
            WGRole.PIED_PIPER,
            WGRole.CASSANDRA,
            WGRole.WHITE_WOLF
        )

        if (input in solos) {
            filters.add(RoleFilter.SOLO)
        }

        val teams = listOf(
            WGRole.TWO_SISTERS,
            WGRole.THREE_BROTHERS,
            WGRole.DUELISTS
        )

        if (input in teams) {
            filters.add(RoleFilter.TEAM)
        }

        val villagers = listOf(
            WGRole.ASTRONOMER,
            WGRole.BEAR_HANDLER,
            WGRole.BLACKSMITH,
            WGRole.BULLY,
            WGRole.COMEDIAN,
            WGRole.CUPID,
            WGRole.TWO_SISTERS,
            WGRole.THREE_BROTHERS,
            WGRole.GURU,
            WGRole.DUELISTS,
            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.WILD_KID,
            WGRole.THIEF,
            WGRole.COMEDIAN,
            WGRole.WOLF_FAN,
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
        )

        if (input in villagers) {
            filters.add(RoleFilter.VILLAGE)
        }

        return filters
    }
}