package org.frgrz.kmpgamemaster.features.wolfgame

object WGRules {

    const val MAX_PLAYER_COUNT = 18

    const val MIN_PLAYER = 5
    const val MIN_WOLVES = 1

    const val OPTIMAL_PLAYER_COUNT = 9
    const val OPTIMAL_WOLVES_COUNT = 2

    fun getOptimalWolvesCount(playersCount: Int): Int {
        return when {
            playersCount < 5 -> 0
            playersCount in 5..7 -> MIN_WOLVES
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