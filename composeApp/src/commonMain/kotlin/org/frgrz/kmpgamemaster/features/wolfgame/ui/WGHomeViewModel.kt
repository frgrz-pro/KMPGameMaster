package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRules
import org.frgrz.kmpgamemaster.features.wolfgame.repository.WGRoleRepository

class WGHomeViewModel(private val repository: WGRoleRepository) : ScreenModel {


    class CardItem

    var playerCount = mutableStateOf(WGRules.OPTIMAL_PLAYER_COUNT)
    var playerLabel = mutableStateOf("Joueurs : " + playerCount.value.toString())

    val maxPlayers = WGRules.MAX_PLAYER_COUNT
    val minPlayers = WGRules.MIN_PLAYER

    var wolvesCount = mutableStateOf(WGRules.OPTIMAL_WOLVES_COUNT)
    var wolvesLabel = mutableStateOf("${wolvesCount.value} Loups")
    var canAddWolves = mutableStateOf(true)
    var canRemoveWolves = mutableStateOf(true)

    var dataList = mutableStateOf(
        listOf(
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
            CardItem(),
        )
    )


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

