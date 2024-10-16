package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.core.RequestState
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.db.GetRolesForFilterUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.db.UpdateRoleSelectionUseCase


class WGRoleViewModel(
    private val filterRolesListUseCase: GetRolesForFilterUseCase,
    private val updateRoleCheckUseCase: UpdateRoleSelectionUseCase,
) : ScreenModel {

    var selectedFilterIndex = mutableStateOf(0)
    var filters: List<RoleFilter> = RoleFilter.entries

    private var _filteredRoles: MutableState<RequestState<List<WGRoleModel>>> =
        mutableStateOf(RequestState.Idle)
    val filteredRoles: MutableState<RequestState<List<WGRoleModel>>> = _filteredRoles

    init {
        applyFilter(RoleFilter.entries[selectedFilterIndex.value])
    }

    private fun applyFilter(filter: RoleFilter) {
        _filteredRoles.value = RequestState.Loading

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
}