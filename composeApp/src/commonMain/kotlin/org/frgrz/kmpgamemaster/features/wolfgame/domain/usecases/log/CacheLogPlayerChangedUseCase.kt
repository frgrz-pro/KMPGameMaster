package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log

import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.LogEntry
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleDeck
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

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

class LogRoleDeckUseCase(private val repository: GameLogRepository) {
    fun log(deck: RoleDeck) {
        val wolves = deck.roles.filter { it.role.isWolf() }
        val villagers = deck.roles.filter { it.role.isVillager() && !it.role.isTeam() }
        val solos = deck.roles.filter { it.role.isSolo() }
        val addsWolves =
            deck.roles.filter { it.role.isVillagerAndAddsWolf() || it.role.isWolfAndAddsWolf() }
        val teamsters = deck.roles.filter { it.role.isTeam() }

        val line1 = "\nWolves (${wolves.size}) :${wolves.joinToString(", ") { it.role.name }}"
        val line2 = "\nSolos (${solos.size}) :${solos.joinToString(", ") { it.role.name }}"
        val line3 = "\nTeamsters (${teamsters.size}) :${teamsters.firstOrNull()?.role?.name ?: ""}"
        val line4 =
            "\nVillagers (${villagers.size}) :${villagers.joinToString(", ") { it.role.name }}"
        val line5 =
            "\nRoles adding a wolf (${addsWolves.size}) :${addsWolves.joinToString(", ") { it.role.name }}"
        val line6 =
            "\nExtra roles (${deck.extraRoles.size}) :${deck.extraRoles.joinToString(", ") { it.role.name }}"
        val sb = StringBuilder()
        sb.append("Role Deck Created:\n")
        sb.append(line1)
        if (solos.isNotEmpty()) sb.append(line2)
        if (teamsters.isNotEmpty()) sb.append(line3)
        sb.append(line4)
        if (addsWolves.isNotEmpty()) sb.append(line5)
        if (deck.extraRoles.isNotEmpty()) sb.append(line6)

        val entry = LogEntry(
            sb.toString(),
            LogEntry.Type.ROLE_DECK
        )

        repository.log(entry)
    }
}

class LogRoleAssignedUseCase(private val repository: GameLogRepository) {
    fun log(player: String, role: WGRole) {
        val entry = LogEntry("$player was assigned the role: ${role.name}", LogEntry.Type.ROLE_ASSIGNED)
        repository.log(entry)
    }
}


class GetLogUseCase(
    private val repository: GameLogRepository,
) {
    fun getLog() = repository.getLog()
}