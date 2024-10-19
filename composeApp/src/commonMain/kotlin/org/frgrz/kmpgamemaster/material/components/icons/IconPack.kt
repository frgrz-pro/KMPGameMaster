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
            AddVote,
            Assign,
            Bug,
            CancelRole,
            ChangeSide,
            Deck,
            Eye,
            Health,
            Hide,
            Kill,
            Link,
            Moon,
            Notes,
            PersonAdd,
            PersonRemove,
            Potion,
            Protect,
            Radar,
            Remove,
            SelectAll,
            Settings,
            Shield,
            Spy,
            Team,
            Transform,
            Virus,
            Vote,
            Win
        )
        return __Icons!!
    }
