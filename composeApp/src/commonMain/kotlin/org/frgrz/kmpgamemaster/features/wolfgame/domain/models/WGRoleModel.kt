package org.frgrz.kmpgamemaster.features.wolfgame.domain.models

import org.jetbrains.compose.resources.StringResource

data class WGRoleModel(
    val role: WGRole,
    val name: StringResource,
    var isSelected: Boolean,
    val isDefault: Boolean,
    val playsWith: PlaysWith,
    val winsWith: WinsWith,
    val filters: List<RoleFilter>,
    val actions: List<WGRoleAction>
)

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

enum class RoleFilter {
    SELECTED,
    UNSELECTED,
    ALL,
    CLASSIC,
    WOLVES,
    VILLAGE,
    SOLO,
    TRANSFORM,
    TEAM,
}

enum class WGRole {
    ANGEL,
    ASSASSIN,
    ASTRONOMER,
    BEAR_HANDLER,
    BERSERK,
    BIG_BAD_WOLF,
    BLACK_WOLF,
    BLACKSMITH,
    BLUE_WOLF,
    BULLY,
    CASSANDRA,
    COMEDIAN,
    CORRUPTER,
    CUPID,
    DEFLECTOR,
    DEMONIAC_SOUL,
    DRUGGIST,
    DUELISTS,
    FOX,
    GENTLEMAN,
    GUARD,
    GURU,
    HITMAN, //TODO Rename Accusateurs
    HUNTER,
    IDIOT,
    LITTLE_GIRL,
    MARSHALL,
    MAYOR,
    MOON_SON,
    NOCTAMBUL, //TODO Rename SLEEP_WALKER
    OLD_KNIGHT,
    PEASANT,
    PIED_PIPER,
    PRIEST,
    PYROMANIAC, //TODO Rename resources Pyromaniac
    RANGER,
    SEER,
    SORCERER,
    THIEF,
    THREE_BROTHERS,
    TRAITOR,
    TWO_SISTERS,
    VILLAGE_ELDER,
    WHITE_SOOTHSAYER,
    WHITE_WOLF,
    WILD_KID,
    WIZARD,
    WOLF_BERSERK,
    WOLF_DOG,
    WOLF_FAN,
    WOLF_KITTEN,
    WOLF;

    companion object {
        val DEFAULT = PEASANT
    }
}
