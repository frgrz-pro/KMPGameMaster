package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.angel_medium
import kmpgamemaster.composeapp.generated.resources.astronomist_medium
import kmpgamemaster.composeapp.generated.resources.bear_handler_medium
import kmpgamemaster.composeapp.generated.resources.berserk_medium
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_medium
import kmpgamemaster.composeapp.generated.resources.black_wolf_medium
import kmpgamemaster.composeapp.generated.resources.blacksmith_medium
import kmpgamemaster.composeapp.generated.resources.blue_wolf_medium
import kmpgamemaster.composeapp.generated.resources.bully_medium
import kmpgamemaster.composeapp.generated.resources.cassandre_medium
import kmpgamemaster.composeapp.generated.resources.comedian_medium
import kmpgamemaster.composeapp.generated.resources.corrupter_medium
import kmpgamemaster.composeapp.generated.resources.cupid_medium
import kmpgamemaster.composeapp.generated.resources.deflecteur_medium
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_medium
import kmpgamemaster.composeapp.generated.resources.druggist_medium
import kmpgamemaster.composeapp.generated.resources.duelists_medium
import kmpgamemaster.composeapp.generated.resources.fox_medium
import kmpgamemaster.composeapp.generated.resources.gentleman_medium
import kmpgamemaster.composeapp.generated.resources.guard_medium
import kmpgamemaster.composeapp.generated.resources.guru_medium
import kmpgamemaster.composeapp.generated.resources.hitman_medium
import kmpgamemaster.composeapp.generated.resources.hunter_medium
import kmpgamemaster.composeapp.generated.resources.idiot_medium
import kmpgamemaster.composeapp.generated.resources.little_girl_medium
import kmpgamemaster.composeapp.generated.resources.marshall_medium
import kmpgamemaster.composeapp.generated.resources.mayor_medium
import kmpgamemaster.composeapp.generated.resources.moon_son_medium
import kmpgamemaster.composeapp.generated.resources.noctambule_medium
import kmpgamemaster.composeapp.generated.resources.old_knight_medium
import kmpgamemaster.composeapp.generated.resources.peasant_medium
import kmpgamemaster.composeapp.generated.resources.pied_piper_medium
import kmpgamemaster.composeapp.generated.resources.priest_medium
import kmpgamemaster.composeapp.generated.resources.pyroman_medium
import kmpgamemaster.composeapp.generated.resources.ranger_medium
import kmpgamemaster.composeapp.generated.resources.seer_medium
import kmpgamemaster.composeapp.generated.resources.sorcerer_medium
import kmpgamemaster.composeapp.generated.resources.thief_medium
import kmpgamemaster.composeapp.generated.resources.three_brothers_medium
import kmpgamemaster.composeapp.generated.resources.traitor_medium
import kmpgamemaster.composeapp.generated.resources.two_sisters_medium
import kmpgamemaster.composeapp.generated.resources.village_elder_medium
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_medium
import kmpgamemaster.composeapp.generated.resources.white_wolf_medium
import kmpgamemaster.composeapp.generated.resources.wild_kid_medium
import kmpgamemaster.composeapp.generated.resources.wizard_medium
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_medium
import kmpgamemaster.composeapp.generated.resources.wolf_dog_medium
import kmpgamemaster.composeapp.generated.resources.wolf_fan_medium
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_medium
import kmpgamemaster.composeapp.generated.resources.wolf_medium
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.jetbrains.compose.resources.DrawableResource


class RoleDrawableMediumMapper: Mapper<WGRole, DrawableResource> {

    override fun map(input: WGRole): DrawableResource {
        return when (input) {
            WGRole.LITTLE_GIRL -> Res.drawable.little_girl_medium
            WGRole.HUNTER -> Res.drawable.hunter_medium
            WGRole.MAYOR -> Res.drawable.mayor_medium
            WGRole.PEASANT -> Res.drawable.peasant_medium
            WGRole.CUPID -> Res.drawable.cupid_medium
            WGRole.SEER -> Res.drawable.seer_medium
            WGRole.WOLF -> Res.drawable.wolf_medium
            WGRole.SORCERER -> Res.drawable.sorcerer_medium
            WGRole.THIEF -> Res.drawable.thief_medium
            WGRole.ANGEL -> Res.drawable.angel_medium
            WGRole.ASSASSIN -> Res.drawable.hitman_medium
            WGRole.ASTRONOMER -> Res.drawable.astronomist_medium
            WGRole.BEAR_HANDLER -> Res.drawable.bear_handler_medium
            WGRole.BERSERK -> Res.drawable.berserk_medium
            WGRole.BIG_BAD_WOLF -> Res.drawable.big_bad_wolf_medium
            WGRole.BLACK_WOLF -> Res.drawable.black_wolf_medium
            WGRole.BLACKSMITH -> Res.drawable.blacksmith_medium
            WGRole.BLUE_WOLF -> Res.drawable.blue_wolf_medium
            WGRole.BULLY -> Res.drawable.bully_medium
            WGRole.CASSANDRA -> Res.drawable.cassandre_medium
            WGRole.COMEDIAN -> Res.drawable.comedian_medium
            WGRole.CORRUPTER -> Res.drawable.corrupter_medium
            WGRole.DEFLECTOR -> Res.drawable.deflecteur_medium
            WGRole.DEMONIAC_SOUL -> Res.drawable.demoniac_soul_medium
            WGRole.DRUGGIST -> Res.drawable.druggist_medium
            WGRole.DUELISTS -> Res.drawable.duelists_medium
            WGRole.FOX -> Res.drawable.fox_medium
            WGRole.GENTLEMAN -> Res.drawable.gentleman_medium
            WGRole.GUARD -> Res.drawable.guard_medium
            WGRole.GURU -> Res.drawable.guru_medium
            WGRole.HITMAN -> Res.drawable.hitman_medium
            WGRole.IDIOT -> Res.drawable.idiot_medium
            WGRole.MARSHALL -> Res.drawable.marshall_medium
            WGRole.MOON_SON -> Res.drawable.moon_son_medium
            WGRole.NOCTAMBUL -> Res.drawable.noctambule_medium
            WGRole.OLD_KNIGHT -> Res.drawable.old_knight_medium
            WGRole.PIED_PIPER -> Res.drawable.pied_piper_medium
            WGRole.PRIEST -> Res.drawable.priest_medium
            WGRole.PYROMANIAC -> Res.drawable.pyroman_medium
            WGRole.RANGER -> Res.drawable.ranger_medium
            WGRole.THREE_BROTHERS -> Res.drawable.three_brothers_medium
            WGRole.TRAITOR -> Res.drawable.traitor_medium
            WGRole.TWO_SISTERS -> Res.drawable.two_sisters_medium
            WGRole.VILLAGE_ELDER -> Res.drawable.village_elder_medium
            WGRole.WHITE_SOOTHSAYER -> Res.drawable.white_soothsayer_medium
            WGRole.WHITE_WOLF -> Res.drawable.white_wolf_medium
            WGRole.WILD_KID -> Res.drawable.wild_kid_medium
            WGRole.WIZARD -> Res.drawable.wizard_medium
            WGRole.WOLF_BERSERK -> Res.drawable.wolf_berserk_medium
            WGRole.WOLF_DOG -> Res.drawable.wolf_dog_medium
            WGRole.WOLF_FAN -> Res.drawable.wolf_fan_medium
            WGRole.WOLF_KITTEN -> Res.drawable.wolf_kitten_medium
        }
    }

}
