package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck.RoleCategories


class SelectSoloUseCase {
    operator fun invoke(roleCategories: RoleCategories, selectedRoles: List<WGRole>): WGRole {
        return drawRandom(roleCategories.solos, selectedRoles)
    }

    private fun drawRandom(set: List<WGRole>, selectedRoles: List<WGRole>): WGRole {
        return set.filterNot { it in selectedRoles }.random()
    }
}
