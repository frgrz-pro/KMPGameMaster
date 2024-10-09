package org.frgrz.kmpgamemaster.features.wolfgame.di

import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGHomeViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.ui.WGRoleViewModel
import org.koin.dsl.module

val wolfGameViewModelsModule = module {
    
    factory {
        WGHomeViewModel()
    }
    
    factory { 
        WGRoleViewModel()
    }
}