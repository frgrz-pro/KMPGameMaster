package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.PlayerNameValidationUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.WGRules
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.CachePlayersUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.LogPlayerChangedUseCase

class WGPlayersViewModel(
    private val cachePlayersUseCase: CachePlayersUseCase,
    private val validateEntryUseCase: PlayerNameValidationUseCase,
    private val log: LogPlayerChangedUseCase,
) : ScreenModel {

    private val _entries = mutableStateListOf<String>()
    val entries: List<String> = _entries



    var currentInput = mutableStateOf("")
    val isValidateButtonEnabled = mutableStateOf(false)

    fun addEntry() {
        validateEntryUseCase(currentInput.value) { isValid ->
            if (isValid) {
                log.logPlayerAdded(currentInput.value)
                _entries.add(currentInput.value)
                updateValidateButtonVisibility()
                currentInput.value = ""
            }
        }
    }

    fun removeEntry(index: Int) {
        log.logPlayerRemoved(_entries[index])
        _entries.removeAt(index)
        updateValidateButtonVisibility()
    }

    fun seed() {
        _entries.add("Emile")
        _entries.add("Bonaventure")
        _entries.add("Francois")
        _entries.add("Marion")
        _entries.add("Florence")
        _entries.add("Faouzi")
        _entries.add("Salim")
        _entries.add("Matthieu")
        _entries.add("Hedi")
        _entries.add("Tom")
        _entries.add("Kelly")
        _entries.add("Amaïa")

        _entries.map {
            log.logPlayerAdded(it)
        }

        updateValidateButtonVisibility()
    }

    fun savePlayers() {
        cachePlayersUseCase.invoke(entries)
    }

    private fun updateValidateButtonVisibility() {
        isValidateButtonEnabled.value = _entries.size >= WGRules.MIN_PLAYER
    }

}
