package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole


class SelectSoloUseCase {
    operator fun invoke(config: GameConfiguration): WGRole? {
        if (config.soloCount == 0) {
            return null
        }

        return drawRandom(config.roleCategories.solos, config.roles)
    }

    private fun drawRandom(set: List<WGRole>, selectedRoles: List<WGRole>): WGRole {
        return set.random()
    }
}
