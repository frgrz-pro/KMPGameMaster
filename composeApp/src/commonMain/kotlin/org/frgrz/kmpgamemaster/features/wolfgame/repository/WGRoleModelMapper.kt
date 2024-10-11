package org.frgrz.kmpgamemaster.features.wolfgame.repository

import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel

class WGRoleModelMapper {
    fun map(wgRoleEntity: WGRoleEntity): WGRoleModel {
        return WGRoleModel()
    }
}