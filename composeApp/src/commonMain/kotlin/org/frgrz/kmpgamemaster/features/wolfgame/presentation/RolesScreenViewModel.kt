package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRolesForFilterUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.UpdateRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleCardViewModel


class RolesScreenViewModel(
    private val filterRolesListUseCase: GetRolesForFilterUseCase,
    private val updateRoleCheckUseCase: UpdateRoleSelectionUseCase,
) : ScreenModel {

    var selectedFilterIndex = mutableStateOf(0)
    var filters: List<RoleFilter> = RoleFilter.entries

    private var _filteredRoles: MutableState<List<WGRoleModel>> = mutableStateOf(listOf())
    val filteredRoles: MutableState<List<WGRoleModel>> = _filteredRoles

    private var _cardsViewModel: MutableState<List<RoleCardViewModel>> = mutableStateOf(listOf())
    val cardsViewModel : MutableState<List<RoleCardViewModel>> = _cardsViewModel




    init {
        applyFilter(RoleFilter.entries[selectedFilterIndex.value])
    }

    private fun applyFilter(filter: RoleFilter) {
        screenModelScope.launch(Dispatchers.Main) {
            filterRolesListUseCase.invoke(filter)
                .collectLatest {
                    //_filteredRoles.value = it

                    _cardsViewModel.value = it.map { role ->
                        RoleCardViewModel(role) { item, isChecked ->
                            onRoleCheckedChanged(item.role, isChecked)
                        }
                    }
                }
        }
    }

    fun onFilterSelected(filter: RoleFilter) {
        selectedFilterIndex.value = filters.indexOf(filter)
        applyFilter(filter)
    }

    fun onRoleCheckedChanged(role: WGRole, isChecked: Boolean) {
        screenModelScope.launch {
            updateRoleCheckUseCase.invoke(role, isChecked)
        }
    }

    fun onToggleAllClicked() {
        with(_cardsViewModel.value) {
            if (any { !it.model.isSelected }) {
                forEach {
                    onRoleCheckedChanged(it.model.role, true)
                }
            } else {
                forEach {
                    onRoleCheckedChanged(it.model.role, false)
                }
            }
        }
    }
}