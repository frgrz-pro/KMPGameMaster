package org.frgrz.kmpgamemaster.features.wolfgame.domain.models

import org.jetbrains.compose.resources.StringResource

data class WGRoleModel(
    val role: WGRole,
    val name: StringResource,
    var isSelected: Boolean,
    val isDefault: Boolean,
    val playsWith: PlaysWith,
    val winConditions: List<WinCondition>,
    val cancels: RoleCancel,
    val filters: List<RoleFilter>,
    val actions: List<WGRoleAction>,
)


data class WinCondition(
    val type: WinConditionType,
    val winsWith: WinsWith,
    val points: WinScore,
)


enum class WinConditionType {
    CLASSIC_WOLF,
    CLASSIC_VILLAGE,
    CLASSIC_SOLO,
    WHEN_VOTED,
    WHEN_EVERYONE_CONTAMINATED,
    WITH_VILLAGE_IF_RIVAL_DEAD,
    NONE,
}

enum class WinScore(val points: Int) {
    SOLO_WIN(5),
    WOLF_WIN(4),
    VILLAGE_WIN(3),
    NONE(0)
}

enum class WinsWith {
    WOLVES,
    VILLAGE,
    WOLVES_OR_VILLAGE,
    SOLO,
    NONE;
}


enum class PlaysWith {
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

    fun isWolf(): Boolean {
        return this in listOf(
            BIG_BAD_WOLF,
            BLACK_WOLF,
            BLUE_WOLF,
            WHITE_WOLF,
            WOLF_BERSERK,
            WOLF_KITTEN,
            WOLF
        )
    }

    fun isWolfAndAddsWolf(): Boolean {
        return this in listOf(
            BLACK_WOLF,
            WOLF_KITTEN,
        )
    }

    fun isVillager(): Boolean {
        return this in listOf(
            ASTRONOMER,
            BEAR_HANDLER,
            BERSERK,
            BLACKSMITH,
            BULLY,
            COMEDIAN,
            CUPID,
            DEFLECTOR,
            DEMONIAC_SOUL,
            DRUGGIST,
            DUELISTS,
            FOX,
            GENTLEMAN,
            GUARD,
            HUNTER,
            IDIOT,
            LITTLE_GIRL,
            MARSHALL,
            MOON_SON,
            NOCTAMBUL,
            OLD_KNIGHT,
            PEASANT,
            PRIEST,
            PYROMANIAC,
            RANGER,
            SEER,
            SORCERER,
            THIEF,
            THREE_BROTHERS,
            TWO_SISTERS,
            VILLAGE_ELDER,
            WHITE_SOOTHSAYER,
            WIZARD,
        )
    }

    fun isVillagerAndAddsWolf(): Boolean {
        return this in listOf(
            WOLF_DOG,
            WOLF_FAN,
            WILD_KID,
            GENTLEMAN,
            TRAITOR
        )
    }

    fun allWolves(): List<WGRole> = listOf(
        BIG_BAD_WOLF,
        BLACK_WOLF,
        BLUE_WOLF,
        WHITE_WOLF,
        WOLF_BERSERK,
        WOLF_KITTEN,
        WOLF,
        WOLF_DOG,
        WOLF_FAN,
        WILD_KID,
        GENTLEMAN,
        TRAITOR
    )

    fun isSolo(): Boolean {
        return this in listOf(
            ANGEL,
            ASSASSIN,
            BERSERK,
            CASSANDRA, //?
            CORRUPTER,
            GURU,
            HITMAN,
            PIED_PIPER
        )
    }

    fun isDuo(): Boolean {
        return this in listOf(
            TWO_SISTERS,
            DUELISTS
        )
    }

    fun isTrio(): Boolean {
        return this in listOf(
            THREE_BROTHERS
        )
    }

    fun isTeam(): Boolean {
        return this in listOf(
            TWO_SISTERS,
            DUELISTS,
            THREE_BROTHERS
        )
    }


    fun isExtraRole(): Boolean {
        return this in listOf(
            THIEF,
            COMEDIAN
        )
    }

}
