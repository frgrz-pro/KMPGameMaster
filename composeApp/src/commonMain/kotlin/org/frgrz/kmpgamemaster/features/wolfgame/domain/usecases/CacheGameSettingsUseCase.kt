package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

class CacheGameSettingsUseCase(private val repository: WGRoleRepository) {

    fun invoke(roles: List<WGRoleModel>, wolvesCount: Int) {
        repository.saveGameSettings(roles.map { it.role }, wolvesCount)
    }
}

class GetGameSettingsUseCase(private val repository: WGRoleRepository) {

    fun invoke() {
        repository.getGameSettings()
    }
}