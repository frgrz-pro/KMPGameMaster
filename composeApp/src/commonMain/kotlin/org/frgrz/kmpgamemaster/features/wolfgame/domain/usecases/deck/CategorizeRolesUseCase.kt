package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck.RoleCategories
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck.RoleDeck

class CategorizeRolesUseCase {
    operator fun invoke(roles: List<WGRole>): RoleCategories {
        val (wolves, remaining) = roles.partition { it.isWolf() }
        val (villagers, remaining2) = remaining.partition { it.isVillager() }
        val (solos, notPlayed) = remaining2.partition { it.isSolo() }
        val notPlayedFinal = notPlayed.filter { it == WGRole.MAYOR }

        return RoleCategories(wolves, villagers, solos, notPlayedFinal)
    }
}
