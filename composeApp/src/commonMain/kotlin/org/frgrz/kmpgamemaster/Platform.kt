package org.frgrz.kmpgamemaster

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform