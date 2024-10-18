package org.frgrz.kmpgamemaster.material.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val IconPack.Vote: ImageVector
    get() {
        if (_vote != null) {
            return _vote!!
        }
        _vote = Builder(name = "Vote", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(200.0f, 880.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                reflectiveQuadTo(120.0f, 800.0f)
                verticalLineToRelative(-182.0f)
                lineToRelative(110.0f, -125.0f)
                lineToRelative(57.0f, 57.0f)
                lineToRelative(-80.0f, 90.0f)
                horizontalLineToRelative(546.0f)
                lineToRelative(-78.0f, -88.0f)
                lineToRelative(57.0f, -57.0f)
                lineToRelative(108.0f, 123.0f)
                verticalLineToRelative(182.0f)
                quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
                reflectiveQuadTo(760.0f, 880.0f)
                lineTo(200.0f, 880.0f)
                close()
                moveTo(200.0f, 800.0f)
                horizontalLineToRelative(560.0f)
                verticalLineToRelative(-80.0f)
                lineTo(200.0f, 720.0f)
                verticalLineToRelative(80.0f)
                close()
                moveTo(425.0f, 575.0f)
                lineTo(284.0f, 434.0f)
                quadToRelative(-23.0f, -23.0f, -22.5f, -56.5f)
                reflectiveQuadTo(285.0f, 321.0f)
                lineToRelative(196.0f, -196.0f)
                quadToRelative(23.0f, -23.0f, 57.0f, -24.0f)
                reflectiveQuadToRelative(57.0f, 22.0f)
                lineToRelative(141.0f, 141.0f)
                quadToRelative(23.0f, 23.0f, 24.0f, 56.0f)
                reflectiveQuadToRelative(-22.0f, 56.0f)
                lineTo(538.0f, 576.0f)
                quadToRelative(-23.0f, 23.0f, -56.5f, 22.5f)
                reflectiveQuadTo(425.0f, 575.0f)
                close()
                moveTo(680.0f, 321.0f)
                lineTo(539.0f, 180.0f)
                lineTo(341.0f, 378.0f)
                lineToRelative(141.0f, 141.0f)
                lineToRelative(198.0f, -198.0f)
                close()
                moveTo(200.0f, 800.0f)
                verticalLineToRelative(-80.0f)
                verticalLineToRelative(80.0f)
                close()
            }
        }
        .build()
        return _vote!!
    }

private var _vote: ImageVector? = null
