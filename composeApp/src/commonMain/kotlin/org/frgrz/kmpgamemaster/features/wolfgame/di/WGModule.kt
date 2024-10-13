package org.frgrz.kmpgamemaster.features.wolfgame.di

import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleFilterMapper
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleDaoImpl
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSourceImpl
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRolesForFilterUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetSelectedRolesUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepositoryImpl
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGHomeViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGRoleViewModel
import org.koin.dsl.module

val wgModule = module {
    factory<WGRoleDao> { WGRoleDaoImpl(get()) }
    factory<WGRoleLocalDataSource>{ WGRoleLocalDataSourceImpl(get()) }
    factory { WGRoleModelMapper() }
    factory { WGRoleFilterMapper() }
    factory<WGRoleRepository> { WGRoleRepositoryImpl(get(), get(), get()) }
    factory { GetRolesForFilterUseCase(get()) }
    factory { GetSelectedRolesUseCase(get()) }
    factory { WGHomeViewModel(get()) }
    factory { WGRoleViewModel(get()) }
}
