package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.GetLogUseCase

class LogScreenViewModel(getLogUseCase: GetLogUseCase) : ScreenModel {

    val log = getLogUseCase.getLog()

}