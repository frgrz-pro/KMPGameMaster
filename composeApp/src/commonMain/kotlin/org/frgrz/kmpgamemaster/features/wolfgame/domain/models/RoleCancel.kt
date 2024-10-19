package org.frgrz.kmpgamemaster.features.wolfgame.domain.models

//TODO add all wolves
enum class RoleCancel(val roles: List<WGRole>) {
    WOLVES(listOf()),
    SEERS(listOf()),
    POTIONS(
        listOf(
            WGRole.SORCERER,
            WGRole.DRUGGIST
        )
    ),
    GURUS(
        listOf(
            WGRole.GURU,
            WGRole.PIED_PIPER
        )
    ),
    NONE(listOf())
}