package org.frgrz.kmpgamemaster.features.wolfgame.data

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.data.db.RealmDatabase
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity

class WGRoleDaoImpl(private val db: RealmDatabase) : WGRoleDao {

    private var isSeeded = false

    init {
        isSeeded = db.getAll<WGRoleDBEntity>().isNotEmpty()

        if (!isSeeded) {
            WGRolesDBSeed.seed().forEach { db.upsert(it) }
        }
    }

    override fun all(): Flow<List<WGRoleDBEntity>> = db.getAllAsFlow<WGRoleDBEntity>()

    override fun resetValues() {
        db.getAll<WGRoleDBEntity>()
            .map {
                val updated = it.apply { it.selected = it.default }
                db.upsert(updated)
            }
    }
}
