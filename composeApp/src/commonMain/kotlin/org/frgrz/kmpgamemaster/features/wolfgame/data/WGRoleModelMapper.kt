package org.frgrz.kmpgamemaster.features.wolfgame.data

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
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.PlaysWith
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleAction
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionCancel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionCondition
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionFrequency
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionType
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinsWith
import org.jetbrains.compose.resources.StringResource

class WGRoleModelMapper {

    fun map(entity: WGRoleDBEntity): WGRoleModel {
        val role = mapRole(entity.role)

        return WGRoleModel(
            role = role,
            name = getRoleNameResource(role),
            isSelected = entity.selected,
            isDefault = entity.default,
            playsWith = mapPlaysWith(role),
            winsWith = mapWinsWith(role),
            filters = mapRoleFilters(role),
            actions = mapRoleActions(role)
        )
    }

    private fun mapRole(dbRole: WGRoleDBEntity.WGRole): WGRole {
        return WGRole.entries[dbRole.ordinal]
    }

    private fun mapPlaysWith(role: WGRole): PlaysWith {
        return when (role) {
            WGRole.WOLF_FAN,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAD_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
            WGRole.WHITE_WOLF,
            WGRole.WOLF_BERSERK,
                -> PlaysWith.WOLVES

            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.MAYOR,
            WGRole.WILD_KID,
                -> PlaysWith.WOLVES_OR_VILLAGE

            WGRole.ANGEL,
            WGRole.ASSASSIN,
            WGRole.BERSERK,
            WGRole.CORRUPTER,
            WGRole.TRAITOR,
            WGRole.HITMAN,
            WGRole.PIED_PIPER,
                -> PlaysWith.SOLO

            WGRole.ASTRONOMER,
            WGRole.BEAR_HANDLER,
            WGRole.BLACKSMITH,
            WGRole.BULLY,
            WGRole.COMEDIAN,
            WGRole.CUPID,
            WGRole.DEFLECTOR,
            WGRole.DEMONIAC_SOUL,
            WGRole.DRUGGIST,
            WGRole.GURU,
            WGRole.DUELISTS,
            WGRole.FOX,
            WGRole.GUARD,
            WGRole.HUNTER,
            WGRole.IDIOT,
            WGRole.LITTLE_GIRL,
            WGRole.MARSHALL,
            WGRole.MOON_SON,
            WGRole.NOCTAMBULIST,
            WGRole.OLD_KNIGHT,
            WGRole.PEASANT,
            WGRole.PRIEST,
            WGRole.PYROMANIAC,
            WGRole.RANGER,
            WGRole.SEER,
            WGRole.SORCERER,
            WGRole.THIEF,
            WGRole.THREE_BROTHERS,
            WGRole.TWO_SISTERS,
            WGRole.VILLAGE_ELDER,
            WGRole.WHITE_SOOTHSAYER,
            WGRole.WIZARD,
            WGRole.CASSANDRA,
                -> PlaysWith.VILLAGE
        }
    }

    private fun mapWinsWith(role: WGRole): WinsWith {
        return when (role) {
            WGRole.WOLF_FAN,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAD_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
            WGRole.WOLF_BERSERK,
                -> WinsWith.WOLVES

            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.MAYOR,
            WGRole.WILD_KID,
                -> WinsWith.WOLVES_OR_VILLAGE

            WGRole.ANGEL,
            WGRole.ASSASSIN,
            WGRole.BERSERK,
            WGRole.CORRUPTER,
            WGRole.TRAITOR,
            WGRole.HITMAN,
            WGRole.PIED_PIPER,
            WGRole.GURU,
            WGRole.WHITE_WOLF,
                -> WinsWith.SOLO

            WGRole.ASTRONOMER,
            WGRole.BEAR_HANDLER,
            WGRole.BLACKSMITH,
            WGRole.BULLY,
            WGRole.COMEDIAN,
            WGRole.CUPID,
            WGRole.DEFLECTOR,
            WGRole.DEMONIAC_SOUL,
            WGRole.DRUGGIST,
            WGRole.DUELISTS,
            WGRole.FOX,
            WGRole.GUARD,
            WGRole.HUNTER,
            WGRole.IDIOT,
            WGRole.LITTLE_GIRL,
            WGRole.MARSHALL,
            WGRole.MOON_SON,
            WGRole.NOCTAMBULIST,
            WGRole.OLD_KNIGHT,
            WGRole.PEASANT,
            WGRole.PRIEST,
            WGRole.PYROMANIAC,
            WGRole.RANGER,
            WGRole.SEER,
            WGRole.SORCERER,
            WGRole.THIEF,
            WGRole.THREE_BROTHERS,
            WGRole.TWO_SISTERS,
            WGRole.VILLAGE_ELDER,
            WGRole.WHITE_SOOTHSAYER,
            WGRole.WIZARD,
            WGRole.CASSANDRA,
                -> WinsWith.VILLAGE
        }
    }

