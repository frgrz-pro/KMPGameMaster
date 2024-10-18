package org.frgrz.kmpgamemaster.features.wolfgame.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity


interface WGRoleLocalDataSource {

    fun getAllChecked(isChecked: Boolean): Flow<List<WGRoleDBEntity>>

    fun getAllFiltered(roles: List<WGRoleDBEntity.WGRole>): Flow<List<WGRoleDBEntity>>

    fun updateRole(role: WGRoleDBEntity.WGRole, isSelected: Boolean)

}

class WGRoleLocalDataSourceImpl(
    private val dao: WGRoleDao,
) : WGRoleLocalDataSource {

    override fun getAllChecked(isChecked: Boolean): Flow<List<WGRoleDBEntity>> {
        return dao.all()
            .map { result ->
                result.filter { role -> role.selected == isChecked }
            }
    }

    override fun getAllFiltered(roles: List<WGRoleDBEntity.WGRole>): Flow<List<WGRoleDBEntity>> {
        return dao.all()
            .map { result ->
                result.filter { role -> role.role in roles.map { it.name } }
            }
    }

    override fun updateRole(role: WGRoleDBEntity.WGRole, isSelected: Boolean) {
            dao.updateSelection(role.name, isSelected)

    }

}
