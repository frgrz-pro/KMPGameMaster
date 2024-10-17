package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleCategories
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules


class SelectWolvesUseCase {

    operator fun invoke(config: GameConfiguration): List<WGRole> {

        val result = mutableListOf<WGRole>()
        repeat(config.wolvesCount) {
            result.add(
                if (result.none { it == WGRole.WOLF }) {
                    WGRole.WOLF
                } else {
                    drawRandom(
                        result,
                        if (canAddHiddenWolf(
                                result,
                                config.wolvesCount,
                                config.playersCount
                            )
                        ) {
                            config.roleCategories.wolves.filterNot { it in result }
                        } else {
                            config.roleCategories.wolves.filterNot { it.isWolfAndAddsWolf() && it in result } //TODO What if filter returns empty ?
                        }
                    )
                }
            )
        }
        return result
    }

    private fun canAddHiddenWolf(
        drawnWolves: List<WGRole>,
        wolvesCount: Int,
        playersCount: Int,
    ): Boolean {
        val canAddWolves =
            WGRules.canAddWolves(playersCount, wolvesCount) // Assuming playersCount is accessible
        val hasHiddenWolves = drawnWolves.any { it.isWolfAndAddsWolf() }
        return canAddWolves && !hasHiddenWolves
    }

    private fun drawRandom(selectedRoles: List<WGRole>, set: List<WGRole>): WGRole {
        return set.filterNot { it in selectedRoles }.random()
    }
}