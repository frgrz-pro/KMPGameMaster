package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import org.frgrz.kmpgamemaster.core.removeAllFromAnotherList
import org.frgrz.kmpgamemaster.core.removeByFilter
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

class GetRoleDeckUseCase(
    private val mapper: WGRoleModelMapper
) {

    private var gameRoles: List<WGRole> = listOf()
    private var wolvesRoles: List<WGRole> = listOf()
    private var villagersRoles: List<WGRole> = listOf()
    private var solosRoles: List<WGRole> = listOf()
    private var notPlayedRole: List<WGRole> = listOf()
    private val selectedRoles: MutableList<WGRole> = mutableListOf()

    fun setRoles(roles: List<WGRole>) {
        gameRoles = roles
        sliceRoles()
    }

    fun drawRoles(playersCount: Int, wolvesCount: Int): List<WGRoleModel> {
        var remainingWolves = wolvesCount
        addRole(WGRole.WOLF, false)

        remainingWolves--
        if (remainingWolves > 0) {
            drawRoles(wolvesRoles, remainingWolves)
        }

        addRole(WGRole.PEASANT)
        drawRoles(solosRoles, 1)

        val remainingVillagers = playersCount - selectedRoles.size
        drawRoles(villagersRoles, remainingVillagers)

        return selectedRoles.shuffled()
            .map { mapper.map(it) }
    }

    private fun addRole(role: WGRole, shouldRemove: Boolean = true) {
        selectedRoles.add(role)
        if (shouldRemove) {
            wolvesRoles = wolvesRoles.removeByFilter { it == role }
            villagersRoles = villagersRoles.removeByFilter { it == role }
            solosRoles = solosRoles.removeByFilter { it == role }
        }
    }

    private fun drawRoles(set: List<WGRole>, count: Int) {
        for (i in 0 until count) {
            val item = set.random()
            selectedRoles.add(item)
            wolvesRoles = wolvesRoles.removeByFilter { it == item }
            villagersRoles = villagersRoles.removeByFilter { it == item }
            solosRoles = solosRoles.removeByFilter { it == item }
        }
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