package org.frgrz.kmpgamemaster.features.wolfgame.di

import org.frgrz.kmpgamemaster.data.datasource.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.repository.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.repository.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGHomeViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGRoleViewModel
import org.koin.dsl.module

val wgModule = module {
    factory { WGRoleModelMapper() }
    factory { WGRoleLocalDataSource(get()) }
    factory { WGRoleRepository(get(), get()) }
    factory { WGHomeViewModel(get()) }
    factory { WGRoleViewModel(get()) }
}
