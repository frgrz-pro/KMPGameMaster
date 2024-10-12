package org.frgrz.kmpgamemaster.features.wolfgame.repository

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.features.wolfgame.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.utils.RequestState

class WGRoleRepository(
    private val localDataSource: WGRoleLocalDataSource,
) {

    fun getAllChecked(isChecked:Boolean): Flow<RequestState<List<WGRoleModel>>> {
        return localDataSource.getAllChecked(isChecked)
    }

    fun getAllFiltered(filter: RoleFilter): Flow<RequestState<List<WGRoleModel>>> {
        return localDataSource.getAllFiltered(filter)
    }

}
