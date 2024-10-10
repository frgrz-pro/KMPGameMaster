package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel

class WGHomeViewModel : ScreenModel {

    var playerCount = mutableStateOf(WGRules.OPTIMAL_PLAYER_COUNT)
    var playerLabel = mutableStateOf("Joueurs : " + playerCount.value.toString())

    val maxPlayers = WGRules.MAX_PLAYER_COUNT
    val minPlayers = WGRules.MIN_PLAYER

    var wolvesCount = mutableStateOf(WGRules.OPTIMAL_WOLVES_COUNT)
    var wolvesLabel = mutableStateOf("${wolvesCount.value} Loups")
    var canAddWolves = mutableStateOf(true)
    var canRemoveWolves = mutableStateOf(true)

    var isSolosEnabled = mutableStateOf(true)
    var isMayorEnabled = mutableStateOf(true)

    fun onSolosCheckedChanged(isChecked: Boolean) {
        isSolosEnabled.value = isChecked
    }

    fun onMayorCheckedChanged(isChecked: Boolean) {
        isMayorEnabled.value = isChecked
    }

    fun onPlayerCountChanged(count: Int) {
        playerCount.value = count
        playerLabel.value = "Joueurs : " + playerCount.value
        val optimalWolvesCount = WGRules.getOptimalWolvesCount(count)
        updateWolvesCount(optimalWolvesCount)
    }

    fun onAddWolvesClicked() {
        if (!canAddWolves.value)
            return

        updateWolvesCount(wolvesCount.value + 1)
    }

    fun onRemoveWolvesClicked() {
        if (!canRemoveWolves.value)
            return

        updateWolvesCount(wolvesCount.value - 1)
    }

    private fun updateWolvesCount(wolves: Int) {
        wolvesCount.value = wolves
        wolvesLabel.value = "${wolvesCount.value} Loups"
        updateAddRemoveWolves()
    }

    private fun updateAddRemoveWolves() {
        canAddWolves.value = WGRules.canAddWolves(playerCount.value, wolvesCount.value)
        canRemoveWolves.value = WGRules.canRemoveWolves(wolvesCount.value)
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

    fun getOptimalWolvesCount(playersCount: Int): Int {
        return when {
            playersCount < 5 -> 0
            playersCount in 5..7 -> 1
            playersCount == 8 -> 2
            else -> 1 + (playersCount - 5) / 4
        }
    }

    fun canAddWolves(playersCount: Int, wolvesCount: Int): Boolean {
        return when {
            playersCount < 7 -> false
            else -> {
                wolvesCount != getOptimalWolvesCount(playersCount) + 1
            }
        }
    }

    fun canRemoveWolves(wolvesCount: Int): Boolean {
        return wolvesCount != 1
    }
}