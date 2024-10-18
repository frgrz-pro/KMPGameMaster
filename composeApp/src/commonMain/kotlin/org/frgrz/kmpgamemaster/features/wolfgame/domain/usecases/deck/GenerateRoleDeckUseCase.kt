package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleDeck
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.LogRoleDeckUseCase


class GenerateRoleDeckUseCase(
    private val verifyRoleCompatibilityUseCase: VerifyRoleCompatibilityUseCase,
    private val categorizeRolesUseCase: GetRoleCategoriesUseCase,
    private val mapRolesToViewModelUseCase: MapRoleViewModelUseCase,
    private val selectWolvesUseCase: GetWolfRolesUseCase,
    private val selectSoloUseCase: GetSoloRolesUseCase,
    private val selectVillagersUseCase: GetVillagerRolesUseCase,
    private val selectExtraRolesUseCase: GetExtraRolesUseCase,
    private val logger: LogRoleDeckUseCase
) {

    private var config: GameConfiguration = GameConfiguration()

    fun setGameConfiguration(gameConfiguration: GameConfiguration) {
        config = gameConfiguration
        config.roles = verifyRoleCompatibilityUseCase(config)
        config.roleCategories = categorizeRolesUseCase(config)
    }

    fun generateRoleDeck(): RoleDeck {
        val selectedRoles = mutableListOf<WGRole>()

        selectedRoles.addAll(selectWolvesUseCase(config))

        val solo = selectSoloUseCase(config)
        solo?.let { selectedRoles.add(it) }

        selectedRoles.addAll(
            selectVillagersUseCase(
                config,
                selectedRoles.any { it.isWolfAndAddsWolf() }),
        )

        val extraRoles = mutableListOf<WGRole>()
        if (selectedRoles.any { it.isExtraRole() }) {
            val rolesWithExtra = selectedRoles.first { it.isExtraRole() }
            extraRoles.addAll(
                selectExtraRolesUseCase(
                    config,
                    selectedRoles.any { it.isWolfAndAddsWolf() },
                    rolesWithExtra,
                    selectedRoles
                )
            )
        }

        val deck = RoleDeck(
            mapRolesToViewModelUseCase(selectedRoles.shuffled()),
            mapRolesToViewModelUseCase(extraRoles)
        )

        logger.log(deck)

        return deck
    }
}
