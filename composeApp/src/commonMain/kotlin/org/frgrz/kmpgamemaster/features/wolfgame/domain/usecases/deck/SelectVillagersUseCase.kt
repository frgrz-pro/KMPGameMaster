package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleCategories
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules


class SelectVillagersUseCase {
    operator fun invoke(config: GameConfiguration, hasHiddenWolf:Boolean): List<WGRole> {
        val result = mutableListOf<WGRole>()
        repeat(config.villagersCount) {
            result.add(
                if (result.none { it == WGRole.PEASANT }) {
                    WGRole.PEASANT
                } else {
                    drawRandom(
                        if (canAddHiddenWolf(
                                config.playersCount,
                                config.wolvesCount,
                            result,
                            hasHiddenWolf
                            )
                        ) {
                            config.roleCategories.villagers.filterNot {
                                it in result
                            }
                        } else {
                            config.roleCategories.villagers.filterNot {
                                it.isVillagerAndAddsWolf() && it in result
                            }
                        },result
                    )
                }
            )
        }

        return result

    }

    private fun canAddHiddenWolf(
        playersCount: Int,
        wolvesCount: Int,
        selectedRoles: List<WGRole>,
        hasHiddenWolf: Boolean
    ): Boolean {
        val canAddWolves = WGRules.canAddWolves(playersCount, wolvesCount)
        val hasHiddenWolves =
            selectedRoles.any { it.isVillagerAndAddsWolf() }
        return canAddWolves && !hasHiddenWolves && !hasHiddenWolf
    }

    private fun drawRandom(set: List<WGRole>, selectedRoles: List<WGRole>): WGRole {
        return set.filterNot { it in selectedRoles }.random()
    }
}
