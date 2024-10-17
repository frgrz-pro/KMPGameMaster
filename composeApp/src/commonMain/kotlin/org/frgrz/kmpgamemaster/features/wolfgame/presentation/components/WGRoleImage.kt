package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.angel_large
import kmpgamemaster.composeapp.generated.resources.angel_medium
import kmpgamemaster.composeapp.generated.resources.assassin_large
import kmpgamemaster.composeapp.generated.resources.assassin_medium
import kmpgamemaster.composeapp.generated.resources.astronomist_large
import kmpgamemaster.composeapp.generated.resources.astronomist_medium
import kmpgamemaster.composeapp.generated.resources.bear_handler_large
import kmpgamemaster.composeapp.generated.resources.bear_handler_medium
import kmpgamemaster.composeapp.generated.resources.berserk_large
import kmpgamemaster.composeapp.generated.resources.berserk_medium
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_large
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_medium
import kmpgamemaster.composeapp.generated.resources.black_wolf_large
import kmpgamemaster.composeapp.generated.resources.black_wolf_medium
import kmpgamemaster.composeapp.generated.resources.blacksmith_large
import kmpgamemaster.composeapp.generated.resources.blacksmith_medium
import kmpgamemaster.composeapp.generated.resources.blue_wolf_large
import kmpgamemaster.composeapp.generated.resources.blue_wolf_medium
import kmpgamemaster.composeapp.generated.resources.bully_large
import kmpgamemaster.composeapp.generated.resources.bully_medium
import kmpgamemaster.composeapp.generated.resources.cassandre_large
import kmpgamemaster.composeapp.generated.resources.cassandre_medium
import kmpgamemaster.composeapp.generated.resources.comedian_large
import kmpgamemaster.composeapp.generated.resources.comedian_medium
import kmpgamemaster.composeapp.generated.resources.corrupter_large
import kmpgamemaster.composeapp.generated.resources.corrupter_medium
import kmpgamemaster.composeapp.generated.resources.cupid_large
import kmpgamemaster.composeapp.generated.resources.cupid_medium
import kmpgamemaster.composeapp.generated.resources.deflecteur_large
import kmpgamemaster.composeapp.generated.resources.deflecteur_medium
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_large
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_medium
import kmpgamemaster.composeapp.generated.resources.druggist_large
import kmpgamemaster.composeapp.generated.resources.druggist_medium
import kmpgamemaster.composeapp.generated.resources.duelists_large
import kmpgamemaster.composeapp.generated.resources.duelists_medium
import kmpgamemaster.composeapp.generated.resources.fox_large
import kmpgamemaster.composeapp.generated.resources.fox_medium
import kmpgamemaster.composeapp.generated.resources.gentleman_large
import kmpgamemaster.composeapp.generated.resources.gentleman_medium
import kmpgamemaster.composeapp.generated.resources.guard_large
import kmpgamemaster.composeapp.generated.resources.guard_medium
import kmpgamemaster.composeapp.generated.resources.guru_large
import kmpgamemaster.composeapp.generated.resources.guru_medium
import kmpgamemaster.composeapp.generated.resources.hitman_large
import kmpgamemaster.composeapp.generated.resources.hitman_medium
import kmpgamemaster.composeapp.generated.resources.hunter_large
import kmpgamemaster.composeapp.generated.resources.hunter_medium
import kmpgamemaster.composeapp.generated.resources.idiot_large
import kmpgamemaster.composeapp.generated.resources.idiot_medium
import kmpgamemaster.composeapp.generated.resources.little_girl_large
import kmpgamemaster.composeapp.generated.resources.little_girl_medium
import kmpgamemaster.composeapp.generated.resources.marshall_large
import kmpgamemaster.composeapp.generated.resources.marshall_medium
import kmpgamemaster.composeapp.generated.resources.mayor_large
import kmpgamemaster.composeapp.generated.resources.mayor_medium
import kmpgamemaster.composeapp.generated.resources.moon_son_large
import kmpgamemaster.composeapp.generated.resources.moon_son_medium
import kmpgamemaster.composeapp.generated.resources.noctambulist_large
import kmpgamemaster.composeapp.generated.resources.noctambulist_medium
import kmpgamemaster.composeapp.generated.resources.old_knight_large
import kmpgamemaster.composeapp.generated.resources.old_knight_medium
import kmpgamemaster.composeapp.generated.resources.peasant_large
import kmpgamemaster.composeapp.generated.resources.peasant_medium
import kmpgamemaster.composeapp.generated.resources.pied_piper_large
import kmpgamemaster.composeapp.generated.resources.pied_piper_medium
import kmpgamemaster.composeapp.generated.resources.priest_large
import kmpgamemaster.composeapp.generated.resources.priest_medium
import kmpgamemaster.composeapp.generated.resources.pyroman_large
import kmpgamemaster.composeapp.generated.resources.pyroman_medium
import kmpgamemaster.composeapp.generated.resources.ranger_large
import kmpgamemaster.composeapp.generated.resources.ranger_medium
import kmpgamemaster.composeapp.generated.resources.seer_large
import kmpgamemaster.composeapp.generated.resources.seer_medium
import kmpgamemaster.composeapp.generated.resources.sorcerer_large
import kmpgamemaster.composeapp.generated.resources.sorcerer_medium
import kmpgamemaster.composeapp.generated.resources.thief_large
import kmpgamemaster.composeapp.generated.resources.thief_medium
import kmpgamemaster.composeapp.generated.resources.three_brothers_large
import kmpgamemaster.composeapp.generated.resources.three_brothers_medium
import kmpgamemaster.composeapp.generated.resources.traitor_large
import kmpgamemaster.composeapp.generated.resources.traitor_medium
import kmpgamemaster.composeapp.generated.resources.two_sisters_large
import kmpgamemaster.composeapp.generated.resources.two_sisters_medium
import kmpgamemaster.composeapp.generated.resources.village_elder_medium
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_large
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_medium
import kmpgamemaster.composeapp.generated.resources.white_wolf_large
import kmpgamemaster.composeapp.generated.resources.white_wolf_medium
import kmpgamemaster.composeapp.generated.resources.wild_kid_large
import kmpgamemaster.composeapp.generated.resources.wild_kid_medium
import kmpgamemaster.composeapp.generated.resources.wizard_large
import kmpgamemaster.composeapp.generated.resources.wizard_medium
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_large
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_medium
import kmpgamemaster.composeapp.generated.resources.wolf_dog_large
import kmpgamemaster.composeapp.generated.resources.wolf_dog_medium
import kmpgamemaster.composeapp.generated.resources.wolf_fan_large
import kmpgamemaster.composeapp.generated.resources.wolf_fan_medium
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_large
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_medium
import kmpgamemaster.composeapp.generated.resources.wolf_large
import kmpgamemaster.composeapp.generated.resources.wolf_medium
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.jetbrains.compose.resources.painterResource

