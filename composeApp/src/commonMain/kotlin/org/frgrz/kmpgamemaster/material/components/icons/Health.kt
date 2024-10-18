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

public val IconPack.Health: ImageVector
    get() {
        if (_health != null) {
            return _health!!
        }
        _health = Builder(name = "Health", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(280.0f, 880.0f)
                verticalLineToRelative(-200.0f)
                lineTo(80.0f, 680.0f)
                verticalLineToRelative(-400.0f)
                horizontalLineToRelative(200.0f)
                verticalLineToRelative(-200.0f)
                horizontalLineToRelative(400.0f)
                verticalLineToRelative(200.0f)
                horizontalLineToRelative(200.0f)
                verticalLineToRelative(400.0f)
                lineTo(680.0f, 680.0f)
                verticalLineToRelative(200.0f)
                lineTo(280.0f, 880.0f)
                close()
                moveTo(160.0f, 440.0f)
                horizontalLineToRelative(200.0f)
                quadToRelative(10.0f, 0.0f, 19.0f, 5.0f)
                reflectiveQuadToRelative(14.0f, 13.0f)
                lineToRelative(35.0f, 52.0f)
                lineToRelative(54.0f, -162.0f)
                quadToRelative(4.0f, -12.0f, 14.5f, -20.0f)
                reflectiveQuadToRelative(23.5f, -8.0f)
                quadToRelative(10.0f, 0.0f, 19.0f, 5.0f)
                reflectiveQuadToRelative(14.0f, 13.0f)
                lineToRelative(68.0f, 102.0f)
                horizontalLineToRelative(179.0f)
                verticalLineToRelative(-80.0f)
                lineTo(600.0f, 360.0f)
                verticalLineToRelative(-200.0f)
                lineTo(360.0f, 160.0f)
                verticalLineToRelative(200.0f)
                lineTo(160.0f, 360.0f)
                verticalLineToRelative(80.0f)
                close()
                moveTo(360.0f, 800.0f)
                horizontalLineToRelative(240.0f)
                verticalLineToRelative(-200.0f)
                horizontalLineToRelative(200.0f)
                verticalLineToRelative(-80.0f)
                lineTo(600.0f, 520.0f)
                quadToRelative(-10.0f, 0.0f, -19.0f, -5.0f)
                reflectiveQuadToRelative(-15.0f, -13.0f)
                lineToRelative(-34.0f, -52.0f)
                lineToRelative(-54.0f, 162.0f)
                quadToRelative(-4.0f, 12.0f, -15.0f, 20.0f)
                reflectiveQuadToRelative(-24.0f, 8.0f)
                quadToRelative(-10.0f, 0.0f, -19.0f, -5.0f)
                reflectiveQuadToRelative(-14.0f, -13.0f)
                lineToRelative(-68.0f, -102.0f)
                lineTo(160.0f, 520.0f)
                verticalLineToRelative(80.0f)
                horizontalLineToRelative(200.0f)
                verticalLineToRelative(200.0f)
                close()
                moveTo(480.0f, 480.0f)
                close()
            }
        }
        .build()
        return _health!!
    }

private var _health: ImageVector? = null
