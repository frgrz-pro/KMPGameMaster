package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinCondition
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleActionItemViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleDialogViewModel
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Win

class RoleDialogViewModelMapper(
    private val drawableMapper: RoleLargeDrawableMapper,
    private val playsWithMapper: PlaysWithMapper,
    private val winConditionMapper: WinRoleActionItemViewModelMapper,
    private val roleActionItemViewModelMapper: RoleActionItemViewModelMapper,

) : Mapper<WGRoleModel, RoleDialogViewModel> {

    override fun map(input: WGRoleModel): RoleDialogViewModel {
        return RoleDialogViewModel(
            name = input.name,
            playsWith = playsWithMapper.map(input.playsWith),
            winCondition = winConditionMapper.map(input.winCondition),
            imageDrawableResource = drawableMapper.map(input.role),
            actions = input.actions.map { roleActionItemViewModelMapper.map(it) }
        )
    }
}

class WinRoleActionItemViewModelMapper (
    private val winsWithMapper: WinsWithMapper,
): Mapper<WinCondition, RoleActionItemViewModel> {
    override fun map(input: WinCondition): RoleActionItemViewModel {
        return RoleActionItemViewModel(
            name = winsWithMapper.map(input.winsWith),
            desc = null,
            icon = IconPack.Win,
        )
    }

}