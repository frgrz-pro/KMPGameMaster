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

public val IconPack.Reset: ImageVector
    get() {
        if (_reset != null) {
            return _reset!!
        }
        _reset = Builder(name = "Reset", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(440.0f, 838.0f)
                quadToRelative(-121.0f, -15.0f, -200.5f, -105.5f)
                reflectiveQuadTo(160.0f, 520.0f)
                quadToRelative(0.0f, -66.0f, 26.0f, -126.5f)
                reflectiveQuadTo(260.0f, 288.0f)
                lineToRelative(57.0f, 57.0f)
                quadToRelative(-38.0f, 34.0f, -57.5f, 79.0f)
                reflectiveQuadTo(240.0f, 520.0f)
                quadToRelative(0.0f, 88.0f, 56.0f, 155.5f)
                reflectiveQuadTo(440.0f, 758.0f)
                verticalLineToRelative(80.0f)
                close()
                moveTo(520.0f, 838.0f)
                verticalLineToRelative(-80.0f)
                quadToRelative(87.0f, -16.0f, 143.5f, -83.0f)
                reflectiveQuadTo(720.0f, 520.0f)
                quadToRelative(0.0f, -100.0f, -70.0f, -170.0f)
                reflectiveQuadToRelative(-170.0f, -70.0f)
                horizontalLineToRelative(-3.0f)
                lineToRelative(44.0f, 44.0f)
                lineToRelative(-56.0f, 56.0f)
                lineToRelative(-140.0f, -140.0f)
                lineToRelative(140.0f, -140.0f)
                lineToRelative(56.0f, 56.0f)
                lineToRelative(-44.0f, 44.0f)
                horizontalLineToRelative(3.0f)
                quadToRelative(134.0f, 0.0f, 227.0f, 93.0f)
                reflectiveQuadToRelative(93.0f, 227.0f)
                quadToRelative(0.0f, 121.0f, -79.5f, 211.5f)
                reflectiveQuadTo(520.0f, 838.0f)
                close()
            }
        }
        .build()
        return _reset!!
    }

private var _reset: ImageVector? = null
