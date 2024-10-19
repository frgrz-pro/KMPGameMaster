package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRoleThumbnailsSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.CacheGameConfigurationUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetCachedPlayersUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.AddRemoveRowViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.RoleThumbnailViewModel

class SetupScreenViewModel(
    private val getRoleSelectionUseCase: GetRoleThumbnailsSelectionUseCase,
    getCachedPlayersUseCase: GetCachedPlayersUseCase,
    private val cacheGameSettingsUseCase: CacheGameConfigurationUseCase,
) : ScreenModel {

    private val players: StateFlow<List<String>> = getCachedPlayersUseCase.invoke()
    private var playerCount = mutableStateOf(WGRules.OPTIMAL_PLAYER_COUNT)
    var playerLabel = mutableStateOf("Joueurs : " + playerCount.value.toString())

    private var _thumbnailsViewModels: MutableState<List<RoleThumbnailViewModel>> = mutableStateOf(listOf())
    val thumbnailsViewModels: State<List<RoleThumbnailViewModel>> = _thumbnailsViewModels
    private var thumbnailsCountOverflow = thumbnailsViewModels.value.size > 15
    val extraItemsCount = mutableStateOf(thumbnailsViewModels.value.size - 15)

    private var wolvesCount = 1
    val wolvesModel = AddRemoveRowViewModel(
        unit = "Loups",
        canAddRule = { WGRules.canAddWolves(playerCount.value, wolvesCount) },
        canRemoveRule = { WGRules.canRemoveWolves(wolvesCount) },
        onCountChanged = {
            wolvesCount = it
            if (peasantCount > WGRules.getMaxPeasant(playerCount.value, wolvesCount)) {
                peasantCount = WGRules.getMaxPeasant(playerCount.value, wolvesCount)
                peasantModel.updateCount(peasantCount)
            }
        }
    )

    private var peasantCount = 1
    val peasantModel = AddRemoveRowViewModel(
        unit = "Paysans",
        canAddRule = { WGRules.canAddPeasant(playerCount.value, wolvesCount, peasantCount) },
        canRemoveRule = { WGRules.canRemovePeasant(peasantCount) },
        onCountChanged = { peasantCount = it }
    )

    var canStartGame = mutableStateOf(playerCount.value > WGRules.MIN_PLAYER)

    init {
        screenModelScope.launch(Dispatchers.Main) {
            getRoleSelectionUseCase.invoke(true)
                .collectLatest {
                    updateThumbnails(it)
                }
        }

        screenModelScope.launch(Dispatchers.Main) {
            players.collectLatest {
                onPlayerCountChanged(it.size)
            }
        }

        wolvesModel.updateCount(WGRules.getOptimalWolvesCount(playerCount.value))
    }


    private fun updateThumbnails(thumbnails: List<RoleThumbnailViewModel>) {
        _thumbnailsViewModels.value = thumbnails

        thumbnailsCountOverflow = thumbnails.size > 15
        extraItemsCount.value = thumbnails.size - 15

        _thumbnailsViewModels.value = if (thumbnailsCountOverflow) {
            thumbnails. subList(0, 15)
        } else {
            thumbnails
        }

    }


    fun saveGameSettings() {
        cacheGameSettingsUseCase.invoke(wolvesCount, peasantCount)
    }

    private fun onPlayerCountChanged(count: Int) {
        playerCount.value = count
        playerLabel.value = "Joueurs : " + playerCount.value
        canStartGame.value = playerCount.value > WGRules.MIN_PLAYER

        wolvesModel.updateCount(wolvesCount)
        peasantModel.updateCount(peasantCount)
    }


}
