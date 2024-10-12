package org.frgrz.kmpgamemaster.features.home.ui

import cafe.adriel.voyager.core.model.ScreenModel

class HomeViewModel(private val repository: HomeRepository) : ScreenModel {

    fun onResetDatabaseClicked() {
        repository.resetValues()
    }
}