package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.CachePlayersUseCase

class WGPlayersViewModel(private val cachePlayersUseCase: CachePlayersUseCase) : ScreenModel {

    private val _entries = mutableStateListOf<String>()
    val entries: List<String> = _entries
    var currentInput = mutableStateOf("")

    fun addEntry() {
        if (currentInput.value.length >= 3) {
            _entries.add(currentInput.value)
            currentInput.value = ""
            return
        }
    }

    fun removeEntry(index: Int) {
        _entries.removeAt(index)
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
    }

    fun savePlayers() {
        cachePlayersUseCase.invoke(entries)
    }

}
