package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers.RoleCardViewModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers.RoleThumbnailViewModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleCardViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleThumbnailViewModel


class GetRoleThumbnailsSelectionUseCase(
    private val repository: WGRoleRepository,
    private val thumbnailViewModelMapper: RoleThumbnailViewModelMapper
) {
    fun invoke(isChecked: Boolean): Flow<List<RoleThumbnailViewModel>> {
        return repository.getAllCheckedAsFlow(isChecked)
            .map { it.map { role -> thumbnailViewModelMapper.map(role.role) } }
    }
}

class GetRoleSelectionUseCase(
    private val repository: WGRoleRepository
) {
    fun invoke(isChecked: Boolean): List<WGRoleModel> {
        return repository.getAllChecked(isChecked)
    }
}


class GetRolesForFilterUseCase(
    private val repository: WGRoleRepository,
    private val roleCardViewModelMapper: RoleCardViewModelMapper
) {

    fun invoke(filter: RoleFilter): Flow<List<RoleCardViewModel>> {
        val flow = if (filter == RoleFilter.SELECTED || filter == RoleFilter.UNSELECTED) {
            repository.getAllCheckedAsFlow(filter == RoleFilter.SELECTED)
        } else {
            repository.getAllFiltered(filter)
        }

        return flow.map { roles ->
            roles.map { role ->
                roleCardViewModelMapper.map(role)
            }
        }
    }
}


class UpdateRoleSelectionUseCase(
    private val repository: WGRoleRepository,
) {
    fun invoke(role: WGRole, isChecked: Boolean) {
        repository.updateRoleSelection(role, isChecked)
    }
}