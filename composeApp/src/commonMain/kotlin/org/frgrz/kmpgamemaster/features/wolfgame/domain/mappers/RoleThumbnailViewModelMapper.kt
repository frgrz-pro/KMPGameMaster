package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleThumbnailViewModel

class RoleThumbnailViewModelMapper (
    private val roleDrawableMediumMapper:RoleDrawableMediumMapper
): Mapper<WGRole, RoleThumbnailViewModel> {

    override fun map(input: WGRole): RoleThumbnailViewModel {
        return RoleThumbnailViewModel(
            roleDrawableMediumMapper.map(input)
        )
    }
}
