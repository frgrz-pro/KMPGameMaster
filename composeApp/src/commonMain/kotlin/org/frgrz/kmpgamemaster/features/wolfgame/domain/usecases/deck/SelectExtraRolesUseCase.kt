package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole


class SelectExtraRolesUseCase {
    operator fun invoke(config: GameConfiguration): List<WGRole> {
        val extraRolesCount = when {
            config.roles.contains(WGRole.THIEF) -> 2
            config.roles.contains(WGRole.COMEDIAN) -> 3
            else -> 0
        }

        val result = mutableListOf<WGRole>()

        repeat(extraRolesCount) {
            result.add(
                drawRandom(
                    config.roles,
                    config.roleCategories.villagers.filterNot {
                        (it.isVillagerAndAddsWolf() || it.isTeam()) && it in result
                    }
                )
            )
        }

        return result
    }

    private fun drawRandom(set: List<WGRole>, selectedRoles: List<WGRole>): WGRole {
        return set.filterNot { it in selectedRoles }.random()
    }
}