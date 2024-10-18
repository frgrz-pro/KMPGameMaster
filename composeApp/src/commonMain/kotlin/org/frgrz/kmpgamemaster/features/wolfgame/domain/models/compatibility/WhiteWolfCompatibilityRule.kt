package org.frgrz.kmpgamemaster.features.wolfgame.domain.models.compatibility

import org.frgrz.kmpgamemaster.core.removeByFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole


class WhiteWolfCompatibilityRule : RoleCompatibilityRule {
    override fun verify(
        selectedRoles: List<WGRole>,
        wolvesCount: Int,
        playersCount: Int,
    ): List<WGRole> {
        var correctedRoles = selectedRoles
        if (wolvesCount < MIN_WOLVES && selectedRoles.contains(WGRole.WHITE_WOLF)) {
            correctedRoles = selectedRoles.removeByFilter { it == WGRole.WHITE_WOLF }
        }

        return correctedRoles
    }

    companion object {
        private const val MIN_WOLVES = 3
    }
}