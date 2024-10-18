package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import androidx.compose.runtime.mutableStateOf
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleCardViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleDialogViewModel

interface Mapper<T, R> {
    fun map(input: T): R
}


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

class RoleCardViewModelMapper(
    private val roleDialogViewModelMapper: RoleDialogViewModelMapper,
) : Mapper<WGRoleModel, RoleCardViewModel> {

    override fun map(input: WGRoleModel): RoleCardViewModel {
        return RoleCardViewModel(
            name = input.name,
            role = input.role,
            isSelected = mutableStateOf(input.isSelected),
            imageResource = RoleLargeDrawableMapper().map(input.role),
            roleDialogViewModel = roleDialogViewModelMapper.map(input)
        )
    }
}