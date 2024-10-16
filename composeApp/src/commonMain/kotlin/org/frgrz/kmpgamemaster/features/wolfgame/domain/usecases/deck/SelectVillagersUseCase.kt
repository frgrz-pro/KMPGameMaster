package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck.RoleCategories

class SelectVillagersUseCase {
    operator fun invoke(
        villagersCount: Int,
        roleCategories: RoleCategories,
        selectedRoles: List<WGRole>,
        playersCount: Int,
        wolvesCount: Int
    ): List<WGRole> {
        val result = mutableListOf<WGRole>()
        repeat(villagersCount) {
            result.add(
                if (result.none { it == WGRole.PEASANT }) {
                    WGRole.PEASANT
                } else {
                    drawRandom(
                        result,
                        if (canAddHiddenWolf(playersCount,wolvesCount, roleCategories)) {
                            roleCategories.villagers.filterNot {
                                it in result
                            }
                        } else {
                            roleCategories.villagers.filterNot {
                                it.addsWolf() && it in result
                            }
                        }
                    )
                }
            )
        }

        return result

    }

    private fun canAddHiddenWolf(
        playersCount: Int,
        wolvesCount: Int,
        availableRoles: RoleCategories,
    ): Boolean {
        val canAddWolves = WGRules.canAddWolves(playersCount, wolvesCount)
        val hasHiddenWolves = availableRoles.villagers.any { it.addsWolf() } //TODO Ou il y a un transformer dans les loups
        return canAddWolves && !hasHiddenWolves
    }

    private fun drawRandom(set: List<WGRole>, selectedRoles: List<WGRole>): WGRole {
        return set.filterNot { it in selectedRoles }.random()
    }
}
