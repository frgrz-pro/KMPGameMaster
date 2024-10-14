package org.frgrz.kmpgamemaster.features.wolfgame.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.frgrz.kmpgamemaster.core.RequestState
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleFilterMapper
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

interface WGRoleRepository {

    fun getAllChecked(isChecked: Boolean): Flow<RequestState<List<WGRoleModel>>>

    fun getAllFiltered(filter: RoleFilter): Flow<RequestState<List<WGRoleModel>>>

    fun updateRoleSelection(model: WGRoleModel, isChecked: Boolean)
}

class WGRoleRepositoryImpl(
    private val roleLocalDataSource: WGRoleLocalDataSource,
    private val roleModelMapper: WGRoleModelMapper,
    private val roleFilterMapper: WGRoleFilterMapper,
) : WGRoleRepository {

    override fun getAllChecked(isChecked: Boolean): Flow<RequestState<List<WGRoleModel>>> {
        return roleLocalDataSource.getAllChecked(isChecked)
            .map { result ->
                RequestState.Success(
                    data = result.map {
                        roleModelMapper.map(it)
                    }
                )
            }
    }

    override fun getAllFiltered(filter: RoleFilter): Flow<RequestState<List<WGRoleModel>>> {
        val roles = roleFilterMapper.map(filter)
        return roleLocalDataSource.getAllFiltered(roles)
            .map { result ->
                RequestState.Success(
                    data = result.map {
                        roleModelMapper.map(it)
                    }
                )
            }
    }

    override fun updateRoleSelection(
        model: WGRoleModel,
        isChecked: Boolean,
    ) {
        val role = WGRoleDBEntity.WGRole.entries[model.role.ordinal]
        roleLocalDataSource.updateRole(role, isChecked)

    }
}
