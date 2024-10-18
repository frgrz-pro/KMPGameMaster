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

class CacheGameSettingsUseCase(
    private val repository: GameLogRepository,
) {
    fun logGameConfiguration(gameSettings: GameConfiguration) {
        val entry = LogEntry(
            "Game Configuration Saved: \n"
                    + "Players: ${gameSettings.playersCount}\n"
                    + "Wolves: ${gameSettings.wolvesCount}, ${gameSettings.roleCategories.wolves.joinToString (separator = ", "){ it.name }}\n"
                    + "Villagers: ${gameSettings.villagersCount} (Peasants: ${gameSettings.peasantCount}), ${gameSettings.roleCategories.villagers.joinToString (separator = ", "){ it.name }}\n"
                    + "Solos: ${gameSettings.soloCount}, ${gameSettings.roleCategories.solos.joinToString (separator = ", "){ it.name }}\n",

            LogEntry.Type.GAME_CONFIGURATION
        )

        repository.log(entry)
    }


}

class GetLogUseCase(
    private val repository: GameLogRepository,
) {
    fun getLog() = repository.getLog()
}