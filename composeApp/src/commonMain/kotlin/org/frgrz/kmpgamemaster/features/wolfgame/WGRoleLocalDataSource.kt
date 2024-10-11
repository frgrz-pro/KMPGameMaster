package org.frgrz.kmpgamemaster.features.wolfgame

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.utils.RequestState

interface WGRoleLocalDataSource {
    fun getAllChecked(): Flow<RequestState<List<WGRoleModel>>>
}