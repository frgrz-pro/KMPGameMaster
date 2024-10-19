package org.frgrz.kmpgamemaster.data.dao

import io.realm.kotlin.ext.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.data.db.RealmDatabase
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRolesDBSeed

interface WGRoleDao {

    fun getAll(): List<WGRoleDBEntity>

    fun getAllAsFlow(): Flow<List<WGRoleDBEntity>>

    fun updateSelection(name: String, isSelected: Boolean): WGRoleDBEntity?

}

class WGRoleDaoImpl(private val db: RealmDatabase) : WGRoleDao {

    private var isSeeded = false

    init {
        isSeeded = db.getAll<WGRoleDBEntity>().isNotEmpty()

        if (!isSeeded) {
            WGRolesDBSeed.seed().forEach { db.upsert(it) }
        }
    }

    override fun getAll(): List<WGRoleDBEntity> {
        return db.getAll()
    }

    override fun getAllAsFlow(): Flow<List<WGRoleDBEntity>> {
        return db.getAllAsFlow<WGRoleDBEntity>()
    }

    override fun updateSelection(name: String, isSelected: Boolean): WGRoleDBEntity? {
        var entity: WGRoleDBEntity? = null
        CoroutineScope(Dispatchers.IO).launch {
            db.realm.write {
                entity = db.realm.query<WGRoleDBEntity>("role == $0", name).first().find()
                entity?.let {
                    findLatest(it)?.selected = isSelected
                }
            }

        }

        return entity
    }

}