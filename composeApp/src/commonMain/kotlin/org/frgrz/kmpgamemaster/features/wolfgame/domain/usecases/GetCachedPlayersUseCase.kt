package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository

class GetCachedPlayersUseCase(private val repository: WGRoleRepository) {

    fun invoke(): StateFlow<List<String>> {
       return repository.readCachePlayers()
    }

}