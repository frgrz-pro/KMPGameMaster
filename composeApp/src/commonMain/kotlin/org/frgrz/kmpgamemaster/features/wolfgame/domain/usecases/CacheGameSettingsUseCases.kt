package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration


class CacheGameConfigurationUseCase(
    private val repository: WGRoleRepository,
    private val getRoleSelectionUseCase: GetRoleSelectionUseCase,

    ) {

    fun invoke(wolvesCount: Int, peasantCount: Int) {
        val roles = getRoleSelectionUseCase.invoke(true)
        repository.cacheRoleConfiguration(roles.map { it.role }, wolvesCount, peasantCount)
    }
}

class GetGameConfigurationUseCase(private val repository: WGRoleRepository) {

    fun invoke(): StateFlow<GameConfiguration> {
        return repository.getCacheGameConfiguration()
    }
}