package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log

import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepository


class GetLogUseCase(
    private val repository: GameLogRepository,
) {
    fun getLog() = repository.getLog()
}
