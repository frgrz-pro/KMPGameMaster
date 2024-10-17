package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules


class SelectVillagersUseCase {
    operator fun invoke(config: GameConfiguration, hasHiddenWolf: Boolean): List<WGRole> {
        val result = mutableListOf<WGRole>()
       var availableRoles =  config.playersCount - config.wolvesCount - config.soloCount - result.size
        while (availableRoles>0) {
            result.add(
                if (result.count { it == WGRole.PEASANT } < config.peasantCount) {
                    WGRole.PEASANT
                } else {
                    val hasExtraRoleCharacter = result.any { it.isExtraRole() }
                    val hasHiddenWolves = result.any { it.isVillagerAndAddsWolf() } || hasHiddenWolf
                    val hasRoomForDuo = config.playersCount - config.wolvesCount - result.size >= 2
                    val hasRoomForTrio = config.playersCount - config.wolvesCount - result.size >= 3

                    val role = drawRandom(
                        config.roleCategories.villagers,
                        config.playersCount,
                        config.wolvesCount,
                        hasHiddenWolves,
                        hasExtraRoleCharacter,
                        hasRoomForDuo,
                        hasRoomForTrio,
                        result
                    )

                    if (role.isDuo()) {
                        result.add(role)
                    }
                    if (role.isTrio()) {
                        result.add(role)
                        result.add(role)
                    }

                    role
                }
            )

            availableRoles =  config.playersCount - config.wolvesCount - config.soloCount - result.size
        }

        return result

    }

    private fun drawRandom(
        set: List<WGRole>,
        playersCount: Int,
        wolvesCount: Int,
        hasHiddenWolf: Boolean,
        hasExtraRoleCharacter: Boolean,
        hasRoomForDuo: Boolean,
        hasRoomForTrio: Boolean,
        selectedRoles: List<WGRole>,
    ): WGRole {
        val canAddWolves = WGRules.canAddWolves(playersCount, wolvesCount)

        var mySet = set
        mySet = mySet.filter { it !in selectedRoles }

        if(!hasRoomForDuo) {
            mySet = mySet.filterNot { it.isDuo() }
        }

        if(!hasRoomForTrio) {
            mySet = mySet.filterNot { it.isTrio() }
        }

        if(selectedRoles.any { it.isTeam() }) {
            mySet = mySet.filterNot { it.isTeam() }
        }

        if (canAddWolves && !hasHiddenWolf) {
            mySet = mySet.filterNot { it.isVillagerAndAddsWolf() }
        }

        if (hasExtraRoleCharacter) {
            mySet = mySet.filterNot { it.isExtraRole() }
        }

        return if(mySet.isNotEmpty()) {
            mySet.random()
        } else {
            WGRole.PEASANT
        }

    }

}
