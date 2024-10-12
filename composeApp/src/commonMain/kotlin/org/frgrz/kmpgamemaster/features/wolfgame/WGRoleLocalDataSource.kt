package org.frgrz.kmpgamemaster.features.wolfgame

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.features.wolfgame.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.utils.RequestState

interface WGRoleLocalDataSource {
    fun getAllChecked(isChecked:Boolean): Flow<RequestState<List<WGRoleModel>>>
    fun getAllFiltered(filter: RoleFilter): Flow<RequestState<List<WGRoleModel>>>
}