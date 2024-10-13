package org.frgrz.kmpgamemaster.data.dao

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity

interface WGRoleDao {

    fun all(): Flow<List<WGRoleDBEntity>>

    fun resetValues()

}
