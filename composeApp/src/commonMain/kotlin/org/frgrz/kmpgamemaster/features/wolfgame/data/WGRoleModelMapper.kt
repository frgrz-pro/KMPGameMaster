package org.frgrz.kmpgamemaster.features.wolfgame.data

import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.angel
import kmpgamemaster.composeapp.generated.resources.angel_action
import kmpgamemaster.composeapp.generated.resources.angel_action_desc
import kmpgamemaster.composeapp.generated.resources.assassin
import kmpgamemaster.composeapp.generated.resources.assassin_action
import kmpgamemaster.composeapp.generated.resources.assassin_action_2
import kmpgamemaster.composeapp.generated.resources.assassin_action_2_desc
import kmpgamemaster.composeapp.generated.resources.assassin_action_desc
import kmpgamemaster.composeapp.generated.resources.astronomer
import kmpgamemaster.composeapp.generated.resources.astronomer_action
import kmpgamemaster.composeapp.generated.resources.astronomer_action_2
import kmpgamemaster.composeapp.generated.resources.astronomer_action_2_desc
import kmpgamemaster.composeapp.generated.resources.astronomer_action_desc
import kmpgamemaster.composeapp.generated.resources.bear_handler
import kmpgamemaster.composeapp.generated.resources.bear_handler_action
import kmpgamemaster.composeapp.generated.resources.bear_handler_action_desc
import kmpgamemaster.composeapp.generated.resources.berserk
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_action
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_action_2
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_action_2_desc
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.black_wolf
import kmpgamemaster.composeapp.generated.resources.black_wolf_action
import kmpgamemaster.composeapp.generated.resources.black_wolf_action_2
import kmpgamemaster.composeapp.generated.resources.black_wolf_action_2_desc
import kmpgamemaster.composeapp.generated.resources.black_wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.blacksmith
import kmpgamemaster.composeapp.generated.resources.blacksmith_action
import kmpgamemaster.composeapp.generated.resources.blacksmith_action_2
import kmpgamemaster.composeapp.generated.resources.blacksmith_action_2_desc
import kmpgamemaster.composeapp.generated.resources.blacksmith_action_desc
import kmpgamemaster.composeapp.generated.resources.blue_wolf
import kmpgamemaster.composeapp.generated.resources.blue_wolf_action
import kmpgamemaster.composeapp.generated.resources.blue_wolf_action_2
import kmpgamemaster.composeapp.generated.resources.blue_wolf_action_2_desc
import kmpgamemaster.composeapp.generated.resources.blue_wolf_action_3
import kmpgamemaster.composeapp.generated.resources.blue_wolf_action_3_desc
import kmpgamemaster.composeapp.generated.resources.blue_wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.bully
import kmpgamemaster.composeapp.generated.resources.bully_action
import kmpgamemaster.composeapp.generated.resources.bully_action_2
import kmpgamemaster.composeapp.generated.resources.bully_action_2_desc
import kmpgamemaster.composeapp.generated.resources.bully_action_desc
import kmpgamemaster.composeapp.generated.resources.cassandre
import kmpgamemaster.composeapp.generated.resources.cassandre_action
import kmpgamemaster.composeapp.generated.resources.cassandre_action_desc
import kmpgamemaster.composeapp.generated.resources.comedian
import kmpgamemaster.composeapp.generated.resources.comedian_action
import kmpgamemaster.composeapp.generated.resources.comedian_action_desc
import kmpgamemaster.composeapp.generated.resources.corrupter
import kmpgamemaster.composeapp.generated.resources.cupid
import kmpgamemaster.composeapp.generated.resources.cupid_action
import kmpgamemaster.composeapp.generated.resources.cupid_action_desc
import kmpgamemaster.composeapp.generated.resources.deflector
import kmpgamemaster.composeapp.generated.resources.deflector_action
import kmpgamemaster.composeapp.generated.resources.deflector_action_desc
import kmpgamemaster.composeapp.generated.resources.demoniac_soul
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_action
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_action_desc
import kmpgamemaster.composeapp.generated.resources.druggist
import kmpgamemaster.composeapp.generated.resources.druggist_action
import kmpgamemaster.composeapp.generated.resources.druggist_action_2
import kmpgamemaster.composeapp.generated.resources.druggist_action_2_desc
import kmpgamemaster.composeapp.generated.resources.druggist_action_3
import kmpgamemaster.composeapp.generated.resources.druggist_action_3_desc
import kmpgamemaster.composeapp.generated.resources.druggist_action_desc
import kmpgamemaster.composeapp.generated.resources.duelists
import kmpgamemaster.composeapp.generated.resources.duelists_action
import kmpgamemaster.composeapp.generated.resources.duelists_action_desc
import kmpgamemaster.composeapp.generated.resources.fox
import kmpgamemaster.composeapp.generated.resources.fox_action
import kmpgamemaster.composeapp.generated.resources.fox_action_desc
import kmpgamemaster.composeapp.generated.resources.gentleman
import kmpgamemaster.composeapp.generated.resources.gentleman_action
import kmpgamemaster.composeapp.generated.resources.gentleman_action_2
import kmpgamemaster.composeapp.generated.resources.gentleman_action_2_desc
import kmpgamemaster.composeapp.generated.resources.gentleman_action_3
import kmpgamemaster.composeapp.generated.resources.gentleman_action_3_desc
import kmpgamemaster.composeapp.generated.resources.gentleman_action_desc
import kmpgamemaster.composeapp.generated.resources.guard
import kmpgamemaster.composeapp.generated.resources.guard_action
import kmpgamemaster.composeapp.generated.resources.guard_action_2
import kmpgamemaster.composeapp.generated.resources.guard_action_2_desc
import kmpgamemaster.composeapp.generated.resources.guard_action_desc
import kmpgamemaster.composeapp.generated.resources.guru
import kmpgamemaster.composeapp.generated.resources.guru_action
import kmpgamemaster.composeapp.generated.resources.guru_action_desc
import kmpgamemaster.composeapp.generated.resources.hitman
import kmpgamemaster.composeapp.generated.resources.hitman_action
import kmpgamemaster.composeapp.generated.resources.hitman_action_desc
import kmpgamemaster.composeapp.generated.resources.hunter
import kmpgamemaster.composeapp.generated.resources.hunter_action
import kmpgamemaster.composeapp.generated.resources.hunter_action_desc
import kmpgamemaster.composeapp.generated.resources.idiot
import kmpgamemaster.composeapp.generated.resources.idiot_action
import kmpgamemaster.composeapp.generated.resources.idiot_action_desc
import kmpgamemaster.composeapp.generated.resources.little_girl
import kmpgamemaster.composeapp.generated.resources.little_girl_action
import kmpgamemaster.composeapp.generated.resources.little_girl_action_desc
import kmpgamemaster.composeapp.generated.resources.marshall
import kmpgamemaster.composeapp.generated.resources.marshall_action
import kmpgamemaster.composeapp.generated.resources.marshall_action_desc
import kmpgamemaster.composeapp.generated.resources.mayor
import kmpgamemaster.composeapp.generated.resources.mayor_action
import kmpgamemaster.composeapp.generated.resources.mayor_action_desc
import kmpgamemaster.composeapp.generated.resources.moon_son
import kmpgamemaster.composeapp.generated.resources.moon_son_action
import kmpgamemaster.composeapp.generated.resources.moon_son_action_desc
import kmpgamemaster.composeapp.generated.resources.old_knight
import kmpgamemaster.composeapp.generated.resources.old_knight_action
import kmpgamemaster.composeapp.generated.resources.old_knight_action_desc
import kmpgamemaster.composeapp.generated.resources.peasant
import kmpgamemaster.composeapp.generated.resources.peasant_action
import kmpgamemaster.composeapp.generated.resources.peasant_action_desc
import kmpgamemaster.composeapp.generated.resources.pied_piper
import kmpgamemaster.composeapp.generated.resources.pied_piper_action
import kmpgamemaster.composeapp.generated.resources.pied_piper_action_desc
import kmpgamemaster.composeapp.generated.resources.priest
import kmpgamemaster.composeapp.generated.resources.priest_action
import kmpgamemaster.composeapp.generated.resources.priest_action_desc
import kmpgamemaster.composeapp.generated.resources.pyramoniac_action
import kmpgamemaster.composeapp.generated.resources.pyramoniac_action_desc
import kmpgamemaster.composeapp.generated.resources.pyromaniac
import kmpgamemaster.composeapp.generated.resources.ranger
import kmpgamemaster.composeapp.generated.resources.ranger_action
import kmpgamemaster.composeapp.generated.resources.ranger_action_desc
import kmpgamemaster.composeapp.generated.resources.seer
import kmpgamemaster.composeapp.generated.resources.seer_action
import kmpgamemaster.composeapp.generated.resources.seer_action_desc
import kmpgamemaster.composeapp.generated.resources.sleep_walker
import kmpgamemaster.composeapp.generated.resources.sleep_walker_action
import kmpgamemaster.composeapp.generated.resources.sleep_walker_action_desc
import kmpgamemaster.composeapp.generated.resources.sorcerer
import kmpgamemaster.composeapp.generated.resources.sorcerer_action
import kmpgamemaster.composeapp.generated.resources.sorcerer_action_2
import kmpgamemaster.composeapp.generated.resources.sorcerer_action_2_desc
import kmpgamemaster.composeapp.generated.resources.sorcerer_action_desc
import kmpgamemaster.composeapp.generated.resources.thief
import kmpgamemaster.composeapp.generated.resources.thief_action
import kmpgamemaster.composeapp.generated.resources.thief_action_desc
import kmpgamemaster.composeapp.generated.resources.three_brothers
import kmpgamemaster.composeapp.generated.resources.three_brothers_action
import kmpgamemaster.composeapp.generated.resources.three_brothers_action_desc
import kmpgamemaster.composeapp.generated.resources.traitor
import kmpgamemaster.composeapp.generated.resources.traitor_action
import kmpgamemaster.composeapp.generated.resources.traitor_action_desc
import kmpgamemaster.composeapp.generated.resources.two_sisters
import kmpgamemaster.composeapp.generated.resources.two_sisters_action
import kmpgamemaster.composeapp.generated.resources.two_sisters_action_desc
import kmpgamemaster.composeapp.generated.resources.village_elder
import kmpgamemaster.composeapp.generated.resources.village_elder_action
import kmpgamemaster.composeapp.generated.resources.village_elder_action_2
import kmpgamemaster.composeapp.generated.resources.village_elder_action_2_desc
import kmpgamemaster.composeapp.generated.resources.village_elder_action_desc
import kmpgamemaster.composeapp.generated.resources.white_soothsayer
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_action
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_action_desc
import kmpgamemaster.composeapp.generated.resources.white_wolf
import kmpgamemaster.composeapp.generated.resources.white_wolf_action
import kmpgamemaster.composeapp.generated.resources.white_wolf_action_2
import kmpgamemaster.composeapp.generated.resources.white_wolf_action_2_desc
import kmpgamemaster.composeapp.generated.resources.white_wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.wild_kid
import kmpgamemaster.composeapp.generated.resources.wild_kid_action
import kmpgamemaster.composeapp.generated.resources.wild_kid_action_2
import kmpgamemaster.composeapp.generated.resources.wild_kid_action_2_desc
import kmpgamemaster.composeapp.generated.resources.wild_kid_action_desc
import kmpgamemaster.composeapp.generated.resources.wizard
import kmpgamemaster.composeapp.generated.resources.wizard_action
import kmpgamemaster.composeapp.generated.resources.wizard_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf
import kmpgamemaster.composeapp.generated.resources.wolf_action
import kmpgamemaster.composeapp.generated.resources.wolf_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_berserk
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_action
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_action_2
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_action_2_desc
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_dog
import kmpgamemaster.composeapp.generated.resources.wolf_dog_action
import kmpgamemaster.composeapp.generated.resources.wolf_dog_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_fan
import kmpgamemaster.composeapp.generated.resources.wolf_fan_action
import kmpgamemaster.composeapp.generated.resources.wolf_fan_action_2
import kmpgamemaster.composeapp.generated.resources.wolf_fan_action_2_desc
import kmpgamemaster.composeapp.generated.resources.wolf_fan_action_desc
import kmpgamemaster.composeapp.generated.resources.wolf_kitten
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_action
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_action_2
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_action_2_desc
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_action_desc
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers.Mapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.PlaysWith
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleAction
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionCancel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionCondition
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionFrequency
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleActionType
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinCondition
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinConditionType
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinsWith
import org.jetbrains.compose.resources.StringResource

