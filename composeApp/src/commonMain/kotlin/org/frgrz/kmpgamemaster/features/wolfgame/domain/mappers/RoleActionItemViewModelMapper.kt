package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleAction
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleActionItemViewModel


class RoleActionItemViewModelMapper(
    private val roleActionIconMapper: RoleActionIconMapper,
) : Mapper<WGRoleAction, RoleActionItemViewModel> {

    override fun map(input: WGRoleAction): RoleActionItemViewModel {
        return RoleActionItemViewModel(
            name = input.name,
            desc = input.desc,
            icon = roleActionIconMapper.map(input.type)
        )
    }
}
