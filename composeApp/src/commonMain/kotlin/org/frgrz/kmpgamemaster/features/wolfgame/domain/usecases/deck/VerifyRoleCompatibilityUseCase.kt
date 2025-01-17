package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.compatibility.GuruCompatibilityRule
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.compatibility.PiedPiperCompatibilityRule
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.compatibility.WhiteWolfCompatibilityRule


class VerifyRoleCompatibilityUseCase {

    operator fun invoke(config: GameConfiguration): List<WGRole> {
        var correctedRoles = config.roles

        val rules = listOf(
            WhiteWolfCompatibilityRule(),
            GuruCompatibilityRule(),
            PiedPiperCompatibilityRule()
        )

        rules.forEach { rule ->
            correctedRoles = rule.verify(
                correctedRoles,
                config.wolvesCount,
                config.playersCount
            )
        }

        return correctedRoles
    }
}
