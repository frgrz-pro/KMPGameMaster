package org.frgrz.kmpgamemaster.data.datasource

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity
import org.frgrz.kmpgamemaster.utils.RequestState

class WGRoleLocalDataSource(private val dao: WGRoleDao) {

    fun getAllChecked(): Flow<RequestState<List<WGRoleEntity>>> {
        return dao.all()
            .map { result ->
                RequestState.Success(
                    data = result.sortedByDescending { task -> task.selected }
                )
            }
    }
}