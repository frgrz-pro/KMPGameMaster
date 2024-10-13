package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.core.RequestState
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

class GetSelectedRolesUseCase(
    private val repository: WGRoleRepository
) {
    fun getAllChecked(isChecked: Boolean): Flow<RequestState<List<WGRoleModel>>> {
        return repository.getAllChecked(isChecked)
    }
}