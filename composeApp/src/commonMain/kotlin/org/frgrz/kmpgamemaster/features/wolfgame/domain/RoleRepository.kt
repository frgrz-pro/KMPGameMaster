package org.frgrz.kmpgamemaster.features.wolfgame.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGGameCache
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleFilterMapper
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.GameConfiguration
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel


//TODO Split ? Create another repository for game configuration
interface WGRoleRepository {

    fun getAllChecked(isChecked: Boolean): Flow<List<WGRoleModel>>

    fun getAllFiltered(filter: RoleFilter): Flow<List<WGRoleModel>>

    fun updateRoleSelection(model: WGRole, isChecked: Boolean)

    fun cachePlayerConfiguration(players: List<String>)

    fun getCachePlayerConfiguration(): StateFlow<List<String>>

    fun cacheRoleConfiguration(roles: List<WGRole>, wolvesCount: Int, peasantCount: Int)

    fun getCacheGameConfiguration(): StateFlow<GameConfiguration>
}

class WGRoleRepositoryImpl(
    private val roleLocalDataSource: WGRoleLocalDataSource,
    private val roleModelMapper: WGRoleModelMapper,
    private val roleFilterMapper: WGRoleFilterMapper,
    private val cache: WGGameCache,
) : WGRoleRepository {

    override fun getAllChecked(isChecked: Boolean): Flow<List<WGRoleModel>> {
        return roleLocalDataSource.getAllChecked(isChecked)
            .map { result ->
                result.map {
                    roleModelMapper.map(it)
                }
            }
    }

    override fun getAllFiltered(filter: RoleFilter): Flow<List<WGRoleModel>> {
        val roles = roleFilterMapper.map(filter)
        return roleLocalDataSource.getAllFiltered(roles)
            .map { result ->
                result.map {
                    roleModelMapper.map(it)
                }
            }
    }

    override fun updateRoleSelection(
        model: WGRole,
        isChecked: Boolean,
    ) {
        val role = WGRoleDBEntity.WGRole.entries[WGRole.entries.indexOf(model)]
        roleLocalDataSource.updateRole(role, isChecked)

    }

    override fun getCachePlayerConfiguration(): StateFlow<List<String>> {
        return cache.players
    }

    override fun getCacheGameConfiguration(): StateFlow<GameConfiguration> {
        return cache.gameConfiguration
    }

    override fun cachePlayerConfiguration(players: List<String>) {
        cache.savePlayers(players)
    }

    override fun cacheRoleConfiguration(roles: List<WGRole>, wolvesCount: Int, peasantCount: Int) {
        cache.saveRolesConfiguration(roles, wolvesCount, peasantCount)
    }

}
