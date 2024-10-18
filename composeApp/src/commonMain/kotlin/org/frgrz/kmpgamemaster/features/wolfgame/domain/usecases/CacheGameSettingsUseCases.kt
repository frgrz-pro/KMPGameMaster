package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.CacheGameSettingsUseCase


class CacheGameConfigurationUseCase(
    private val repository: WGRoleRepository
) {

    fun invoke(roles: List<WGRoleModel>, wolvesCount: Int, peasantCount:Int) {
        repository.cacheRoleConfiguration(roles.map { it.role }, wolvesCount, peasantCount)
    }
}

class GetGameConfigurationUseCase(private val repository: WGRoleRepository) {

    fun invoke(): StateFlow<GameConfiguration> {
        return repository.getCacheGameConfiguration()
    }
}