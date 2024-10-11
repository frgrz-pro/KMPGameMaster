package org.frgrz.kmpgamemaster.features.wolfgame.di

import org.frgrz.kmpgamemaster.features.wolfgame.repository.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGHomeViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGRoleViewModel
import org.koin.dsl.module

val wgModule = module {
    factory { WGRoleRepository(get()) }
    factory { WGHomeViewModel(get()) }
    factory { WGRoleViewModel(get()) }
}
