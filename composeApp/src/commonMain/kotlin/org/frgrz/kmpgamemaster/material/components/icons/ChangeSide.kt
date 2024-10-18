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

public val IconPack.ChangeSide: ImageVector
    get() {
        if (_changeSide != null) {
            return _changeSide!!
        }
        _changeSide = Builder(name = "ChangeSide", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(204.0f, 642.0f)
                quadToRelative(-22.0f, -38.0f, -33.0f, -78.0f)
                reflectiveQuadToRelative(-11.0f, -82.0f)
                quadToRelative(0.0f, -134.0f, 93.0f, -228.0f)
                reflectiveQuadToRelative(227.0f, -94.0f)
                horizontalLineToRelative(7.0f)
                lineToRelative(-64.0f, -64.0f)
                lineToRelative(56.0f, -56.0f)
                lineToRelative(160.0f, 160.0f)
                lineToRelative(-160.0f, 160.0f)
                lineToRelative(-56.0f, -56.0f)
                lineToRelative(64.0f, -64.0f)
                horizontalLineToRelative(-7.0f)
                quadToRelative(-100.0f, 0.0f, -170.0f, 70.5f)
                reflectiveQuadTo(240.0f, 482.0f)
                quadToRelative(0.0f, 26.0f, 6.0f, 51.0f)
                reflectiveQuadToRelative(18.0f, 49.0f)
                lineToRelative(-60.0f, 60.0f)
                close()
                moveTo(481.0f, 920.0f)
                lineTo(321.0f, 760.0f)
                lineToRelative(160.0f, -160.0f)
                lineToRelative(56.0f, 56.0f)
                lineToRelative(-64.0f, 64.0f)
                horizontalLineToRelative(7.0f)
                quadToRelative(100.0f, 0.0f, 170.0f, -70.5f)
                reflectiveQuadTo(720.0f, 478.0f)
                quadToRelative(0.0f, -26.0f, -6.0f, -51.0f)
                reflectiveQuadToRelative(-18.0f, -49.0f)
                lineToRelative(60.0f, -60.0f)
                quadToRelative(22.0f, 38.0f, 33.0f, 78.0f)
                reflectiveQuadToRelative(11.0f, 82.0f)
                quadToRelative(0.0f, 134.0f, -93.0f, 228.0f)
                reflectiveQuadToRelative(-227.0f, 94.0f)
                horizontalLineToRelative(-7.0f)
                lineToRelative(64.0f, 64.0f)
                lineToRelative(-56.0f, 56.0f)
                close()
            }
        }
        .build()
        return _changeSide!!
    }

private var _changeSide: ImageVector? = null