    private fun mapRoleFilters(role: WGRole): List<RoleFilter> {
        val filters = mutableListOf<RoleFilter>()
        filters.add(RoleFilter.ALL)

        val wolves = listOf(
            WGRole.WOLF_FAN,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAD_WOLF,
            WGRole.BLACK_WOLF,
            WGRole.BLUE_WOLF,
            WGRole.WOLF_BERSERK,
            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.WILD_KID,
            WGRole.WOLF_FAN,
            WGRole.WHITE_WOLF
        )

        if (role in wolves) {
            filters.add(RoleFilter.WOLVES)
        }

        val classics = listOf(
            WGRole.LITTLE_GIRL,
            WGRole.HUNTER,
            WGRole.MAYOR,
            WGRole.CUPID,
            WGRole.PEASANT,
            WGRole.SEER,
            WGRole.SORCERER,
            WGRole.THIEF,
            WGRole.WOLF
        )

        if (role in classics) {
            filters.add(RoleFilter.CLASSIC)
        }

        val transforms = listOf(
            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.WILD_KID,
            WGRole.THIEF,
            WGRole.COMEDIAN,
            WGRole.WOLF_FAN,
        )

        if (role in transforms) {
            filters.add(RoleFilter.TRANSFORM)
        }

        val solos = listOf(
            WGRole.ANGEL,
            WGRole.BERSERK,
            WGRole.ASSASSIN,
            WGRole.CORRUPTER,
            WGRole.TRAITOR,
            WGRole.HITMAN,
            WGRole.PIED_PIPER,
            WGRole.CASSANDRA,
            WGRole.WHITE_WOLF
        )

        if (role in solos) {
            filters.add(RoleFilter.SOLO)
        }

        val teams = listOf(
            WGRole.TWO_SISTERS,
            WGRole.THREE_BROTHERS,
            WGRole.GURU,
            WGRole.DUELISTS
        )

        if (role in teams) {
            filters.add(RoleFilter.TEAM)
        }

        val villagers = listOf(
            WGRole.ASTRONOMER,
            WGRole.BEAR_HANDLER,
            WGRole.BLACKSMITH,
            WGRole.BULLY,
            WGRole.COMEDIAN,
            WGRole.CUPID,
            WGRole.TWO_SISTERS,
            WGRole.THREE_BROTHERS,
            WGRole.GURU,
            WGRole.DUELISTS,
            WGRole.WOLF_DOG,
            WGRole.GENTLEMAN,
            WGRole.WILD_KID,
            WGRole.THIEF,
            WGRole.COMEDIAN,
            WGRole.WOLF_FAN,
            WGRole.DEFLECTOR,
            WGRole.DEMONIAC_SOUL,
            WGRole.DRUGGIST,
            WGRole.GURU,
            WGRole.DUELISTS,
            WGRole.FOX,
            WGRole.GUARD,
            WGRole.HUNTER,
            WGRole.IDIOT,
            WGRole.LITTLE_GIRL,
            WGRole.MARSHALL,
            WGRole.MOON_SON,
            WGRole.NOCTAMBULIST,
            WGRole.OLD_KNIGHT,
            WGRole.PEASANT,
            WGRole.PRIEST,
            WGRole.PYROMANIAC,
            WGRole.RANGER,
            WGRole.SEER,
            WGRole.SORCERER,
            WGRole.THIEF,
            WGRole.THREE_BROTHERS,
            WGRole.TWO_SISTERS,
            WGRole.VILLAGE_ELDER,
            WGRole.WHITE_SOOTHSAYER,
            WGRole.WIZARD,
            WGRole.CASSANDRA,
        )

        if (role in villagers) {
            filters.add(RoleFilter.VILLAGE)
        }

        return filters
    }

