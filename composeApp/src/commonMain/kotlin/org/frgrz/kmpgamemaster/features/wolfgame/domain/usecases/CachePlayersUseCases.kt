package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository


class CachePlayersUseCase(private val repository: WGRoleRepository) {

    fun invoke(players:List<String>) {
        repository.cachePlayerConfiguration(players)

    }
}

class GetCachedPlayersUseCase(private val repository: WGRoleRepository) {

    fun invoke(): StateFlow<List<String>> {
        return repository.getCachePlayerConfiguration()
    }

}