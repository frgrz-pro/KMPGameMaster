package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel

class WGHomeViewModel() : ScreenModel {

    var playerCount = mutableStateOf(WGRules.OPTIMAL_PLAYER_COUNT)
    var playerLabel = mutableStateOf("Joueurs : " + playerCount.value.toString())
    var civiliansCount = mutableStateOf(WGRules.OPTIMAL_CIVILIANS_COUNT)
    var civilianLabel = mutableStateOf(civiliansCount.value.toString() + " Villageois")
    var wolvesCount = mutableStateOf(WGRules.OPTIMAL_WOLVES_COUNT)
    var wolvesLabel = mutableStateOf(wolvesCount.value.toString() + " Loups")
    var isSolosEnabled = mutableStateOf(true)
    var isMayorEnabled = mutableStateOf(true)

    fun onPlayerCountChanged(count: Int) {
        playerCount.value = count
        playerLabel.value = "Joueurs : " + playerCount.value
        wolvesCount.value = WGRules.getMaxWolvesCount(count)
        civiliansCount.value = playerCount.value - wolvesCount.value
    }
}

object WGRules {

    const val MAX_PLAYER_COUNT = 18

    const val MIN_PLAYER = 5
    const val MIN_WOLVES = 1
    const val MIN_CIVILIANS = 4

    const val OPTIMAL_PLAYER_COUNT = 9
    const val OPTIMAL_WOLVES_COUNT = 2
    const val OPTIMAL_CIVILIANS_COUNT = 7

    fun getMaxWolvesCount(playersCount: Int): Int {
       return when {
            playersCount < MIN_PLAYER -> 0
            playersCount == 5 -> 1
            else -> 1 + (playersCount - 5 + 3) / 4
        }
    }
}