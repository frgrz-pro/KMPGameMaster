package org.frgrz.kmpgamemaster.features.home.di

import org.frgrz.kmpgamemaster.features.home.ui.HomeRepository
import org.frgrz.kmpgamemaster.features.home.ui.HomeViewModel
import org.koin.dsl.module

val homeViewModelsModule =  module {
    factory { HomeRepository(get()) }
    factory { HomeViewModel(get()) }
}