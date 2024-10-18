package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log

import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.LogEntry
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleDeck


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
