package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.db

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.core.RequestState
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel


class GetRolesForFilterUseCase(
    private val repository: WGRoleRepository,
) {

    fun invoke(filter: RoleFilter): Flow<RequestState<List<WGRoleModel>>> {
        val flow = if (filter == RoleFilter.SELECTED || filter == RoleFilter.UNSELECTED) {
             repository.getAllChecked(filter == RoleFilter.SELECTED)
        } else {
            repository.getAllFiltered(filter)
        }

        return flow
    }
}

