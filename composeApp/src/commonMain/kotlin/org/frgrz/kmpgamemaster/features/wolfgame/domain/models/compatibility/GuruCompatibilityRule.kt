package org.frgrz.kmpgamemaster.features.wolfgame.domain.models.compatibility

import org.frgrz.kmpgamemaster.core.removeByFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole


class GuruCompatibilityRule : RoleCompatibilityRule {
    override fun verify(
        selectedRoles: List<WGRole>,
        wolvesCount: Int,
        playersCount: Int,
    ): List<WGRole> {
        var correctedRoles = selectedRoles
        if (selectedRoles.contains(WGRole.GURU) && playersCount >= MAX_PLAYERS_COUNT) {
            correctedRoles = selectedRoles.removeByFilter { it == WGRole.GURU }
        }

        return correctedRoles
    }

    companion object {
        private const val MAX_PLAYERS_COUNT = 12
    }
}
