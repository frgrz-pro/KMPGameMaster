package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel


class GetRoleSelectionUseCase(
    private val repository: WGRoleRepository
) {
    fun invoke(isChecked: Boolean): Flow<List<WGRoleModel>> {
        return repository.getAllChecked(isChecked)
    }
}


class GetRolesForFilterUseCase(
    private val repository: WGRoleRepository,
) {

    fun invoke(filter: RoleFilter): Flow<List<WGRoleModel>> {
        val flow = if (filter == RoleFilter.SELECTED || filter == RoleFilter.UNSELECTED) {
            repository.getAllChecked(filter == RoleFilter.SELECTED)
        } else {
            repository.getAllFiltered(filter)
        }

        return flow
    }
}


class UpdateRoleSelectionUseCase(
    private val repository: WGRoleRepository,
) {
    fun invoke(role: WGRoleModel, isChecked: Boolean) {
        repository.updateRoleSelection(role, isChecked)
    }
}