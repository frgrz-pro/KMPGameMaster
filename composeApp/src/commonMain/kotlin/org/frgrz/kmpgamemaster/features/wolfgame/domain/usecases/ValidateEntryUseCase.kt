package org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases


class ValidateEntryUseCase {
    operator fun invoke(input:String, onValidation: (Boolean) -> Unit) {
        onValidation.invoke(input.length >= MIN_NAME_LENGTH)
    }

    companion object {
        private const val MIN_NAME_LENGTH = 3
    }
}
