package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck

import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel


class MapRoleViewModelUseCase(private val mapper: WGRoleModelMapper) {

    operator fun invoke(roles:List<WGRole>): List<WGRoleModel> {
        return roles.map { mapper.map(it) }
    }
}