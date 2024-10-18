package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.plays_change
import kmpgamemaster.composeapp.generated.resources.plays_solo
import kmpgamemaster.composeapp.generated.resources.plays_with_village
import kmpgamemaster.composeapp.generated.resources.plays_with_wolves
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.PlaysWith
import org.jetbrains.compose.resources.StringResource

class PlaysWithMapper:Mapper<PlaysWith, StringResource>{

    override fun map(input: PlaysWith): StringResource {
        return when(input) {
            PlaysWith.WOLVES -> Res.string.plays_with_wolves
            PlaysWith.VILLAGE -> Res.string.plays_with_village
            PlaysWith.WOLVES_OR_VILLAGE -> Res.string.plays_change
            PlaysWith.SOLO -> Res.string.plays_solo
        }
    }
}