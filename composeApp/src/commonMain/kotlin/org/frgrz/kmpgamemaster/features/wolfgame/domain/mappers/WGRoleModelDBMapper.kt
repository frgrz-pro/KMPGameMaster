package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel

class WGRoleModelDBMapper(
    private val winConditionMapper: WinConditionMapper,
    private val roleNameMapper: RoleNameMapper,
    private val roleCancelMapper: RoleCancelMapper,
    private val playsWithMapper: PlaysWithMapper,
    private val roleActionMapper: RoleActionMapper,
    private val roleFilterMapper: RoleFilterMapper,
    private val roleTypeMapper: RoleTypeMapper,
) : Mapper<WGRoleDBEntity, WGRoleModel> {

    override fun map(input: WGRoleDBEntity): WGRoleModel {
        val dbRole = WGRoleDBEntity.WGRole.entries.first { it.name == input.role }
        val role = roleTypeMapper.map(dbRole)

        return WGRoleModel(
            role = role,
            name = roleNameMapper.map(role),
            isSelected = input.selected,
            isDefault = input.default,
            playsWith = playsWithMapper.map(role),
            winConditions = winConditionMapper.map(role),
            cancels = roleCancelMapper.map(role),
            filters = roleFilterMapper.map(role),
            actions = roleActionMapper.map(role)
        )
    }
}