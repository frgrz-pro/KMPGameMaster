package org.frgrz.kmpgamemaster.data.dao

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.data.db.RealmDatabase
import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity

interface WGRoleDao {

    fun all(): Flow<List<WGRoleEntity>>

}

class WGRoleDaoImpl(private val db: RealmDatabase) : WGRoleDao {

    override fun all(): Flow<List<WGRoleEntity>> = db.getAllAsFlow<WGRoleEntity>()

}