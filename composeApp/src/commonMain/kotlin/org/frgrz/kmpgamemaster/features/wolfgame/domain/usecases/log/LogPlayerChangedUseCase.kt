package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log

import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.LogEntry


class LogPlayerChangedUseCase(
    private val repository: GameLogRepository,
) {

    fun logPlayerAdded(player: String) {
        repository.log(LogEntry("Player added: $player", LogEntry.Type.ADD_PLAYER))
    }

    fun logPlayerRemoved(player: String) {
        repository.log(LogEntry("Player removed: $player", LogEntry.Type.REMOVE_PLAYER))
    }

}
