package org.frgrz.kmpgamemaster.app.presentation.home.di

import org.frgrz.kmpgamemaster.app.presentation.home.ui.HomeRepository
import org.frgrz.kmpgamemaster.app.presentation.home.ui.HomeViewModel
import org.koin.dsl.module


val homeModule =  module {
    factory { HomeRepository(get()) }
    factory { HomeViewModel(get()) }
}