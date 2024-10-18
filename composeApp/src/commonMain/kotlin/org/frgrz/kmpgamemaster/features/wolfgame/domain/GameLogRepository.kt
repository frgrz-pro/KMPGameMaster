package org.frgrz.kmpgamemaster.features.wolfgame.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameLogCache {

    private val log = MutableStateFlow(mutableListOf<LogEntry>())
    val gameLog: StateFlow<MutableList<LogEntry>> = log.asStateFlow()

    fun log(entry: LogEntry) {
        log.value.add(entry)
    }

    fun clear() {
        log.value.clear()
    }
}

data class LogEntry(
    val text: String,
    val type: Type,
) {

    enum class Type {
        ADD_PLAYER,
        REMOVE_PLAYER,
        GAME_CONFIGURATION,
        ROLE_DECK,
        ROLE_ASSIGNED
    }
}

interface GameLogRepository {
    fun getLog(): StateFlow<MutableList<LogEntry>>
    fun log(logEntry: LogEntry)
    fun clearLog()
}

class GameLogRepositoryImpl(
    private val cache: GameLogCache,
) : GameLogRepository {

    override fun getLog(): StateFlow<MutableList<LogEntry>> {
        return cache.gameLog
    }

    override fun log(logEntry: LogEntry) {
        cache.log(logEntry)
    }

    override fun clearLog() {
        cache.clear()
    }
}
