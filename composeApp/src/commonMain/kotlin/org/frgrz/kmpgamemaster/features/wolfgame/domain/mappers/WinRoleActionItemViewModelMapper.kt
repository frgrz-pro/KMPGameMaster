package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WinCondition
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleActionItemViewModel
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Win


class WinRoleActionItemViewModelMapper(
    private val winsWithMapper: WinsWithMapper,
) : Mapper<List<WinCondition>, List<RoleActionItemViewModel>> {
    override fun map(input: List<WinCondition>): List<RoleActionItemViewModel> {
        return input.map {
            RoleActionItemViewModel(
                name = winsWithMapper.map(it.winsWith),
                desc = null,
                icon = IconPack.Win,
            )
        }
    }

}