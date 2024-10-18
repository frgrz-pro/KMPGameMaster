package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRolesForFilterUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.UpdateRoleSelectionUseCase


class RolesScreenViewModel(
    private val filterRolesListUseCase: GetRolesForFilterUseCase,
    private val updateRoleCheckUseCase: UpdateRoleSelectionUseCase,
) : ScreenModel {

    var selectedFilterIndex = mutableStateOf(0)
    var filters: List<RoleFilter> = RoleFilter.entries

    private var _filteredRoles: MutableState<List<WGRoleModel>> = mutableStateOf(listOf())
    val filteredRoles: MutableState<List<WGRoleModel>> = _filteredRoles

    init {
        applyFilter(RoleFilter.entries[selectedFilterIndex.value])
    }

    private fun applyFilter(filter: RoleFilter) {
        screenModelScope.launch(Dispatchers.Main) {
            filterRolesListUseCase.invoke(filter)
                .collectLatest {
                    _filteredRoles.value = it
                }
        }
    }

    fun onFilterSelected(filter: RoleFilter) {
        selectedFilterIndex.value = filters.indexOf(filter)
        applyFilter(filter)
    }

    fun onRoleCheckedChanged(role: WGRoleModel, isChecked: Boolean) {
        screenModelScope.launch {
            updateRoleCheckUseCase.invoke(role, isChecked)
        }
    }

    fun onToggleAllClicked() {
        with(_filteredRoles.value) {
            if (any { !it.isSelected }) {
                forEach { role ->
                    onRoleCheckedChanged(role, true)
                }
            } else {
                forEach { role ->
                    onRoleCheckedChanged(role, false)
                }
            }
        }
    }
}