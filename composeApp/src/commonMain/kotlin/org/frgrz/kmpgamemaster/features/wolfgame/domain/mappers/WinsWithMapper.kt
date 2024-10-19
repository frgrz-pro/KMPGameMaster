package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.empty
import kmpgamemaster.composeapp.generated.resources.wins_change
import kmpgamemaster.composeapp.generated.resources.wins_solo
import kmpgamemaster.composeapp.generated.resources.wins_with_village
import kmpgamemaster.composeapp.generated.resources.wins_with_wolves
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinsWith
import org.jetbrains.compose.resources.StringResource

class WinsWithMapper:Mapper<WinsWith, StringResource>{

    override fun map(input: WinsWith): StringResource {
        return when(input) {
            WinsWith.WOLVES -> Res.string.wins_with_wolves
            WinsWith.VILLAGE -> Res.string.wins_with_village
            WinsWith.WOLVES_OR_VILLAGE -> Res.string.wins_change
            WinsWith.SOLO -> Res.string.wins_solo
            WinsWith.NONE -> Res.string.empty
        }
    }

}