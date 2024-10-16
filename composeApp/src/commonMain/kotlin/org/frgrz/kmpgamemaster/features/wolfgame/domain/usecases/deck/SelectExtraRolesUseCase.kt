package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck.RoleCategories


class SelectExtraRolesUseCase {
    operator fun invoke(selectedRoles: List<WGRole>, roleCategories: RoleCategories): List<WGRole> {
        val extraRolesCount = when {
            selectedRoles.contains(WGRole.THIEF) -> 2
            selectedRoles.contains(WGRole.COMEDIAN) -> 3
            else -> 0
        }

        val result = mutableListOf<WGRole>()

        repeat(extraRolesCount) {
            result.add(
                drawRandom(
                    selectedRoles,
                    roleCategories.villagers.filterNot {
                        (it.addsWolf() || it.isTeam()) && it in result
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