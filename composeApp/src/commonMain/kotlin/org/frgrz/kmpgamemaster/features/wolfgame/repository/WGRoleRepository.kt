package org.frgrz.kmpgamemaster.features.wolfgame.repository

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.features.wolfgame.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.utils.RequestState

class WGRoleRepository(
    private val localDataSource: WGRoleLocalDataSource,
) {

    fun getAllChecked(): Flow<RequestState<List<WGRoleModel>>> {
        return localDataSource.getAllChecked()
    }
}
