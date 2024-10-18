package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import androidx.compose.runtime.mutableStateOf
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleCardViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleDialogViewModel

interface Mapper<T, R> {
    fun map(input: T): R
}




