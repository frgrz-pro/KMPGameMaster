package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GuruCompatibilityRule
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.PiedPiperCompatibilityRule
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WhiteWolfCompatibilityRule

class VerifyRoleCompatibilityUseCase {
    operator fun invoke(roles: List<WGRole>, wolvesCount: Int, playersCount: Int): List<WGRole> {
        var correctedRoles = roles

        val rules = listOf(
            WhiteWolfCompatibilityRule(),
            GuruCompatibilityRule(),
            PiedPiperCompatibilityRule()
        )

        rules.forEach { rule ->
            correctedRoles = rule.verify(correctedRoles, wolvesCount, playersCount)
        }

        return correctedRoles
    }
}

