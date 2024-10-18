package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

interface Mapper<T, R> {
    fun map(input: T): R
}



/*
class RoleDialogViewModelMapper(
    private val drawableMapper:RoleLargeDrawableMapper
) : Mapper<WGRoleModel, RoleDialogViewModel> {
    override fun map(input: WGRoleModel): RoleDialogViewModel {
        return RoleDialogViewModel(
            name = input.name,
            image = drawableMapper.map(input)
        )

    }

}*/