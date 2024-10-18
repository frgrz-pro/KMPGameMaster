package org.frgrz.kmpgamemaster.features.wolfgame.domain.models.compatibility

import org.frgrz.kmpgamemaster.core.removeByFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

class PiedPiperCompatibilityRule : RoleCompatibilityRule {
    override fun verify(
        selectedRoles: List<WGRole>,
        wolvesCount: Int,
        playersCount: Int,
    ): List<WGRole> {
        var correctedRoles = selectedRoles
        if (selectedRoles.contains(WGRole.PIED_PIPER) && playersCount < MIN_PLAYERS_COUNT) {
            correctedRoles = selectedRoles.removeByFilter { it == WGRole.PIED_PIPER }
        }

        return correctedRoles
    }

    companion object {
        private const val MIN_PLAYERS_COUNT = 12
    }
}