package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.angel_action
import kmpgamemaster.composeapp.generated.resources.angel_action_desc
import kmpgamemaster.composeapp.generated.resources.assassin_action
import kmpgamemaster.composeapp.generated.resources.assassin_action_desc
import kmpgamemaster.composeapp.generated.resources.astronomer_action
import kmpgamemaster.composeapp.generated.resources.astronomer_action_2
import kmpgamemaster.composeapp.generated.resources.astronomer_action_2_desc
import kmpgamemaster.composeapp.generated.resources.astronomer_action_desc
import kmpgamemaster.composeapp.generated.resources.bear_handler_action
import kmpgamemaster.composeapp.generated.resources.bear_handler_action_desc
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_action
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.black_wolf_action
import kmpgamemaster.composeapp.generated.resources.black_wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.blacksmith_action
import kmpgamemaster.composeapp.generated.resources.blacksmith_action_2
import kmpgamemaster.composeapp.generated.resources.blacksmith_action_2_desc
import kmpgamemaster.composeapp.generated.resources.blacksmith_action_desc
import kmpgamemaster.composeapp.generated.resources.blue_wolf_action
import kmpgamemaster.composeapp.generated.resources.blue_wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.bully_action
import kmpgamemaster.composeapp.generated.resources.bully_action_2
import kmpgamemaster.composeapp.generated.resources.bully_action_2_desc
import kmpgamemaster.composeapp.generated.resources.bully_action_desc
import kmpgamemaster.composeapp.generated.resources.comedian_action
import kmpgamemaster.composeapp.generated.resources.comedian_action_desc
import kmpgamemaster.composeapp.generated.resources.cupid_action
import kmpgamemaster.composeapp.generated.resources.cupid_action_desc
import kmpgamemaster.composeapp.generated.resources.deflector_action
import kmpgamemaster.composeapp.generated.resources.deflector_action_desc
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_action
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_action_desc
import kmpgamemaster.composeapp.generated.resources.druggist_action
import kmpgamemaster.composeapp.generated.resources.druggist_action_2
import kmpgamemaster.composeapp.generated.resources.druggist_action_2_desc
import kmpgamemaster.composeapp.generated.resources.druggist_action_3
import kmpgamemaster.composeapp.generated.resources.druggist_action_3_desc
import kmpgamemaster.composeapp.generated.resources.druggist_action_desc
import kmpgamemaster.composeapp.generated.resources.duelists_action
import kmpgamemaster.composeapp.generated.resources.duelists_action_desc
import kmpgamemaster.composeapp.generated.resources.fox_action
import kmpgamemaster.composeapp.generated.resources.fox_action_desc
import kmpgamemaster.composeapp.generated.resources.gentleman_action
import kmpgamemaster.composeapp.generated.resources.gentleman_action_2
import kmpgamemaster.composeapp.generated.resources.gentleman_action_2_desc
import kmpgamemaster.composeapp.generated.resources.gentleman_action_desc
import kmpgamemaster.composeapp.generated.resources.guard_action
import kmpgamemaster.composeapp.generated.resources.guard_action_2
import kmpgamemaster.composeapp.generated.resources.guard_action_2_desc
import kmpgamemaster.composeapp.generated.resources.guard_action_desc
import kmpgamemaster.composeapp.generated.resources.guru_action
import kmpgamemaster.composeapp.generated.resources.guru_action_desc
import kmpgamemaster.composeapp.generated.resources.hunter_action
import kmpgamemaster.composeapp.generated.resources.hunter_action_desc
import kmpgamemaster.composeapp.generated.resources.idiot_action
import kmpgamemaster.composeapp.generated.resources.idiot_action_desc
import kmpgamemaster.composeapp.generated.resources.little_girl_action
import kmpgamemaster.composeapp.generated.resources.little_girl_action_desc
import kmpgamemaster.composeapp.generated.resources.marshall_action
import kmpgamemaster.composeapp.generated.resources.marshall_action_desc
import kmpgamemaster.composeapp.generated.resources.moon_son_action
import kmpgamemaster.composeapp.generated.resources.moon_son_action_desc
import kmpgamemaster.composeapp.generated.resources.old_knight_action
import kmpgamemaster.composeapp.generated.resources.old_knight_action_desc
import kmpgamemaster.composeapp.generated.resources.peasant_action
import kmpgamemaster.composeapp.generated.resources.peasant_action_desc
import kmpgamemaster.composeapp.generated.resources.pied_piper_action
import kmpgamemaster.composeapp.generated.resources.pied_piper_action_desc
import kmpgamemaster.composeapp.generated.resources.priest_action
import kmpgamemaster.composeapp.generated.resources.priest_action_desc
import kmpgamemaster.composeapp.generated.resources.pyramoniac_action
import kmpgamemaster.composeapp.generated.resources.pyramoniac_action_desc
import kmpgamemaster.composeapp.generated.resources.ranger_action
import kmpgamemaster.composeapp.generated.resources.ranger_action_desc
import kmpgamemaster.composeapp.generated.resources.seer_action
import kmpgamemaster.composeapp.generated.resources.seer_action_desc
import kmpgamemaster.composeapp.generated.resources.sleep_walker_action
import kmpgamemaster.composeapp.generated.resources.sleep_walker_action_desc
import kmpgamemaster.composeapp.generated.resources.sorcerer_action
import kmpgamemaster.composeapp.generated.resources.sorcerer_action_2
import kmpgamemaster.composeapp.generated.resources.sorcerer_action_2_desc
import kmpgamemaster.composeapp.generated.resources.sorcerer_action_desc
import kmpgamemaster.composeapp.generated.resources.thief_action
import kmpgamemaster.composeapp.generated.resources.thief_action_desc
import kmpgamemaster.composeapp.generated.resources.three_brothers_action
import kmpgamemaster.composeapp.generated.resources.three_brothers_action_desc
import kmpgamemaster.composeapp.generated.resources.traitor_action
import kmpgamemaster.composeapp.generated.resources.traitor_action_desc
import kmpgamemaster.composeapp.generated.resources.two_sisters_action
import kmpgamemaster.composeapp.generated.resources.two_sisters_action_desc
import kmpgamemaster.composeapp.generated.resources.village_elder_action
import kmpgamemaster.composeapp.generated.resources.village_elder_action_2
import kmpgamemaster.composeapp.generated.resources.village_elder_action_2_desc
import kmpgamemaster.composeapp.generated.resources.village_elder_action_desc
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_action
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_action_desc
import kmpgamemaster.composeapp.generated.resources.white_wolf_action
import kmpgamemaster.composeapp.generated.resources.white_wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.wild_kid_action
import kmpgamemaster.composeapp.generated.resources.wild_kid_action_2
import kmpgamemaster.composeapp.generated.resources.wild_kid_action_2_desc
import kmpgamemaster.composeapp.generated.resources.wild_kid_action_desc
import kmpgamemaster.composeapp.generated.resources.wizard_action
import kmpgamemaster.composeapp.generated.resources.wizard_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_action
import kmpgamemaster.composeapp.generated.resources.wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_action
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_dog_action
import kmpgamemaster.composeapp.generated.resources.wolf_dog_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_fan_action
import kmpgamemaster.composeapp.generated.resources.wolf_fan_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_action
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_action_desc
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleAction
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionCondition
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionFrequency
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionType


