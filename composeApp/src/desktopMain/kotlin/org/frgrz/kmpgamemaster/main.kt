package org.frgrz.kmpgamemaster

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPGameMaster",
    ) {
        App()
    }
}