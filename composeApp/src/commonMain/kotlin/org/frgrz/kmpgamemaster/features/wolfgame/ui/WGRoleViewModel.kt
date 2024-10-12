package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import org.frgrz.kmpgamemaster.features.wolfgame.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.repository.WGRoleRepository


class WGRoleViewModel(private val repository: WGRoleRepository):ScreenModel {

    var selectedFilterIndex = mutableStateOf(0)
    var filters: List<RoleFilter> = RoleFilter.entries

}