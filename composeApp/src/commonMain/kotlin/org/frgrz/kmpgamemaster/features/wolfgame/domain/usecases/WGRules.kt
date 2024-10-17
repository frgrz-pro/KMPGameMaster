package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases


//TODO: transform in use case
object WGRules {


    const val MIN_PLAYER = 5
    const val MIN_WOLVES = 1

    const val OPTIMAL_PLAYER_COUNT = 9
    const val MIN_SPECIALISTS = 3

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
        return wolvesCount > 1
    }

    fun canRemovePeasant( peasantCount: Int): Boolean {
        return peasantCount > 1
    }

    fun canAddPeasant(playersCount: Int, wolvesCount: Int, peasantCount: Int): Boolean {
       return playersCount - (wolvesCount + MIN_SPECIALISTS +peasantCount) > 0
    }

    fun getMaxPeasant(playersCount: Int, wolvesCount: Int):Int {
        return playersCount - (wolvesCount + MIN_SPECIALISTS)

    }
}