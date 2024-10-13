package org.frgrz.kmpgamemaster.features.wolfgame.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.frgrz.kmpgamemaster.core.RequestState
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleFilterMapper
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

interface WGRoleRepository {

    fun getAllChecked(isChecked: Boolean): Flow<RequestState<List<WGRoleModel>>>

    fun getAllFiltered(filter: RoleFilter): Flow<RequestState<List<WGRoleModel>>>

}

class WGRoleRepositoryImpl(
    private val localDataSource: WGRoleLocalDataSource,
    private val mapper: WGRoleModelMapper,
    private val filterMapper: WGRoleFilterMapper,
) : WGRoleRepository {

    override fun getAllChecked(isChecked: Boolean): Flow<RequestState<List<WGRoleModel>>> {
        return localDataSource.getAllChecked(isChecked)
            .map { result ->
                RequestState.Success(
                    data = result.map {
                        mapper.map(it)
                    }
                )
            }
    }

    override fun getAllFiltered(filter: RoleFilter): Flow<RequestState<List<WGRoleModel>>> {
        val roles = filterMapper.map(filter)
        return localDataSource.getAllFiltered(roles)
            .map { result ->
                RequestState.Success(
                    data = result.map {
                        mapper.map(it)
                    }
                )
            }
    }
}
