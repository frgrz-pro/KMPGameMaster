package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases

import org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers.RoleDialogViewModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleDialogViewModel

class GetRoleDialogViewModelUseCase(
    private val roleDialogViewModelMapper: RoleDialogViewModelMapper
) {
    operator fun invoke(role: WGRoleModel, dismiss: () -> Unit): RoleDialogViewModel {
        return roleDialogViewModelMapper.map(role).apply {
            setOnDialogDismissRequested(dismiss)
        }
    }
}
