package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel


class WGRoleModelMapper(
    private val winConditionMapper: WinConditionMapper,
    private val roleNameMapper: RoleNameMapper,
    private val roleCancelMapper: RoleCancelMapper,
    private val playsWithMapper: PlaysWithMapper,
    private val roleActionMapper: RoleActionMapper,
    private val roleFilterMapper: RoleFilterMapper,
) : Mapper<WGRole, WGRoleModel> {

    override fun map(input: WGRole): WGRoleModel {
        return WGRoleModel(
            role = input,
            name = roleNameMapper.map(input),
            isSelected = true,
            isDefault = false, //TODO
            playsWith = playsWithMapper.map(input),
            winConditions = winConditionMapper.map(input),
            filters = roleFilterMapper.map(input),
            cancels = roleCancelMapper.map(input),
            actions = roleActionMapper.map(input)
        )
    }
}


