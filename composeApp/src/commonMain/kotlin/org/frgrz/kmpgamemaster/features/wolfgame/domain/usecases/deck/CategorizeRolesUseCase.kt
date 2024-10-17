package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleCategories
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole


class CategorizeRolesUseCase {
    operator fun invoke(config: GameConfiguration): RoleCategories {
        val (wolves, remaining) = config.roles.partition { it.isWolf() }
        val (villagers, remaining2) = remaining.partition { it.isVillager() }
        val (solos, notPlayed) = remaining2.partition { it.isSolo() }
        val notPlayedFinal = notPlayed.filter { it == WGRole.MAYOR }

        return RoleCategories(wolves, villagers, solos, notPlayedFinal)
    }
}
