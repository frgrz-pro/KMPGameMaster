package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.angel
import kmpgamemaster.composeapp.generated.resources.assassin
import kmpgamemaster.composeapp.generated.resources.astronomer
import kmpgamemaster.composeapp.generated.resources.bear_handler
import kmpgamemaster.composeapp.generated.resources.berserk
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf
import kmpgamemaster.composeapp.generated.resources.black_wolf
import kmpgamemaster.composeapp.generated.resources.blacksmith
import kmpgamemaster.composeapp.generated.resources.blue_wolf
import kmpgamemaster.composeapp.generated.resources.bully
import kmpgamemaster.composeapp.generated.resources.cassandre
import kmpgamemaster.composeapp.generated.resources.comedian
import kmpgamemaster.composeapp.generated.resources.corrupter
import kmpgamemaster.composeapp.generated.resources.cupid
import kmpgamemaster.composeapp.generated.resources.deflector
import kmpgamemaster.composeapp.generated.resources.demoniac_soul
import kmpgamemaster.composeapp.generated.resources.druggist
import kmpgamemaster.composeapp.generated.resources.duelists
import kmpgamemaster.composeapp.generated.resources.fox
import kmpgamemaster.composeapp.generated.resources.gentleman
import kmpgamemaster.composeapp.generated.resources.guard
import kmpgamemaster.composeapp.generated.resources.guru
import kmpgamemaster.composeapp.generated.resources.hitman
import kmpgamemaster.composeapp.generated.resources.hunter
import kmpgamemaster.composeapp.generated.resources.idiot
import kmpgamemaster.composeapp.generated.resources.little_girl
import kmpgamemaster.composeapp.generated.resources.marshall
import kmpgamemaster.composeapp.generated.resources.mayor
import kmpgamemaster.composeapp.generated.resources.moon_son
import kmpgamemaster.composeapp.generated.resources.old_knight
import kmpgamemaster.composeapp.generated.resources.peasant
import kmpgamemaster.composeapp.generated.resources.pied_piper
import kmpgamemaster.composeapp.generated.resources.priest
import kmpgamemaster.composeapp.generated.resources.pyromaniac
import kmpgamemaster.composeapp.generated.resources.ranger
import kmpgamemaster.composeapp.generated.resources.seer
import kmpgamemaster.composeapp.generated.resources.sleep_walker
import kmpgamemaster.composeapp.generated.resources.sorcerer
import kmpgamemaster.composeapp.generated.resources.thief
import kmpgamemaster.composeapp.generated.resources.three_brothers
import kmpgamemaster.composeapp.generated.resources.traitor
import kmpgamemaster.composeapp.generated.resources.two_sisters
import kmpgamemaster.composeapp.generated.resources.village_elder
import kmpgamemaster.composeapp.generated.resources.white_soothsayer
import kmpgamemaster.composeapp.generated.resources.white_wolf
import kmpgamemaster.composeapp.generated.resources.wild_kid
import kmpgamemaster.composeapp.generated.resources.wizard
import kmpgamemaster.composeapp.generated.resources.wolf
import kmpgamemaster.composeapp.generated.resources.wolf_berserk
import kmpgamemaster.composeapp.generated.resources.wolf_dog
import kmpgamemaster.composeapp.generated.resources.wolf_fan
import kmpgamemaster.composeapp.generated.resources.wolf_kitten
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.jetbrains.compose.resources.StringResource

class RoleNameMapper : Mapper<WGRole, StringResource> {
    override fun map(input: WGRole): StringResource {
        return when (input) {
            WGRole.ANGEL -> Res.string.angel
            WGRole.ASSASSIN -> Res.string.assassin
            WGRole.ASTRONOMER -> Res.string.astronomer
            WGRole.BEAR_HANDLER -> Res.string.bear_handler
            WGRole.BERSERK -> Res.string.berserk
            WGRole.BIG_BAD_WOLF -> Res.string.big_bad_wolf
            WGRole.BLACK_WOLF -> Res.string.black_wolf
            WGRole.BLACKSMITH -> Res.string.blacksmith
            WGRole.BLUE_WOLF -> Res.string.blue_wolf
            WGRole.BULLY -> Res.string.bully
            WGRole.CASSANDRA -> Res.string.cassandre
            WGRole.COMEDIAN -> Res.string.comedian
            WGRole.CORRUPTER -> Res.string.corrupter
            WGRole.CUPID -> Res.string.cupid
            WGRole.DEFLECTOR -> Res.string.deflector
            WGRole.DEMONIAC_SOUL -> Res.string.demoniac_soul
            WGRole.DRUGGIST -> Res.string.druggist
            WGRole.DUELISTS -> Res.string.duelists
            WGRole.FOX -> Res.string.fox
            WGRole.GENTLEMAN -> Res.string.gentleman
            WGRole.GUARD -> Res.string.guard
            WGRole.GURU -> Res.string.guru
            WGRole.HITMAN -> Res.string.hitman
            WGRole.HUNTER -> Res.string.hunter
            WGRole.IDIOT -> Res.string.idiot
            WGRole.LITTLE_GIRL -> Res.string.little_girl
            WGRole.MARSHALL -> Res.string.marshall
            WGRole.MAYOR -> Res.string.mayor
            WGRole.MOON_SON -> Res.string.moon_son
            WGRole.NOCTAMBUL -> Res.string.sleep_walker
            WGRole.OLD_KNIGHT -> Res.string.old_knight
            WGRole.PEASANT -> Res.string.peasant
            WGRole.PIED_PIPER -> Res.string.pied_piper
            WGRole.PRIEST -> Res.string.priest
            WGRole.PYROMANIAC -> Res.string.pyromaniac
            WGRole.RANGER -> Res.string.ranger
            WGRole.SEER -> Res.string.seer
            WGRole.SORCERER -> Res.string.sorcerer
            WGRole.THIEF -> Res.string.thief
            WGRole.THREE_BROTHERS -> Res.string.three_brothers
            WGRole.TRAITOR -> Res.string.traitor
            WGRole.TWO_SISTERS -> Res.string.two_sisters
            WGRole.VILLAGE_ELDER -> Res.string.village_elder
            WGRole.WHITE_SOOTHSAYER -> Res.string.white_soothsayer
            WGRole.WHITE_WOLF -> Res.string.white_wolf
            WGRole.WILD_KID -> Res.string.wild_kid
            WGRole.WIZARD -> Res.string.wizard
            WGRole.WOLF_BERSERK -> Res.string.wolf_berserk
            WGRole.WOLF_DOG -> Res.string.wolf_dog
            WGRole.WOLF_FAN -> Res.string.wolf_fan
            WGRole.WOLF_KITTEN -> Res.string.wolf_kitten
            WGRole.WOLF -> Res.string.wolf
        }
    }
}
