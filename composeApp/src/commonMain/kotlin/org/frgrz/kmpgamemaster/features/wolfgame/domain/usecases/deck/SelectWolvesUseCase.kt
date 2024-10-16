package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck.RoleCategories

class SelectWolvesUseCase {
    operator fun invoke(
        wolvesCount: Int,
        roleCategories: RoleCategories,
        playersCount: Int,
    ): List<WGRole> {
        val result = mutableListOf<WGRole>()
        repeat(wolvesCount) {
            result.add(
                if (result.none { it == WGRole.WOLF }) {
                    WGRole.WOLF
                } else {
                    drawRandom(
                        result,
                        if (canAddHiddenWolf(roleCategories, wolvesCount, playersCount)) {
                            roleCategories.wolves.filterNot { it in result }
                        } else {
                            roleCategories.wolves.filterNot { it.addsWolf() && it in result } //TODO What if filter returns empty ?
                        }
                    )
                }
            )
        }
        return result
    }

    private fun canAddHiddenWolf(
        roleCategories: RoleCategories,
        wolvesCount: Int,
        playersCount: Int,
    ): Boolean {
        val canAddWolves =
            WGRules.canAddWolves(playersCount, wolvesCount) // Assuming playersCount is accessible
        val hasHiddenWolves = roleCategories.villagers.any { it.addsWolf() }
        return canAddWolves && !hasHiddenWolves
    }

    private fun drawRandom(selectedRoles: List<WGRole>, set: List<WGRole>): WGRole {
        return set.filterNot { it in selectedRoles }.random()
    }
}