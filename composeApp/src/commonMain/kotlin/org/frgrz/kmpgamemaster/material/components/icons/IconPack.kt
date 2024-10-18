package org.frgrz.kmpgamemaster.material.components.icons

import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.collections.List as ____KtList

object IconPack

private var __Icons: ____KtList<ImageVector>? = null

val IconPack.Icons: ____KtList<ImageVector>
    get() {
        if (__Icons != null) {
            return __Icons!!
        }
        __Icons = listOf(
            Bug,
            Eye,
            Notes,
            PersonAdd,
            PersonRemove,
            Remove,
            SelectAll,
            Settings,
            Assign,
            Deck
        )
        return __Icons!!
    }
