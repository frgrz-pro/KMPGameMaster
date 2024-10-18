package org.frgrz.kmpgamemaster.features.wolfgame.domain.models.compatibility

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

interface RoleCompatibilityRule {
    fun verify(selectedRoles: List<WGRole>, wolvesCount: Int, playersCount: Int): List<WGRole>
}





