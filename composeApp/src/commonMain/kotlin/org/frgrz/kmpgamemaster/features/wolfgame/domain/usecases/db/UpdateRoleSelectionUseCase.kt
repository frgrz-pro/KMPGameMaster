package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.db

import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

class UpdateRoleSelectionUseCase(
    private val repository: WGRoleRepository,
) {
    fun invoke(role: WGRoleModel, isChecked: Boolean) {
        repository.updateRoleSelection(role, isChecked)
    }
}