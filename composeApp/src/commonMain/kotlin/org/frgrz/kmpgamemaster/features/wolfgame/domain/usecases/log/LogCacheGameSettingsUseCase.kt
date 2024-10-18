package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log

import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.LogEntry
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration


class LogCacheGameSettingsUseCase(
    private val repository: GameLogRepository,
) {

    fun log(gameSettings: GameConfiguration) {
        val entry = LogEntry(
            "Game Configuration Saved: \n\n"
                    + "Players: ${gameSettings.playersCount}\n"
                    + "\nWolves: ${gameSettings.wolvesCount}\n${
                gameSettings.roleCategories.wolves.joinToString(
                    separator = ", "
                ) { it.name }
            }\n"
                    + "\nVillagers: ${gameSettings.villagersCount} (Peasants: ${gameSettings.peasantCount})\n${
                gameSettings.roleCategories.villagers.joinToString(
                    separator = ", "
                ) { it.name }
            }\n"
                    + "\nSolos: ${gameSettings.soloCount}\n${
                gameSettings.roleCategories.solos.joinToString(
                    separator = ", "
                ) { it.name }
            }\n",

            LogEntry.Type.GAME_CONFIGURATION
        )

        repository.log(entry)
    }
}
