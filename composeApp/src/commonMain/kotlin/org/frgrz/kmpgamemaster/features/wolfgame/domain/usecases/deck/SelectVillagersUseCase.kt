package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules


class SelectVillagersUseCase {
    operator fun invoke(config: GameConfiguration, hasHiddenWolf: Boolean): List<WGRole> {
        val result = mutableListOf<WGRole>()
        repeat(config.villagersCount) {
            result.add(
                if (result.count { it == WGRole.PEASANT } < config.peasantCount) {
                    WGRole.PEASANT
                } else {
                    val hasExtraRoleCharacter = result.any { it.isExtraRole() }
                    val hasHiddenWolves = result.any { it.isVillagerAndAddsWolf() } || hasHiddenWolf

                    drawRandom(
                        config.roleCategories.villagers,
                        config.playersCount,
                        config.wolvesCount,
                        hasHiddenWolves,
                        hasExtraRoleCharacter,
                        result
                    )
                }
            )
        }

        return result

    }

    private fun drawRandom(set: List<WGRole>, playersCount: Int, wolvesCount: Int, hasHiddenWolf: Boolean, hasExtraRoleCharacter: Boolean, selectedRoles: List<WGRole>): WGRole {
        val canAddWolves = WGRules.canAddWolves(playersCount, wolvesCount)

        var mySet = set
        mySet = mySet.filter { it !in selectedRoles }

        if(canAddWolves && !hasHiddenWolf) {
            mySet = mySet.filterNot { it.isVillagerAndAddsWolf() }
        }

        if(hasExtraRoleCharacter) {
            mySet = mySet.filterNot { it.isExtraRole() }
        }

        return mySet.random()

    }

}
