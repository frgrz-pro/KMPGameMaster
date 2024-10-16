package org.frgrz.kmpgamemaster.features.wolfgame.domain.models

import org.frgrz.kmpgamemaster.core.removeByFilter

interface RoleCompatibilityRule {
    fun verify(selectedRoles: List<WGRole>, wolvesCount: Int, playersCount: Int): List<WGRole>
}

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
