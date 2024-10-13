package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.features.wolfgame.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.repository.WGRoleRepository
import org.frgrz.kmpgamemaster.utils.RequestState


class WGRoleViewModel(private val repository: WGRoleRepository) : ScreenModel {

    var selectedFilterIndex = mutableStateOf(0)
    var filters: List<RoleFilter> = RoleFilter.entries

    private var _filteredRoles: MutableRoles = mutableStateOf(RequestState.Idle)
    val filteredRoles: Roles = _filteredRoles

    init {
        applyFilter(RoleFilter.entries[selectedFilterIndex.value])
    }

    private fun applyFilter(filter: RoleFilter) {
        _filteredRoles.value = RequestState.Loading

        screenModelScope.launch(Dispatchers.Main) {
            if (filter == RoleFilter.SELECTED || filter == RoleFilter.UNSELECTED) {
                repository.getAllChecked(filter == RoleFilter.SELECTED)
                    .collectLatest {
                        _filteredRoles.value = it
                    }
            } else {
                repository.getAllFiltered(filter)
                    .collectLatest {
                        _filteredRoles.value = it
                    }
            }
        }
    }

    fun onFilterSelected(filter: RoleFilter) {
        selectedFilterIndex.value = filters.indexOf(filter)
        applyFilter(filter)
    }

    fun onRoleCheckedChanged(isChecked: Boolean, role: WGRoleModel) {
    }
}