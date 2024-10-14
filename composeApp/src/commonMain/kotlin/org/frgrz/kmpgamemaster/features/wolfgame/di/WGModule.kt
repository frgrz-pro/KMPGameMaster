package org.frgrz.kmpgamemaster.features.wolfgame.di

import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.data.dao.WGRoleDaoImpl
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleFilterMapper
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSourceImpl
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRolesForFilterUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepositoryImpl
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.UpdateRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGHomeViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGPlayersViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGRoleViewModel
import org.koin.dsl.module

val wgModule = module {

    //region Data Access

    factory<WGRoleDao> { WGRoleDaoImpl(db = get()) }
    factory<WGRoleLocalDataSource> { WGRoleLocalDataSourceImpl(dao = get()) }

    //region Mappers

    factory { WGRoleModelMapper() }
    factory { WGRoleFilterMapper() }

    //region Repository

    factory<WGRoleRepository> {
        WGRoleRepositoryImpl(
            roleLocalDataSource = get(),
            roleModelMapper = get(),
            roleFilterMapper = get()
        )
    }

    //region UseCases

    factory { GetRolesForFilterUseCase(repository = get()) }
    factory { UpdateRoleSelectionUseCase(repository = get()) }
    factory { GetRoleSelectionUseCase(repository = get()) }

    //region ViewModels

    factory { WGHomeViewModel(getRoleSelectionUseCase = get()) }

    factory {
        WGRoleViewModel(
            filterRolesListUseCase = get(),
            updateRoleCheckUseCase = get()
        )
    }

    factory {
        WGPlayersViewModel()
    }
}
