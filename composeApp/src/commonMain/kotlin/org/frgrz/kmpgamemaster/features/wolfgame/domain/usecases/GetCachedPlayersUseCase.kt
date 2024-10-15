package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository

class GetCachedPlayersUseCase(private val repository: WGRoleRepository) {

    fun invoke(): List<String> {
       return repository.readCachePlayers()
    }

}