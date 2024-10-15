package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository

class CachePlayersUseCase(private val repository: WGRoleRepository) {

    fun invoke(players:List<String>) {
        repository.cachePlayers(players)

    }

}