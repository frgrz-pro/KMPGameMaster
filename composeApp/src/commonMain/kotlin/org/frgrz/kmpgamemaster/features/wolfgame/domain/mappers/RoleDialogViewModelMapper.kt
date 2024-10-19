package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleDialogViewModel


class RoleDialogViewModelMapper(
    private val drawableMapper: RoleDrawableLargeMapper,
    private val playsWithMapper: PlaysWithStringMapper,
    private val winConditionMapper: WinRoleActionItemViewModelMapper,
    private val roleActionItemViewModelMapper: RoleActionItemViewModelMapper,
    private val cancelsMapper: RoleCancelStringMapper,
) : Mapper<WGRoleModel, RoleDialogViewModel> {

    override fun map(input: WGRoleModel): RoleDialogViewModel {
        return RoleDialogViewModel(
            name = input.name,
            playsWith = playsWithMapper.map(input.playsWith),
            winConditions = winConditionMapper.map(input.winConditions),
            imageDrawableResource = drawableMapper.map(input.role),
            cancels = cancelsMapper.map(input.cancels),
            actions = input.actions.map { roleActionItemViewModelMapper.map(it) }
        )
    }
}
