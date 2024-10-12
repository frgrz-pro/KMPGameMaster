package org.frgrz.kmpgamemaster.data.mappers

import org.frgrz.kmpgamemaster.data.entities.WGRole
import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity
import org.frgrz.kmpgamemaster.features.wolfgame.models.PlaysWith
import org.frgrz.kmpgamemaster.features.wolfgame.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.models.WinsWith

class WGRoleModelMapper {

    fun map(entity: WGRoleEntity): WGRoleModel {
        return WGRoleModel(
            role = entity.role,
            isSelected = entity.selected,
            isDefault = entity.default,
            playsWith = mapPlaysWith(entity.role),
            winsWith = mapWinsWith(entity.role),
            filters = mapRoleFilters(entity.role)
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
            WGRole.GURU,
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

    private fun mapRoleFilters(role: WGRole): List<RoleFilter> {
        val filters = mutableListOf<RoleFilter>()
        filters.add(RoleFilter.ALL)

        val wolves = listOf(
            WGRole.WOLF_FAN,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAG_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
            WGRole.WOLF_BERSERK,
            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.WILD_KID,
            WGRole.WOLF_FAN,
        )

        if (role in wolves) {
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

        if (role in classics) {
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

        if (role in transforms) {
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
            WGRole.CASSANDRA
        )

        if (role in solos) {
            filters.add(RoleFilter.SOLO)
        }

        val teams = listOf(
            WGRole.TWO_SISTERS,
            WGRole.THREE_BROTHERS,
            WGRole.GURU,
            WGRole.DUELISTS
        )

        if (role in teams) {
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
        )

        if (role in villagers) {
            filters.add(RoleFilter.VILLAGE)
        }

        return filters
    }

}
