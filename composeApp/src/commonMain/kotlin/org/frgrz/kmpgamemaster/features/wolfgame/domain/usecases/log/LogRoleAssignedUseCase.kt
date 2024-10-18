package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log

import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.LogEntry
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole


class LogRoleAssignedUseCase(private val repository: GameLogRepository) {

    fun log(player: String, role: WGRole) {
        val entry = LogEntry("$player was assigned the role: ${role.name}", LogEntry.Type.ROLE_ASSIGNED)
        repository.log(entry)
    }
}
