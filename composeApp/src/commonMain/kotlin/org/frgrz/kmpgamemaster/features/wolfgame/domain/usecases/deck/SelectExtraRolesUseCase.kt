package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules


class SelectExtraRolesUseCase {

    operator fun invoke(
        config: GameConfiguration,
        hasHiddenWolf: Boolean,
        extraRole: WGRole,
        selectedRoles: List<WGRole>
    ): List<WGRole> {
        val extraRolesCount = when (extraRole) {
            WGRole.THIEF -> 2
            WGRole.COMEDIAN -> 3
            else -> 0
        }

        val result = mutableListOf<WGRole>()

        repeat(extraRolesCount) {
            val hasHiddenWolves = result.any { it.isVillagerAndAddsWolf() } || hasHiddenWolf

            result.add(
                drawRandom(
                    config.roleCategories.villagers,
                    config.playersCount,
                    config.wolvesCount,
                    hasHiddenWolves,
                    result,
                    selectedRoles
                )
            )
        }

        return result
    }

    private fun drawRandom(
        set: List<WGRole>,
        playersCount: Int,
        wolvesCount: Int,
        hasHiddenWolf: Boolean,
        extraRoles: List<WGRole>,
        selectedRoles: List<WGRole>,
    ): WGRole {
        val canAddWolves = WGRules.canAddWolves(playersCount, wolvesCount)

        var mySet = set
        mySet = mySet.filterNot { it in extraRoles }

        mySet = mySet.filterNot { it in selectedRoles }

        if (canAddWolves && !hasHiddenWolf) {
            mySet = mySet.filterNot { it.isVillagerAndAddsWolf() }
        }

        mySet = mySet.filterNot { it.isExtraRole() }
        mySet = mySet.filterNot { it == WGRole.PEASANT }

        return mySet.random()

    }
}


