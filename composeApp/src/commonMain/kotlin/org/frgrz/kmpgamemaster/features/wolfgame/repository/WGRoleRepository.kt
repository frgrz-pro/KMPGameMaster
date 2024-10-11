package org.frgrz.kmpgamemaster.features.wolfgame.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.frgrz.kmpgamemaster.data.datasource.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.utils.RequestState

class WGRoleRepository(
    private val localDataSource: WGRoleLocalDataSource,
    private val mapper: WGRoleModelMapper,
) {

    fun getAllChecked(): Flow<RequestState<List<WGRoleModel>>> {
        return localDataSource.getAllChecked()
            .map { result ->
                RequestState.Success(
                    data = result.getSuccessData().map { mapper.map(it) }
                )
            }
    }
}