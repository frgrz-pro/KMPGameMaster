package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole

class RoleTypeMapper : Mapper<WGRoleDBEntity.WGRole, WGRole> {
    override fun map(input: WGRoleDBEntity.WGRole): WGRole {
        return WGRole.entries[input.ordinal]
    }
}