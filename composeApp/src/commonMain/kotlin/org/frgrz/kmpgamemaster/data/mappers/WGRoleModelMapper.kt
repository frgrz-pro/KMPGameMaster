package org.frgrz.kmpgamemaster.data.mappers

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
import org.frgrz.kmpgamemaster.data.entities.WGRole
import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity
import org.frgrz.kmpgamemaster.features.wolfgame.models.PlaysWith
import org.frgrz.kmpgamemaster.features.wolfgame.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.models.WinsWith
import org.jetbrains.compose.resources.StringResource

class WGRoleModelMapper {

    fun map(entity: WGRoleEntity): WGRoleModel {
        return WGRoleModel(
            role = entity.role,
            name = getRoleNameResource(entity.role),
            isSelected = entity.selected,
            isDefault = entity.default,
            playsWith = mapPlaysWith(entity.role),
            winsWith = mapWinsWith(entity.role),
            filters = mapRoleFilters(entity.role),
            actions = mapRoleActions(entity.role)
        )
    }

    private fun mapPlaysWith(role: WGRole): PlaysWith {
        return when (role) {
            WGRole.WOLF_FAN,
            WGRole.WOLF_KITTEN,
            WGRole.WOLF,
            WGRole.BIG_BAG_WOLF,
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
            WGRole.BIG_BAG_WOLF,
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
            WGRole.BIG_BAG_WOLF,
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
            WGRole.BIG_BAG_WOLF -> Res.string.big_bad_wolf
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
                        "",
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

            WGRole.BIG_BAG_WOLF -> {
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
                        WGRoleActionType.UNITE,
                        WGRoleActionFrequency.START_GAME
                    )
                )
            }

            WGRole.PRIEST -> {
                actions.add(
                    WGRoleAction(
                        "Exorcisez les loups",
                        "Muni de votre bol d\'eau benite, votre but est d\'exociser les loups qui mourra. Si vous vous trompez vous mourrez.",
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.UNTIL_FAIL
                    )
                )
            }

            WGRole.IDIOT -> {
                actions.add(
                    WGRoleAction(
                        "Immunisé du vote",
                        "Si le village vote contre vous, vous restez en vie mais perdez votre droit de vote.",
                        WGRoleActionType.VOTED,
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
                        WGRoleActionFrequency.EVERY_NIGHT
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

            // TODO : Incomplete roles

            else -> Unit
        }

        return actions
    }
}

data class WGRoleAction(
    val name: String,//StringResource,
    val desc: String,//StringResource
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
    UNITE,
    VOTED
}

enum class WGRoleActionFrequency {
    EVERY_NIGHT,
    EVERY_TWO_NIGHTS,
    ONLY_ONCE_PER_GAME,
    WHEN_KILLED,
    WHEN_VOTED,
    START_GAME,
    UNTIL_FAIL,
}

enum class WGRoleActionCondition {
    NONE,
    IF_NO_WOLF_DEAD,
    IF_FIRST_VOTE
}

enum class WGRoleActionCancel {
    NONE,
    GURU,
    SEER,
    VOTE,
    WOLVES
}