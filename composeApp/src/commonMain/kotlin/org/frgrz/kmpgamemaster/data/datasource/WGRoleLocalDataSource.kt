package org.frgrz.kmpgamemaster.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.data.mappers.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.utils.RequestState

class WGRoleLocalDataSourceImpl(
    private val dao: WGRoleDao,
    private val mapper: WGRoleModelMapper,
) : WGRoleLocalDataSource {

    override fun getAllChecked(): Flow<RequestState<List<WGRoleModel>>> {
        return dao.all()
            .map { result ->
                RequestState.Success(
                    data = result.sortedByDescending { task -> task.selected }
                        .map { mapper.map(it) }
                )
            }
    }
}