class RoleActionMapper : Mapper<WGRole, List<WGRoleAction>> {

    override fun map(input: WGRole): List<WGRoleAction> {
        val actions = mutableListOf<WGRoleAction>()

        when (input) {

            // AMNESIC

            WGRole.ANGEL -> {
                actions.add(
                    WGRoleAction(
                        Res.string.angel_action,
                        Res.string.angel_action_desc,
                        WGRoleActionType.VOTED,
                        WGRoleActionFrequency.WHEN_VOTED
                    )
                )
            }

            // ANKOU

            WGRole.ASSASSIN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.assassin_action,
                        Res.string.assassin_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.ASTRONOMER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.astronomer_action,
                        Res.string.astronomer_action_desc,
                        WGRoleActionType.CANCEL_WOLVES,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.astronomer_action_2,
                        Res.string.astronomer_action_2_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            // BAKER
            // BARMAN

            WGRole.BEAR_HANDLER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.bear_handler_action,
                        Res.string.bear_handler_action_desc,
                        WGRoleActionType.DETECTION,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            // BERSERK

            WGRole.BIG_BAD_WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_action,
                        Res.string.wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.big_bad_wolf_action,
                        Res.string.big_bad_wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        WGRoleActionCondition.IF_NO_WOLF_DEAD
                    )
                )
            }

            WGRole.BLACK_WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_action,
                        Res.string.wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.black_wolf_action,
                        Res.string.black_wolf_action_desc,
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.BLACKSMITH -> {
                actions.add(
                    WGRoleAction(
                        Res.string.blacksmith_action,
                        Res.string.blacksmith_action_desc,
                        WGRoleActionType.PROTECT,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS,
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.blacksmith_action_2,
                        Res.string.blacksmith_action_2_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS,
                    )
                )
            }

            // Blessed Villager
            // Bloody Mary

            WGRole.BLUE_WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_action,
                        Res.string.wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.blue_wolf_action,
                        Res.string.blue_wolf_action_desc,
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.BULLY -> {
                actions.add(
                    WGRoleAction(
                        Res.string.bully_action,
                        Res.string.bully_action_desc,
                        WGRoleActionType.CANCEL_DAY_AND_NIGHT,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.bully_action_2,
                        Res.string.bully_action_2_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.TWICE_PER_GAME,
                    )
                )
            }

            //Cassandra
            //Chupacabra
            //Clone

            WGRole.COMEDIAN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.comedian_action,
                        Res.string.comedian_action_desc,
                        WGRoleActionType.CHANGE_ROLE,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            // Confused Wolf
            // Corrupter
            // Crow

            WGRole.CUPID -> {
                actions.add(
                    WGRoleAction(
                        Res.string.cupid_action,
                        Res.string.cupid_action_desc,
                        WGRoleActionType.BOUND_FATE,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            WGRole.DEFLECTOR -> {
                actions.add(
                    WGRoleAction(
                        Res.string.deflector_action,
                        Res.string.deflector_action_desc,
                        WGRoleActionType.REDIRECT_ATTACK,
                        WGRoleActionFrequency.TWICE_PER_GAME,
                        WGRoleActionCondition.IF_NOT_SUCCESSFUL_NIGHT_BEFORE
                    )
                )
            }

            WGRole.DEMONIAC_SOUL -> {
                actions.add(
                    WGRoleAction(
                        Res.string.demoniac_soul_action,
                        Res.string.demoniac_soul_action_desc,
                        WGRoleActionType.CHANGE_ROLE,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.DRUGGIST -> {
                actions.add(
                    WGRoleAction(
                        Res.string.druggist_action,
                        Res.string.druggist_action_desc,
                        WGRoleActionType.VOTE_CANCEL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.druggist_action_2,
                        Res.string.druggist_action_2_desc,
                        WGRoleActionType.DOUBLE_VOTE,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.druggist_action_3,
                        Res.string.druggist_action_3_desc,
                        WGRoleActionType.RESET_ABILITY,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.DUELISTS -> {
                actions.add(
                    WGRoleAction(
                        Res.string.duelists_action,
                        Res.string.duelists_action_desc,
                        WGRoleActionType.BOUND_FATE,
                        WGRoleActionFrequency.START_GAME,
                    )
                )
            }

            WGRole.FOX -> {
                actions.add(
                    WGRoleAction(
                        Res.string.fox_action,
                        Res.string.fox_action_desc,
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.UNTIL_FAIL,
                    )
                )
            }

            WGRole.GENTLEMAN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.gentleman_action,
                        Res.string.gentleman_action_desc,
                        WGRoleActionType.TRANSFORM_WOLF,
                        WGRoleActionFrequency.START_GAME,
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.gentleman_action_2,
                        Res.string.gentleman_action_2_desc,
                        WGRoleActionType.VOTE_CANCEL,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.GUARD -> {
                actions.add(
                    WGRoleAction(
                        Res.string.guard_action,
                        Res.string.guard_action_desc,
                        WGRoleActionType.REDIRECT_ATTACK,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.guard_action_2,
                        Res.string.guard_action_2_desc,
                        WGRoleActionType.PROTECT,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.GURU -> {
                actions.add(
                    WGRoleAction(
                        Res.string.guru_action,
                        Res.string.guru_action_desc,
                        WGRoleActionType.CONVERT_GROUP,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.HUNTER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.hunter_action,
                        Res.string.hunter_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
            }

            WGRole.IDIOT -> {
                actions.add(
                    WGRoleAction(
                        Res.string.idiot_action,
                        Res.string.idiot_action_desc,
                        WGRoleActionType.VOTE_CANCEL,
                        WGRoleActionFrequency.WHEN_VOTED
                    )
                )
            }

            WGRole.LITTLE_GIRL -> {
                actions.add(
                    WGRoleAction(
                        Res.string.little_girl_action,
                        Res.string.little_girl_action_desc,
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.MARSHALL -> {
                actions.add(
                    WGRoleAction(
                        Res.string.marshall_action,
                        Res.string.marshall_action_desc,
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.MOON_SON -> {
                actions.add(
                    WGRoleAction(
                        Res.string.moon_son_action,
                        Res.string.moon_son_action_desc,
                        WGRoleActionType.CANCEL_WOLVES,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
            }

            WGRole.NOCTAMBUL -> {
                actions.add(
                    WGRoleAction(
                        Res.string.sleep_walker_action,
                        Res.string.sleep_walker_action_desc,
                        WGRoleActionType.PROTECT,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }


            WGRole.OLD_KNIGHT -> {
                actions.add(
                    WGRoleAction(
                        Res.string.old_knight_action,
                        Res.string.old_knight_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.WHEN_KILLED,
                    )
                )
            }

            WGRole.PEASANT -> {
                actions.add(
                    WGRoleAction(
                        Res.string.peasant_action,
                        Res.string.peasant_action_desc,
                        WGRoleActionType.NONE,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.PIED_PIPER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.pied_piper_action,
                        Res.string.pied_piper_action_desc,
                        WGRoleActionType.CONVERT_GROUP,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.PRIEST -> {
                actions.add(
                    WGRoleAction(
                        Res.string.priest_action,
                        Res.string.priest_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.PYROMANIAC -> {
                actions.add(
                    WGRoleAction(
                        Res.string.pyramoniac_action,
                        Res.string.pyramoniac_action_desc,
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.RANGER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.ranger_action,
                        Res.string.ranger_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.SEER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.seer_action,
                        Res.string.seer_action_desc,
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.SORCERER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.sorcerer_action,
                        Res.string.sorcerer_action_desc,
                        WGRoleActionType.REVIVE,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.sorcerer_action_2,
                        Res.string.sorcerer_action_2_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.THIEF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.thief_action,
                        Res.string.thief_action_desc,
                        WGRoleActionType.CHANGE_ROLE,
                        WGRoleActionFrequency.START_GAME
                    )
                )
            }

            WGRole.THREE_BROTHERS -> {
                actions.add(
                    WGRoleAction(
                        Res.string.three_brothers_action,
                        Res.string.three_brothers_action_desc,
                        WGRoleActionType.TEAM,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            WGRole.TRAITOR -> {
                actions.add(
                    WGRoleAction(
                        Res.string.traitor_action,
                        Res.string.traitor_action_desc,
                        WGRoleActionType.TRANSFORM_WOLF,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES,
                    )
                )
            }

            WGRole.TWO_SISTERS -> {
                actions.add(
                    WGRoleAction(
                        Res.string.two_sisters_action,
                        Res.string.two_sisters_action_desc,
                        WGRoleActionType.TEAM,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            WGRole.VILLAGE_ELDER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.village_elder_action,
                        Res.string.village_elder_action_desc,
                        WGRoleActionType.PROTECT,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.village_elder_action_2,
                        Res.string.village_elder_action_2_desc,
                        WGRoleActionType.CANCEL_VILLAGERS,
                        WGRoleActionFrequency.WHEN_VOTED,
                    )
                )
            }

            WGRole.WHITE_SOOTHSAYER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.white_soothsayer_action,
                        Res.string.white_soothsayer_action_desc,
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.WHITE_WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_action,
                        Res.string.wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.white_wolf_action,
                        Res.string.white_wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS
                    )
                )
            }

            WGRole.WILD_KID -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wild_kid_action,
                        Res.string.wild_kid_action_desc,
                        WGRoleActionType.BOUND_FATE,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.wild_kid_action_2,
                        Res.string.wild_kid_action_2_desc,
                        WGRoleActionType.TRANSFORM_WOLF,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES
                    )
                )
            }

            WGRole.WIZARD -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wizard_action,
                        Res.string.wizard_action_desc,
                        WGRoleActionType.CHANGE_ROLE,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }


            //TODO

            WGRole.WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_action,
                        Res.string.wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.WOLF_KITTEN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_action,
                        Res.string.wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_kitten_action,
                        Res.string.wolf_kitten_action_desc,
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
            }

            WGRole.WOLF_BERSERK -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_action,
                        Res.string.wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_berserk_action,
                        Res.string.wolf_berserk_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.WOLF_FAN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_fan_action,
                        Res.string.wolf_fan_action_desc,
                        WGRoleActionType.TRANSFORM_WOLF,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
            }

            WGRole.WOLF_DOG -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_dog_action,
                        Res.string.wolf_dog_action_desc,
                        WGRoleActionType.TRANSFORM_WOLF,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            // TODO : Incomplete roles

            WGRole.BERSERK -> Unit
            WGRole.CORRUPTER -> Unit
            WGRole.MAYOR -> Unit
            WGRole.HITMAN -> Unit
            WGRole.CASSANDRA -> Unit

        }

        return actions
    }

}