package org.frgrz.kmpgamemaster.material.components

import androidx.compose.ui.graphics.vector.ImageVector
import org.frgrz.kmpgamemaster.material.components.icons.Assign
import org.frgrz.kmpgamemaster.material.components.icons.Bug
import org.frgrz.kmpgamemaster.material.components.icons.Deck
import org.frgrz.kmpgamemaster.material.components.icons.Eye
import org.frgrz.kmpgamemaster.material.components.icons.Notes
import org.frgrz.kmpgamemaster.material.components.icons.PersonAdd
import org.frgrz.kmpgamemaster.material.components.icons.PersonRemove
import org.frgrz.kmpgamemaster.material.components.icons.Remove
import org.frgrz.kmpgamemaster.material.components.icons.SelectAll
import org.frgrz.kmpgamemaster.material.components.icons.Settings
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
