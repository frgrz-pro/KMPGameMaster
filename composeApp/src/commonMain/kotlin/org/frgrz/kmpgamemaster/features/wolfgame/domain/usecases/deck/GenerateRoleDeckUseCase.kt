package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck.RoleCategories
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.deck.RoleDeck


class GenerateRoleDeckUseCase(
    private val verifyRoleCompatibilityUseCase: VerifyRoleCompatibilityUseCase,
    private val categorizeRolesUseCase: CategorizeRolesUseCase,
    private val mapRolesToViewModelUseCase: MapRolesToViewModelUseCase,
    private val selectWolvesUseCase: SelectWolvesUseCase,
    private val selectSoloUseCase: SelectSoloUseCase,
    private val selectVillagersUseCase: SelectVillagersUseCase,
    private val selectExtraRolesUseCase: SelectExtraRolesUseCase
) {

    private var selectedRoles: List<WGRole> = listOf()
    private var availableRoles = RoleCategories()
    private var playersCount: Int = 0
    private var wolvesCount: Int = 0

    fun setRoles(roles: List<WGRole>, playersCount: Int, wolvesCount: Int) {
        this.playersCount = playersCount
        this.wolvesCount = wolvesCount
        val verifiedGameRoles = verifyRoleCompatibilityUseCase(roles, playersCount, wolvesCount)
        availableRoles = categorizeRolesUseCase(verifiedGameRoles)
    }

    fun generateRoleDeck(): RoleDeck {
        selectedRoles = buildList {
            addAll(selectWolvesUseCase(wolvesCount, availableRoles, playersCount))
            add(selectSoloUseCase(availableRoles, selectedRoles))
            addAll(
                selectVillagersUseCase(
                    playersCount - wolvesCount - 1,
                    availableRoles,
                    selectedRoles,
                    playersCount,
                    wolvesCount
                )
            ) //TODO check solo count
        }

        return RoleDeck(
            mapRolesToViewModelUseCase(selectedRoles.shuffled()),
            mapRolesToViewModelUseCase(selectExtraRolesUseCase(selectedRoles, availableRoles))
        )
    }
}