    private fun getRoleNameResource(role: WGRole): StringResource {
        return when (role) {
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
            WGRole.NOCTAMBULIST -> Res.string.sleep_walker
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

    private fun mapRoleActions(role: WGRole): List<WGRoleAction> {
        val actions = mutableListOf<WGRoleAction>()

        when (role) {
            WGRole.LITTLE_GIRL -> {
                actions.add(
                    WGRoleAction(
                        "Espionnez les loups",
                        "Espionne les loups pendant la nuit. Cependant si elle sera la victime des loups.",
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.WOLF -> {
                actions.add(
                    WGRoleAction(
                        "Tuez les villageois",
                        "Chaque nuit décidez d\'une victime à abattre avec les autres loups",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.WHITE_WOLF -> {
                actions.add(
                    WGRoleAction(
                        "Tuez les villageois",
                        "Chaque nuit décidez d\'une victime à abattre avec les autres loups",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Tuez les loups",
                        "Vous gagnez seul(e), une nuit sur 2 sacrifiez secretement un autre loup",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS
                    )
                )
            }

            WGRole.BIG_BAD_WOLF -> {
                actions.add(
                    WGRoleAction(
                        "Tuez les villageois",
                        "Chaque nuit décidez d\'une victime à abattre avec les autres loups",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Tuez un villageois supplémentaire",
                        "Tant qu'aucun loup n'est mort vous tuez un villageois",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        WGRoleActionCondition.IF_NO_WOLF_DEAD
                    )
                )
            }

            WGRole.BLACK_WOLF -> {
                actions.add(
                    WGRoleAction(
                        "Tuez les villageois",
                        "Chaque nuit décidez d\'une victime à abattre avec les autres loups",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Infectez un villageois",
                        "Une fois par partie vous pouvez infecter un villageois sans qu'il le sache et qui deviendra un loup la nuit suivante",
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.BLUE_WOLF -> {
                actions.add(
                    WGRoleAction(
                        "Tuez les villageois",
                        "Chaque nuit décidez d\'une victime à abattre avec les autres loups",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Decouvrez les roles",
                        "Chaque nuit découvrez le role secret d\'un des joueurs",
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Immunisé de la voyante",
                        "La voyante ne pourra pas découvrir votre rôle, un faux rôle lui sera révélé si elle regarde votre carte",
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.SEER
                    )
                )
            }

            WGRole.WOLF_KITTEN -> {
                actions.add(
                    WGRoleAction(
                        "Tuez les villageois",
                        "Chaque nuit décidez d\'une victime à abattre avec les autres loups",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Infectez un villageois",
                        "A votre mort le villageois désigné pendant le tour des loups deviendra un loup la nuit suivante",
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
            }

            WGRole.WOLF_BERSERK -> {
                actions.add(
                    WGRoleAction(
                        "Tuez les villageois",
                        "Chaque nuit décidez d\'une victime à abattre avec les autres loups",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Enragez les loups",
                        "Une fois par partie, si la victime des loups est protégée par d\'autre(s) joueur(s), ce(s) joueurs mourront aussi",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.WOLF_FAN -> {
                actions.add(
                    WGRoleAction(
                        "Devenez un loup",
                        "Si les loups essayent de vous tuer vous deviendrez un des leurs",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Immunisé du Gourou",
                        "Le Gourou ne peut pas vous convertir à sa secte",
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.GURU
                    )
                )
            }

            WGRole.SEER -> {
                actions.add(
                    WGRoleAction(
                        "Decouvrez les roles",
                        "Chaque nuit découvrez le role secret d\'un des joueurs",
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.SORCERER -> {
                actions.add(
                    WGRoleAction(
                        "Potion de résurection",
                        "Utilisez cette potion pour réanimer un joueur tué pendant la nuit",
                        WGRoleActionType.REVIVE,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Potion de mort",
                        "Utilisez cette potion pour tuer un joueur pendant la nuit, les deux potions ne peuvent pas être utilisées la même nuit.",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.ASSASSIN -> {
                actions.add(
                    WGRoleAction(
                        "Assassinez les villageois",
                        "Chaque nuit décidez d\'une victime à assassiner, vous gagnez si vous êtes le dernier en vie",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Immunise des loups",
                        "Les loups ne peuvent pas vous tuer.",
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.WOLVES
                    )
                )
            }

            WGRole.CUPID -> {
                actions.add(
                    WGRoleAction(
                        "Creez un couple",
                        "Le destins du couple sera lié, si l\'un meurs l\'autre aussi. Si un des amoureux est un loup il doit garder son amoureux en vie",
                        WGRoleActionType.BOUND_FATE,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            WGRole.PRIEST -> {
                actions.add(
                    WGRoleAction(
                        "Exorcisme",
                        "Vous pouvez, une fois par partie lancer de l'eau bénite sur un autre joueur. Si c'est un loup il meurt, sinon vous mourrez",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.IDIOT -> {
                actions.add(
                    WGRoleAction(
                        "Immunisé du vote",
                        "Si le village vote contre vous, vous restez en vie mais perdez votre droit de vote.",
                        WGRoleActionType.VOTE_CANCEL,
                        WGRoleActionFrequency.WHEN_VOTED,
                        cancels = WGRoleActionCancel.VOTE
                    )
                )
            }

            WGRole.GUARD -> {
                actions.add(
                    WGRoleAction(
                        "Protegez un joueur",
                        "Choisissez un joueur à proteger, vous serez attaqué à sa place",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Resistez à une attaque",
                        "Vous pouvez resister à une attaque, la deuxième vous sera fatale",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.THIEF -> {
                actions.add(
                    WGRoleAction(
                        "Choisissez votre role",
                        "Vous serez présenté 2 rôles en début de partie, vous pourrez choisir votre role pour le reste de la partie",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.START_GAME
                    )
                )
            }

            WGRole.ANGEL -> {
                actions.add(
                    WGRoleAction(
                        "First Blood",
                        "Faites vous éliminer au premier tour et vous gagnez la partie.",
                        WGRoleActionType.VOTED,
                        WGRoleActionFrequency.WHEN_VOTED,
                        WGRoleActionCondition.IF_FIRST_VOTE
                    )
                )
            }


            WGRole.WOLF_DOG -> {
                actions.add(
                    WGRoleAction(
                        "Choisissez votre camp",
                        "Lors de la première nuit vous pouvez répondre à l'appel des loups et vous devenez loup. Sinon vous restez villageois",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            WGRole.COMEDIAN -> {
                actions.add(
                    WGRoleAction(
                        "Choisissez votre rôle",
                        "En début de partie trois rôle supplémentaires seront tirés, connus de tous. Chaque nuit vous pourrez choisir d'utiliser un de ces rôles, qui sera ensuite retiré des choix disponibles",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }


            WGRole.PIED_PIPER -> {
                actions.add(
                    WGRoleAction(
                        "Envoutez le village",
                        "Chaque nuit vous envoutez 2 personnes, vous gagnez lorsque tout le village est envouté.",
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.VILLAGE_ELDER -> {
                actions.add(
                    WGRoleAction(
                        "Resistez à une attaque",
                        "Vous pouvez resister à une attaque des loups",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Mysticisme",
                        "Si le village décide de vous voter, tous les villageois perdent leurs capacités",
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.WHEN_VOTED,
                        cancels = WGRoleActionCancel.VILLAGERS
                    )
                )
            }

            WGRole.PEASANT -> {
                actions.add(
                    WGRoleAction(
                        "Rien",
                        "Vous n'avez pas de capacités, utilisez vos capacités d'enquêteur car vous n'aurez que ça",
                        WGRoleActionType.NONE,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.TWO_SISTERS -> {
                actions.add(
                    WGRoleAction(
                        "Fraternité",
                        "En début de partie les 2 soeurs se réveillent, et possèdent désormais une alliée sûre dans la partie",
                        WGRoleActionType.TEAM,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            WGRole.THREE_BROTHERS -> {
                actions.add(
                    WGRoleAction(
                        "Fraternité",
                        "En début de partie les 3 frêres se réveillent, et possèdent désormais des alliés sûrs dans la partie",
                        WGRoleActionType.TEAM,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            WGRole.MAYOR -> {
                actions.add(
                    WGRoleAction(
                        "Double Vote",
                        "En début de partie le maire est élu par le village, son vôte compte double. Il tranche en cas d'égalité",
                        WGRoleActionType.DOUBLE_VOTE,
                        WGRoleActionFrequency.START_GAME
                    )
                )
            }


            WGRole.ASTRONOMER -> {
                actions.add(
                    WGRoleAction(
                        "Nouvelle Lune",
                        "Lorsque vous déclenchez la nouvelle lune les loups ne pourront pas se reveiller et utiliser leurs pouvoirs",
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME,
                        cancels = WGRoleActionCancel.WOLVES
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Pluie de méteorites",
                        "Lorsque vous déclenchez la pluie de météorites un joueur aléatoire sera tué, si c'est un villageois vous mourrez aussi.",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.DEFLECTOR -> {
                actions.add(
                    WGRoleAction(
                        "Redirection",
                        "Pendant la nuit, choisissez un joueur qui sera protégé, et un autre qui sera attaqué à la place. Vous pouvez rediriger jusqu'à 2 attaques. Après une attaque réussie vous ne pouvez pas rediriger d'attaque la nuit suivante.",
                        WGRoleActionType.REDIRECT_ATTACK,
                        WGRoleActionFrequency.TWICE_PER_GAME,
                        WGRoleActionCondition.IF_NOT_SUCCESSFUL_NIGHT_BEFORE
                    )
                )
            }

            WGRole.BULLY -> {
                actions.add(
                    WGRoleAction(
                        "Lance Pierre",
                        "Vous lancez un pierre et assomez un joueur, celui-ci ne restera assomé la journée et nuit suivant l'empechant de jouer son rôles et participer au vote",
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.ANY
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Lancé Mortel",
                        "Un deuxième lancé sur un joueur déjà assomé lui sera mortel. Vous ne pouvez tuer que 2 joueurs par partie.",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.TWICE_PER_GAME,
                    )
                )
            }

            WGRole.DEMONIAC_SOUL -> {
                actions.add(
                    WGRoleAction(
                        "Usurpateur",
                        "Chaque nuit vous aurez un villageois attribué, et jouerez son rôle à sa place",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Destins Liés",
                        "Si le joueur dont vous usurpez l'identité meurs pendant la nuit, vous mourrez aussi.",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES,
                    )
                )
            }

            WGRole.HITMAN -> {
                actions.add(
                    WGRoleAction(
                        "Diffamation",
                        "Un joueur vous sera attribué en début de partie, lorsque ce joueur meurt par le vote du village vous gagnez. Si ce joueur meurt autrement vous gagnez avec le village",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES,
                    )
                )
            }

            WGRole.GURU -> {
                actions.add(
                    WGRoleAction(
                        "Convertissez",
                        "Chaque nuit vous convertissez un membre à votre secte. Lorsque plus la moitié des joueurs appartiennent à la secte vous gagnez.",
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.MARSHALL -> {
                actions.add(
                    WGRoleAction(
                        "Ronde de nuit",
                        "La nuit vous surveillez 2 joueurs, si l'un d'entre eux meurs, vous découvrez deux suspects.",
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.WIZARD -> {
                actions.add(
                    WGRoleAction(
                        "Prestidigitation",
                        "Selectionnez un rôle des joueurs morts de la nuit que vous jouerez jusqu'à la nuit suivante.",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.HUNTER -> {
                actions.add(
                    WGRoleAction(
                        "Derniere Balle",
                        "A votre mort vous tirez votre dernière balle sur un joueur.",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
            }

            WGRole.WILD_KID -> {
                actions.add(
                    WGRoleAction(
                        "Mentor",
                        "En début de partie vous choisirez un joueur sans qu'il le sache pour devenir votre tuteur.",
                        WGRoleActionType.BOUND_FATE,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Mort du mentor",
                        "A la mort de votre mentor vous vous échapez et devenez un loup.",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES
                    )
                )
            }

            WGRole.PYROMANIAC -> {
                actions.add(
                    WGRoleAction(
                        "Incedie",
                        "Une fois par partie, vous pouvez mettre le feu à la maison d'un des joueurs. Ce joueur perd son pouvoir. Si ce joueur est la victime des loups il sera sauvé.",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }


            WGRole.NOCTAMBULIST -> {
                actions.add(
                    WGRoleAction(
                        "Soirée Pyjama",
                        "Chaque soir le noctambule désigne un joueur chez qui il passe la soirée. S'il s'agit d'un villageois il annulera toute attaque sur lui. S'il s'agit d'un loup il mourra.",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.WOLVES
                    )
                )
            }

            WGRole.MOON_SON -> {
                actions.add(
                    WGRoleAction(
                        "Nouvelle Lune",
                        "La nuit suivant sa mort les loups ne se reveilleront pas et ne pourrons pas tuer.",
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.WHEN_KILLED,
                        cancels = WGRoleActionCancel.WOLVES
                    )
                )
            }

            WGRole.BLACKSMITH -> {
                actions.add(
                    WGRoleAction(
                        "Bouclier",
                        "Forge un bouclier qu'il pourra donner la nuit suivante à un joueur pour se protéger.",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS,
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Epée",
                        "Forge une épée qu'il pourra donner la nuit suivante à un joueur pour attaquer",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS,
                    )
                )
            }

            WGRole.FOX -> {
                actions.add(
                    WGRoleAction(
                        "Odorat",
                        "Chaque nuit peut renifler 3 joueurs, le renard perdra son odorat lorsque qu'aucun des 3 joueurs sentis n'est un loup.",
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.UNTIL_FAIL,
                    )
                )
            }

            WGRole.DUELISTS -> {
                actions.add(
                    WGRoleAction(
                        "Duel",
                        "Au début de partie les duelistes prennent connaissance l'un de l'autre. Si le village gagne et que les deux sont encore en vie ils perdent tous les deux.",
                        WGRoleActionType.BOUND_FATE,
                        WGRoleActionFrequency.START_GAME,
                    )
                )
            }

            WGRole.OLD_KNIGHT -> {
                actions.add(
                    WGRoleAction(
                        "Tétanos",
                        "S'il est attaqué par les loups il se défent avec son épée rouillée et donne le tétanos au premier loup à sa gauche. Le loup mourra la nuit suivante.",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.WHEN_KILLED,
                    )
                )
            }

            WGRole.BEAR_HANDLER -> {
                actions.add(
                    WGRoleAction(
                        "Odorat",
                        "L'ours va renifler les joueurs à sa gauche et à sa droite. S'il y a un loup autour de lui le village le saura.",
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.GENTLEMAN -> {
                actions.add(
                    WGRoleAction(
                        "Immunisé des potions",
                        "Le gentleman ne boit pas les potions bizarre",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.POTIONS
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Fuckboy",
                        "Le gentleman devient un loup s'il est désigné par Cupidon",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.START_GAME,
                    )
                )

                actions.add(
                    WGRoleAction(
                        "Galant",
                        "Le gentleman ne vote pas contre les femmes",
                        WGRoleActionType.VOTE_PROTECTION,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.RANGER -> {
                actions.add(
                    WGRoleAction(
                        "Piège",
                        "Le ranger peut placer un piège devant la porte d'un joueur, si ce dernier est attaqué par les loups l'un d'eux mourra",
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.TRAITOR -> {
                actions.add(
                    WGRoleAction(
                        "Opportuniste",
                        "Lorsque le dernier loup meurt il deviens loup.",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES,
                    )
                )
            }

            WGRole.DRUGGIST -> {
                actions.add(
                    WGRoleAction(
                        "Potion de confusion",
                        "Le joueur désigné ne pourra pas voter au prochain vote",
                        WGRoleActionType.VOTE_CANCEL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Potion de charisme",
                        "Le joueur désigné aura un vote double au prochain vote",
                        WGRoleActionType.DOUBLE_VOTE,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        "Trouve la voyante",
                        "S'il trouve la voyante, il pourra lui recharger ses potions",
                        WGRoleActionType.REFILL_POTION,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.WHITE_SOOTHSAYER -> {
                actions.add(
                    WGRoleAction(
                        "Observateur",
                        "Chaque nuit il connait la victime des loups.",
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }


            WGRole.CASSANDRA -> {
                actions.add(
                    WGRoleAction(
                        "Dilemne",
                        "Chaque nuit choisit 3 joueurs. Parmis un de ces joueurs doit accepter de se sacrifier sinon les 3 mourront.",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            // TODO : Incomplete roles


            WGRole.BERSERK -> Unit
            WGRole.CORRUPTER -> Unit

        }

        return actions
    }
}
