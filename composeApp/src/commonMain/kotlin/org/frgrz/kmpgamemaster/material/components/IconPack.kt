package org.frgrz.kmpgamemaster.material.components

import androidx.compose.ui.graphics.vector.ImageVector
import org.frgrz.kmpgamemaster.material.components.icons.Remove
import org.frgrz.kmpgamemaster.material.components.icons.SelectAll
import kotlin.collections.List as ____KtList

object IconPack

private var __Icons: ____KtList<ImageVector>? = null

val IconPack.Icons: ____KtList<ImageVector>
  get() {
    if (__Icons != null) {
      return __Icons!!
    }
    __Icons = listOf(Remove, SelectAll)
    return __Icons!!
  }
