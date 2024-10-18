package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleDialogViewModel

class RoleDialogViewModelMapper(
    private val drawableMapper: RoleLargeDrawableMapper,
    private val playsWithMapper: PlaysWithMapper,
    private val winsWithMapper: WinsWithMapper,
) : Mapper<WGRoleModel, RoleDialogViewModel> {

    override fun map(input: WGRoleModel): RoleDialogViewModel {
        return RoleDialogViewModel(
            name = input.name,
            playsWith = playsWithMapper.map(input.playsWith),
            winsWith = winsWithMapper.map(input.winsWith),
            imageDrawableResource = drawableMapper.map(input.role),
            actions = input.actions
        )
    }
}