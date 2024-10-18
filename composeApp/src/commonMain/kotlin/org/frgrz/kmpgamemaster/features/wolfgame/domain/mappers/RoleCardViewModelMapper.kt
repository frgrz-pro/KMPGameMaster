package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import androidx.compose.runtime.mutableStateOf
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleCardViewModel

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