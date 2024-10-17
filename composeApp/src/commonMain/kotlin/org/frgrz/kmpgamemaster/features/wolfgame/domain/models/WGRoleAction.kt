package org.frgrz.kmpgamemaster.features.wolfgame.domain.models

import org.jetbrains.compose.resources.StringResource


data class WGRoleAction(
    val name: StringResource,
    val desc: StringResource,
    val type: WGRoleActionType,
    val frequency: WGRoleActionFrequency,
    val condition: WGRoleActionCondition = WGRoleActionCondition.NONE,
    val cancels: WGRoleActionCancel = WGRoleActionCancel.NONE,
)


enum class WGRoleActionType {
    SPY,
    KILL,
    INFECT,
    KILL_PROTECTOR,
    TRANSFORM,
    CANCEL_ABILITY,
    REVIVE,
    BOUND_FATE,
    VOTED,
    NONE,
    TEAM,
    DOUBLE_VOTE,
    VOTE_PROTECTION,
    VOTE_CANCEL,
    REDIRECT_ATTACK,
    REFILL_POTION
}


enum class WGRoleActionFrequency {
    EVERY_NIGHT,
    EVERY_TWO_NIGHTS,
    ONLY_ONCE_PER_GAME,
    WHEN_KILLED,
    WHEN_VOTED,
    WHEN_DESIGNATED_PLAYER_DIES,
    START_GAME,
    FIRST_NIGHT,
    TWICE_PER_GAME,
    UNTIL_FAIL
}


enum class WGRoleActionCondition {
    NONE,
    IF_NO_WOLF_DEAD,
    IF_FIRST_VOTE,
    IF_NOT_SUCCESSFUL_NIGHT_BEFORE
}


enum class WGRoleActionCancel {
    NONE,
    GURU,
    SEER,
    VOTE,
    WOLVES,
    VILLAGERS,
    POTIONS,
    ANY
}