@Composable
fun WGRoleImageMedium(role: WGRole, modifier: Modifier) {
    val drawableId = when (role) {
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
        WGRole.NOCTAMBUL -> Res.drawable.noctambulist_medium
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

    val imagePainter = painterResource(drawableId)

    Image(
        painter = imagePainter,
        contentDescription = "My Image", //TODO String resource
        modifier = modifier
    )
}

@Composable
fun WGRoleImageLarge(role: WGRole, modifier: Modifier) {
    val drawableId = when (role) {
        WGRole.LITTLE_GIRL -> Res.drawable.little_girl_large
        WGRole.HUNTER -> Res.drawable.hunter_large
        WGRole.MAYOR -> Res.drawable.mayor_large
        WGRole.PEASANT -> Res.drawable.peasant_large
        WGRole.CUPID -> Res.drawable.cupid_large
        WGRole.SEER -> Res.drawable.seer_large
        WGRole.WOLF -> Res.drawable.wolf_large
        WGRole.SORCERER -> Res.drawable.sorcerer_large
        WGRole.THIEF -> Res.drawable.thief_large
        WGRole.ANGEL -> Res.drawable.angel_large
        WGRole.ASSASSIN -> Res.drawable.hitman_large
        WGRole.ASTRONOMER -> Res.drawable.astronomist_large
        WGRole.BEAR_HANDLER -> Res.drawable.bear_handler_large
        WGRole.BERSERK -> Res.drawable.berserk_large
        WGRole.BIG_BAD_WOLF -> Res.drawable.big_bad_wolf_large
        WGRole.BLACK_WOLF -> Res.drawable.black_wolf_large
        WGRole.BLACKSMITH -> Res.drawable.blacksmith_large
        WGRole.BLUE_WOLF -> Res.drawable.blue_wolf_large
        WGRole.BULLY -> Res.drawable.bully_large
        WGRole.CASSANDRA -> Res.drawable.cassandre_large
        WGRole.COMEDIAN -> Res.drawable.comedian_large
        WGRole.CORRUPTER -> Res.drawable.corrupter_large
        WGRole.DEFLECTOR -> Res.drawable.deflecteur_large
        WGRole.DEMONIAC_SOUL -> Res.drawable.demoniac_soul_large
        WGRole.DRUGGIST -> Res.drawable.druggist_large
        WGRole.DUELISTS -> Res.drawable.duelists_large
        WGRole.FOX -> Res.drawable.fox_large
        WGRole.GENTLEMAN -> Res.drawable.gentleman_large
        WGRole.GUARD -> Res.drawable.guard_large
        WGRole.GURU -> Res.drawable.guru_large // Use illustration in Ankou
        WGRole.HITMAN -> Res.drawable.hitman_large
        WGRole.IDIOT -> Res.drawable.idiot_large
        WGRole.MARSHALL -> Res.drawable.marshall_large
        WGRole.MOON_SON -> Res.drawable.moon_son_large
        WGRole.NOCTAMBUL -> Res.drawable.noctambulist_large
        WGRole.OLD_KNIGHT -> Res.drawable.old_knight_large
        WGRole.PIED_PIPER -> Res.drawable.pied_piper_large
        WGRole.PRIEST -> Res.drawable.priest_large
        WGRole.PYROMANIAC -> Res.drawable.pyroman_large
        WGRole.RANGER -> Res.drawable.ranger_large
        WGRole.THREE_BROTHERS -> Res.drawable.three_brothers_large
        WGRole.TRAITOR -> Res.drawable.traitor_large
        WGRole.TWO_SISTERS -> Res.drawable.two_sisters_large
        WGRole.VILLAGE_ELDER -> Res.drawable.village_elder_medium //TODO Large asset resource
        WGRole.WHITE_SOOTHSAYER -> Res.drawable.white_soothsayer_large
        WGRole.WHITE_WOLF -> Res.drawable.white_wolf_large
        WGRole.WILD_KID -> Res.drawable.wild_kid_large
        WGRole.WIZARD -> Res.drawable.wizard_large
        WGRole.WOLF_BERSERK -> Res.drawable.wolf_berserk_large
        WGRole.WOLF_DOG -> Res.drawable.wolf_dog_large
        WGRole.WOLF_FAN -> Res.drawable.wolf_fan_large
        WGRole.WOLF_KITTEN -> Res.drawable.wolf_kitten_large
    }

    val imagePainter = painterResource(drawableId)

    Image(
        painter = imagePainter,
        contentDescription = "My Image", //TODO String resource
        modifier = modifier
    )
}
