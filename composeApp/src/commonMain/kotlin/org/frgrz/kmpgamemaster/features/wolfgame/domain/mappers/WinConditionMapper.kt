package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinCondition
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinConditionType
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinScore
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinsWith


class WinConditionMapper : Mapper<WGRole, List<WinCondition>> {

    override fun map(input: WGRole): List<WinCondition> {
        return when (input) {

            WGRole.ASTRONOMER,
            WGRole.BEAR_HANDLER,
            WGRole.BLACKSMITH,
            WGRole.BULLY,
            WGRole.DEMONIAC_SOUL,
            WGRole.CUPID,
            WGRole.DEFLECTOR,
            WGRole.DRUGGIST,
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
            WGRole.THREE_BROTHERS,
            WGRole.TWO_SISTERS,
            WGRole.THIEF,
            WGRole.VILLAGE_ELDER,
            WGRole.WHITE_SOOTHSAYER,
            WGRole.WIZARD,
            WGRole.COMEDIAN,
                -> listOf(
                WinCondition(
                    type = WinConditionType.CLASSIC_VILLAGE,
                    winsWith = WinsWith.VILLAGE,
                    points = WinScore.VILLAGE_WIN
                )
            )

            WGRole.WOLF_BERSERK,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAD_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
                -> listOf(
                WinCondition(
                    type = WinConditionType.CLASSIC_WOLF,
                    winsWith = WinsWith.WOLVES,
                    points = WinScore.WOLF_WIN
                )
            )


            WGRole.ANGEL -> listOf(
                WinCondition(
                    type = WinConditionType.WHEN_VOTED,
                    winsWith = WinsWith.SOLO,
                    points = WinScore.SOLO_WIN
                ),
                WinCondition(
                    type = WinConditionType.CLASSIC_VILLAGE,
                    winsWith = WinsWith.VILLAGE,
                    points = WinScore.VILLAGE_WIN
                )
            )

            WGRole.GURU,
            WGRole.PIED_PIPER,
                -> listOf(
                WinCondition(
                    type = WinConditionType.WHEN_EVERYONE_CONTAMINATED,
                    winsWith = WinsWith.SOLO,
                    points = WinScore.SOLO_WIN
                ),
                WinCondition(
                    type = WinConditionType.CLASSIC_VILLAGE,
                    winsWith = WinsWith.VILLAGE,
                    points = WinScore.VILLAGE_WIN
                )
            )

            WGRole.ASSASSIN,
            WGRole.WHITE_WOLF,
                -> listOf(
                WinCondition(
                    type = WinConditionType.CLASSIC_SOLO,
                    winsWith = WinsWith.SOLO,
                    points = WinScore.SOLO_WIN
                )
            )


            WGRole.GENTLEMAN,
            WGRole.WILD_KID,
            WGRole.WOLF_DOG,
            WGRole.WOLF_FAN,
            WGRole.TRAITOR ->
                listOf(
                    WinCondition(
                        type = WinConditionType.CLASSIC_VILLAGE,
                        winsWith = WinsWith.VILLAGE,
                        points = WinScore.VILLAGE_WIN
                    ),
                    WinCondition(
                        type = WinConditionType.CLASSIC_WOLF,
                        winsWith = WinsWith.WOLVES,
                        points = WinScore.WOLF_WIN
                    )
                )

            WGRole.DUELISTS ->
                listOf(
                    WinCondition(
                        type = WinConditionType.WITH_VILLAGE_IF_RIVAL_DEAD,
                        winsWith = WinsWith.VILLAGE,
                        points = WinScore.VILLAGE_WIN
                    )
                )

            else -> listOf(
                WinCondition(
                    type = WinConditionType.NONE,
                    winsWith = WinsWith.NONE,
                    points = WinScore.NONE
                )
            )
        }
    }
}