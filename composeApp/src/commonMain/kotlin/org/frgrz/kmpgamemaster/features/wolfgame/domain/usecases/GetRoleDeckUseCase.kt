package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import org.frgrz.kmpgamemaster.core.removeAllFromAnotherList
import org.frgrz.kmpgamemaster.core.removeByFilter
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel


data class RoleCategories(
    val wolves: List<WGRole> = listOf(),
    val villagers: List<WGRole> = listOf(),
    val solos: List<WGRole> = listOf(),
    val notPlayed: List<WGRole> = listOf(),
)

class CategorizeRolesUseCase {
    operator fun invoke(roles: List<WGRole>): RoleCategories {
        val (wolves, remaining) = roles.partition { it.isWolf() }
        val (villagers, remaining2) = remaining.partition { it.isVillager() }
        val (solos, notPlayed) = remaining2.partition { it.isSolo() }
        val notPlayedFinal = notPlayed.filter { it == WGRole.MAYOR }

        return RoleCategories(wolves, villagers, solos, notPlayedFinal)
    }
}

class MapRolesToViewModelUseCase(private val mapper: WGRoleModelMapper) {
    operator fun invoke(roles: List<WGRole>): List<WGRoleModel> {
        return roles.map { mapper.map(it) }
    }
}

data class RoleDeck(
    val roles: List<WGRoleModel>,
    val extraRoles: List<WGRoleModel>,
)


class GetRoleDeckUseCase(
    private val verifyRoleCompatibilityUseCase: VerifyRoleCompatibilityUseCase,
    private val categorizeRolesUseCase: CategorizeRolesUseCase,
    private val mapRolesToViewModelUseCase: MapRolesToViewModelUseCase,
) {

    private var roleDeck: List<WGRole> = listOf()
    private var categorizedRoles = RoleCategories()
    private var playersCount: Int = 0
    private var wolvesCount: Int = 0

    fun setRoles(roles: List<WGRole>, playersCount: Int, wolvesCount: Int) {
        this.playersCount = playersCount
        this.wolvesCount = wolvesCount
        val verifiedGameRoles = verifyRoleCompatibilityUseCase(roles, playersCount, wolvesCount)
        categorizedRoles = categorizeRolesUseCase(verifiedGameRoles)
    }

    fun buildDeck(): RoleDeck {
        roleDeck = buildList {
            addAll(drawWolves(wolvesCount))
            add(drawSolo())
            addAll(drawVillagers(playersCount - wolvesCount - 1)) //TODO check solo count
        }

        return RoleDeck(
            mapRolesToViewModelUseCase(roleDeck.shuffled()),
            mapRolesToViewModelUseCase(drawExtraRoles())
        )
    }

    private fun drawExtraRoles(): List<WGRole> {
        val extraRolesCount = when {
            roleDeck.contains(WGRole.THIEF) -> 2
            roleDeck.contains(WGRole.COMEDIAN) -> 3
            else -> 0
        }

        val result = mutableListOf<WGRole>()

        repeat(extraRolesCount) {
            result.add(
                drawRandom(
                    if (canAddHiddenWolf()) {
                        categorizedRoles.villagers.filterNot {
                            it.addsWolf()
                                    && it.isTeam()
                                    && it in roleDeck
                                    && it in result
                        }
                    } else {
                        categorizedRoles.villagers.filterNot {
                            it.isTeam()
                                    && it in roleDeck
                                    && it in result
                        }
                    }
                )
            )

        }

        return result
    }

    private fun canAddHiddenWolf(): Boolean {
        val canAddWolves = WGRules.canAddWolves(playersCount, wolvesCount)
        val hasHiddenWolves = categorizedRoles.villagers.any { it.addsWolf() }
        return canAddWolves && !hasHiddenWolves
    }

    private fun drawWolves(count: Int): List<WGRole> {
        val result = mutableListOf<WGRole>()

        repeat(count) {
            result.add(
                if (roleDeck.none { it == WGRole.WOLF }) {
                    WGRole.WOLF
                } else {
                    drawRandom(
                        if (canAddHiddenWolf()) {
                            categorizedRoles.wolves.filterNot {
                                it in result
                            }
                        } else {
                            categorizedRoles.wolves.filterNot {
                                it.addsWolf() && it in result
                            }
                        }
                    )
                }
            )
        }

        return result
    }

    private fun drawVillagers(count: Int): List<WGRole> {
        val result = mutableListOf<WGRole>()

        repeat(count) {
            result.add(
                if (roleDeck.none { it == WGRole.PEASANT }) {
                    WGRole.PEASANT
                } else {
                    drawRandom(
                        if (canAddHiddenWolf()) {
                            categorizedRoles.villagers.filterNot {
                                it in result
                            }
                        } else {
                            categorizedRoles.villagers.filterNot {
                                it.addsWolf() && it in result
                            }
                        }
                    )
                }
            )
        }

        return result
    }

    private fun drawSolo(): WGRole {
        return drawRandom(categorizedRoles.solos)
    }

    private fun drawRandom(set: List<WGRole>): WGRole {
        return set.filterNot { it in roleDeck }.random()
    }
}

class VerifyRoleCompatibilityUseCase {
    operator fun invoke(roles: List<WGRole>, wolvesCount: Int, playersCount: Int): List<WGRole> {
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

//Only one transform to wolf
//if Gentleman => cupidon