class WinConditionMapper: Mapper<WGRole, WinCondition> {
    override fun map(input: WGRole): WinCondition {
        return when (input) {
            else -> WinCondition(
                type = WinConditionType.CLASSIC_VILLAGE,
                winsWith = WinsWith.VILLAGE
            )
        }
    }

}

class WGRoleModelMapper(
    private val winConditionMapper:WinConditionMapper
) {

    fun map(role: WGRole): WGRoleModel {
        return WGRoleModel(
            role = role,
            name = getRoleNameResource(role),
            isSelected = true,
            isDefault = false, //TODO
            playsWith = mapPlaysWith(role),
            winCondition = winConditionMapper.map(role),
            filters = mapRoleFilters(role),
            actions = mapRoleActions(role)
        )
    }

    fun map(entity: WGRoleDBEntity): WGRoleModel {
        val dbRole = WGRoleDBEntity.WGRole.entries.first { it.name == entity.role }
        val role = mapRole(dbRole)

        return WGRoleModel(
            role = role,
            name = getRoleNameResource(role),
            isSelected = entity.selected,
            isDefault = entity.default,
            playsWith = mapPlaysWith(role),
            winCondition = winConditionMapper.map(role),
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
            WGRole.NOCTAMBUL,
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
            WGRole.NOCTAMBUL,
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
            WGRole.NOCTAMBUL,
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

    private fun mapRoleActions(role: WGRole): List<WGRoleAction> {
        val actions = mutableListOf<WGRoleAction>()

        when (role) {
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

            WGRole.WHITE_WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.white_wolf_action,
                        Res.string.white_wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.white_wolf_action_2,
                        Res.string.white_wolf_action_2_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS
                    )
                )
            }

            WGRole.BIG_BAD_WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.big_bad_wolf_action,
                        Res.string.big_bad_wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.big_bad_wolf_action_2,
                        Res.string.big_bad_wolf_action_2_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        WGRoleActionCondition.IF_NO_WOLF_DEAD
                    )
                )
            }

            WGRole.BLACK_WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.black_wolf_action,
                        Res.string.black_wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.black_wolf_action_2,
                        Res.string.black_wolf_action_2_desc,
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.BLUE_WOLF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.blue_wolf_action,
                        Res.string.blue_wolf_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.blue_wolf_action_2,
                        Res.string.blue_wolf_action_2_desc,
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.blue_wolf_action_3,
                        Res.string.blue_wolf_action_3_desc,
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.SEER
                    )
                )
            }

            WGRole.WOLF_KITTEN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_kitten_action,
                        Res.string.wolf_kitten_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_kitten_action_2,
                        Res.string.wolf_kitten_action_2_desc,
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
            }

            WGRole.WOLF_BERSERK -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_berserk_action,
                        Res.string.wolf_berserk_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_berserk_action_2,
                        Res.string.wolf_berserk_action_2_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.WOLF_FAN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_fan_action,
                        Res.string.wolf_fan_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_KILLED
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_fan_action_2,
                        Res.string.wolf_fan_action_2_desc,
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.GURU
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

            WGRole.ASSASSIN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.assassin_action,
                        Res.string.assassin_action_desc,
                        WGRoleActionType.KILL,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.assassin_action_2,
                        Res.string.assassin_action_2_desc,
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.WOLVES
                    )
                )
            }

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

            WGRole.IDIOT -> {
                actions.add(
                    WGRoleAction(
                        Res.string.idiot_action,
                        Res.string.idiot_action_desc,
                        WGRoleActionType.VOTE_CANCEL,
                        WGRoleActionFrequency.WHEN_VOTED,
                        cancels = WGRoleActionCancel.VOTE
                    )
                )
            }

            WGRole.GUARD -> {
                actions.add(
                    WGRoleAction(
                        Res.string.guard_action,
                        Res.string.guard_action_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
                actions.add(
                    WGRoleAction(
                        Res.string.guard_action_2,
                        Res.string.guard_action_2_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }

            WGRole.THIEF -> {
                actions.add(
                    WGRoleAction(
                        Res.string.thief_action,
                        Res.string.thief_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.START_GAME
                    )
                )
            }

            WGRole.ANGEL -> {
                actions.add(
                    WGRoleAction(
                        Res.string.angel_action,
                        Res.string.angel_action_desc,
                        WGRoleActionType.VOTED,
                        WGRoleActionFrequency.WHEN_VOTED,
                        WGRoleActionCondition.IF_FIRST_VOTE
                    )
                )
            }


            WGRole.WOLF_DOG -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wolf_dog_action,
                        Res.string.wolf_dog_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.FIRST_NIGHT
                    )
                )
            }

            WGRole.COMEDIAN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.comedian_action,
                        Res.string.comedian_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }


            WGRole.PIED_PIPER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.pied_piper_action,
                        Res.string.pied_piper_action_desc,
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.EVERY_NIGHT
                    )
                )
            }

            WGRole.VILLAGE_ELDER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.village_elder_action,
                        Res.string.village_elder_action_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.village_elder_action_2,
                        Res.string.village_elder_action_2_desc,
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.WHEN_VOTED,
                        cancels = WGRoleActionCancel.VILLAGERS
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

            WGRole.MAYOR -> {
                actions.add(
                    WGRoleAction(
                        Res.string.mayor_action,
                        Res.string.mayor_action_desc,
                        WGRoleActionType.DOUBLE_VOTE,
                        WGRoleActionFrequency.START_GAME
                    )
                )
            }


            WGRole.ASTRONOMER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.astronomer_action,
                        Res.string.astronomer_action_desc,
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME,
                        cancels = WGRoleActionCancel.WOLVES
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

            WGRole.BULLY -> {
                actions.add(
                    WGRoleAction(
                        Res.string.bully_action,
                        Res.string.bully_action_desc,
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.ANY
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

            WGRole.DEMONIAC_SOUL -> {
                actions.add(
                    WGRoleAction(
                        Res.string.demoniac_soul_action,
                        Res.string.demoniac_soul_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )

                //TODO Fix missing resources
                /*actions.add(
                    WGRoleAction(
                        "Destins Liés",
                        "Si le joueur dont vous usurpez l'identité meurs pendant la nuit, vous mourrez aussi.",
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES,
                    )
                )*/
            }

            WGRole.HITMAN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.hitman_action,
                        Res.string.hitman_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES,
                    )
                )
            }

            WGRole.GURU -> {
                actions.add(
                    WGRoleAction(
                        Res.string.guru_action,
                        Res.string.guru_action_desc,
                        WGRoleActionType.INFECT,
                        WGRoleActionFrequency.EVERY_NIGHT,
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

            WGRole.WIZARD -> {
                actions.add(
                    WGRoleAction(
                        Res.string.wizard_action,
                        Res.string.wizard_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.HUNTER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.hunter_action,
                        Res.string.hunter_action_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.WHEN_KILLED
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
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES
                    )
                )
            }

            WGRole.PYROMANIAC -> {
                actions.add(
                    WGRoleAction(
                        Res.string.pyramoniac_action,
                        Res.string.pyramoniac_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.ONLY_ONCE_PER_GAME
                    )
                )
            }


            WGRole.NOCTAMBUL -> {
                actions.add(
                    WGRoleAction(
                        Res.string.sleep_walker_action,
                        Res.string.sleep_walker_action_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.WOLVES
                    )
                )
            }

            WGRole.MOON_SON -> {
                actions.add(
                    WGRoleAction(
                        Res.string.moon_son_action,
                        Res.string.moon_son_action_desc,
                        WGRoleActionType.CANCEL_ABILITY,
                        WGRoleActionFrequency.WHEN_KILLED,
                        cancels = WGRoleActionCancel.WOLVES
                    )
                )
            }

            WGRole.BLACKSMITH -> {
                actions.add(
                    WGRoleAction(
                        Res.string.blacksmith_action,
                        Res.string.blacksmith_action_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS,
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.blacksmith_action_2,
                        Res.string.blacksmith_action_2_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_TWO_NIGHTS,
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

            WGRole.BEAR_HANDLER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.bear_handler_action,
                        Res.string.bear_handler_action_desc,
                        WGRoleActionType.SPY,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.GENTLEMAN -> {
                actions.add(
                    WGRoleAction(
                        Res.string.gentleman_action,
                        Res.string.gentleman_action_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_NIGHT,
                        cancels = WGRoleActionCancel.POTIONS
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.gentleman_action_2,
                        Res.string.gentleman_action_2_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.START_GAME,
                    )
                )

                actions.add(
                    WGRoleAction(
                        Res.string.gentleman_action_3,
                        Res.string.gentleman_action_3_desc,
                        WGRoleActionType.VOTE_PROTECTION,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.RANGER -> {
                actions.add(
                    WGRoleAction(
                        Res.string.ranger_action,
                        Res.string.ranger_action_desc,
                        WGRoleActionType.KILL_PROTECTOR,
                        WGRoleActionFrequency.EVERY_NIGHT,
                    )
                )
            }

            WGRole.TRAITOR -> {
                actions.add(
                    WGRoleAction(
                        Res.string.traitor_action,
                        Res.string.traitor_action_desc,
                        WGRoleActionType.TRANSFORM,
                        WGRoleActionFrequency.WHEN_DESIGNATED_PLAYER_DIES,
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
                        WGRoleActionType.REFILL_POTION,
                        WGRoleActionFrequency.EVERY_NIGHT
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


            WGRole.CASSANDRA -> {
                actions.add(
                    WGRoleAction(
                        Res.string.cassandre_action,
                        Res.string.cassandre_action_desc,
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
