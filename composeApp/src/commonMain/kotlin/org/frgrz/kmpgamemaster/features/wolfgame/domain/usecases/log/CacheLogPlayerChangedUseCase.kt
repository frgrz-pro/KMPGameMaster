package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log

import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.LogEntry
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration

class CacheLogPlayerChangedUseCase(
    private val repository: GameLogRepository,
) {
    fun logPlayerAdded(player: String) {
        repository.log(LogEntry("Player added: $player", LogEntry.Type.ADD_PLAYER))
    }

    fun logPlayerRemoved(player: String) {
        repository.log(LogEntry("Player removed: $player", LogEntry.Type.REMOVE_PLAYER))
    }

}

class LogCacheGameSettingsUseCase(
    private val repository: GameLogRepository,
) {
    fun logGameConfiguration(gameSettings: GameConfiguration) {
        val entry = LogEntry(
            "Game Configuration Saved: \n"
                    + "Players: ${gameSettings.playersCount}\n"
                    + "\nWolves: ${gameSettings.wolvesCount}\n${gameSettings.roleCategories.wolves.joinToString (separator = ", "){ it.name }}\n"
                    + "\nVillagers: ${gameSettings.villagersCount} (Peasants: ${gameSettings.peasantCount})\n${gameSettings.roleCategories.villagers.joinToString (separator = ", "){ it.name }}\n"
                    + "\nSolos: ${gameSettings.soloCount}\n${gameSettings.roleCategories.solos.joinToString (separator = ", "){ it.name }}\n",

            LogEntry.Type.GAME_CONFIGURATION
        )

        repository.log(entry)
    }
}

class RoleDeckSelectionUseCase(

)

class GetLogUseCase(
    private val repository: GameLogRepository,
) {
    fun getLog() = repository.getLog()
}