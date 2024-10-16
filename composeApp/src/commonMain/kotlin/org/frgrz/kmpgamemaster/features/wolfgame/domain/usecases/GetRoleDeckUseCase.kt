package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import org.frgrz.kmpgamemaster.core.removeAllFromAnotherList
import org.frgrz.kmpgamemaster.core.removeByFilter
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

class GetRoleDeckUseCase(
    private val mapper: WGRoleModelMapper,
) {

    private val roleDeck: MutableList<WGRole> = mutableListOf()

    private var gameRoles: List<WGRole> = listOf()
    private var wolvesRoles: List<WGRole> = listOf()
    private var villagersRoles: List<WGRole> = listOf()
    private var solosRoles: List<WGRole> = listOf()
    private var notPlayedRole: List<WGRole> = listOf()

    private var playersCount: Int = 0
    private var wolvesCount: Int = 0

    fun setRoles(roles: List<WGRole>, playersCount: Int, wolvesCount: Int) {
        this.playersCount = playersCount
        this.wolvesCount = wolvesCount
        gameRoles = verifyRoleCompatibility(roles)
        sliceRoles()
    }

    private fun verifyRoleCompatibility(roles: List<WGRole>): List<WGRole> {
        var correctedRoles = roles

        val rules = listOf(
            WhiteWolfCompatibilityRule(),
            GuruCompatibilityRule(),
            PiedPiperCompatibilityRule()
        )

        rules.forEach { rule ->
            correctedRoles = rule.verify(correctedRoles, wolvesCount, playersCount)
        }

        return correctedRoles
    }

    data class RoleDeck(
        val roles: List<WGRoleModel>,
        val extraRoles: List<WGRoleModel>,
    )

    fun drawRoles(): RoleDeck {
        drawWolves(wolvesCount)
        drawSolo()
        drawVillagers(playersCount - wolvesCount - 1) //TODO check solo count
        val extraRoles = drawExtraRoles()

        return RoleDeck(
            roleDeck.shuffled().map { mapper.map(it) },
            extraRoles.map { mapper.map(it) }
        )
    }

    private fun drawExtraRoles(): List<WGRole> {
        val extraRolesCount = if (roleDeck.contains(WGRole.THIEF)) {
            2
        } else if (roleDeck.contains(WGRole.COMEDIAN)) {
            3
        } else {
            0
        }

        val extraRoles = mutableListOf<WGRole>()
        var filteredVillagersRoles = villagersRoles.removeAllFromAnotherList(
            listOf(
                WGRole.THREE_BROTHERS,
                WGRole.DUELISTS,
                WGRole.TWO_SISTERS
            )
        )

        repeat(extraRolesCount) {
            val item = filteredVillagersRoles.random()
            extraRoles.add(item)
            filteredVillagersRoles = filteredVillagersRoles.removeByFilter { it == item }
        }

        return extraRoles.toList()
    }

    private fun drawWolves(count: Int) {
        repeat(count) { _ ->
            if (roleDeck.none { it == WGRole.WOLF }) {
                addRole(WGRole.WOLF, false)
            } else if (roleDeck.any { it != WGRole.WOLF }) {
                drawRole(wolvesRoles)
            } else {
                addRole(WGRole.WOLF, false)
            }
        }

    }

    private fun drawSolo() {
        drawRole(solosRoles)
    }

    private fun drawVillagers(count: Int) {
        repeat(count) { _ ->
            if (roleDeck.none { it == WGRole.PEASANT }) {
                addRole(WGRole.PEASANT)
            } else {
                drawRole(villagersRoles)
            }

        }
    }

    private fun addRole(role: WGRole, shouldRemove: Boolean = true) {
        roleDeck.add(role)
        if (shouldRemove) {
            wolvesRoles = wolvesRoles.removeByFilter { it == role }
            villagersRoles = villagersRoles.removeByFilter { it == role }
            solosRoles = solosRoles.removeByFilter { it == role }
        }
    }

    private fun drawRole(set: List<WGRole>) {
        val item = set.random()
        roleDeck.add(item)
        wolvesRoles = wolvesRoles.removeByFilter { it == item }
        villagersRoles = villagersRoles.removeByFilter { it == item }
        solosRoles = solosRoles.removeByFilter { it == item }
    }

    private fun sliceRoles() {
        var gameRolesCopy: List<WGRole> = gameRoles
        wolvesRoles = gameRolesCopy.filter { it.isWolf() }
        gameRolesCopy = gameRolesCopy.removeAllFromAnotherList(wolvesRoles)
        villagersRoles = gameRolesCopy.filter { it.isVillager() }
        gameRolesCopy = gameRolesCopy.removeAllFromAnotherList(villagersRoles)
        solosRoles = gameRolesCopy.filter { it.isSolo() }
        gameRolesCopy = gameRolesCopy.removeAllFromAnotherList(solosRoles)
        notPlayedRole = gameRolesCopy.filter { it == WGRole.MAYOR }
    }

}

interface RoleCompatibilityRule {
    fun verify(roles: List<WGRole>, wolvesCount: Int, playersCount: Int): List<WGRole>
}

class WhiteWolfCompatibilityRule : RoleCompatibilityRule {
    override fun verify(
        roles: List<WGRole>,
        wolvesCount: Int,
        playersCount: Int,
    ): List<WGRole> {
        var correctedRoles = roles
        if (wolvesCount < 3 && roles.contains(WGRole.WHITE_WOLF)) {
            correctedRoles = roles.removeByFilter { it == WGRole.WHITE_WOLF }
        }

        return correctedRoles
    }
}

class PiedPiperCompatibilityRule : RoleCompatibilityRule {
    override fun verify(
        roles: List<WGRole>,
        wolvesCount: Int,
        playersCount: Int,
    ): List<WGRole> {
        var correctedRoles = roles
        if (roles.contains(WGRole.PIED_PIPER) && playersCount < 12) {
            correctedRoles = roles.removeByFilter { it == WGRole.PIED_PIPER }
        }

        return correctedRoles
    }
}

class GuruCompatibilityRule : RoleCompatibilityRule {
    override fun verify(
        roles: List<WGRole>,
        wolvesCount: Int,
        playersCount: Int,
    ): List<WGRole> {
        var correctedRoles = roles
        if (roles.contains(WGRole.GURU) && playersCount >= 12) {
            correctedRoles = roles.removeByFilter { it == WGRole.GURU }
        }

        return correctedRoles
    }
}