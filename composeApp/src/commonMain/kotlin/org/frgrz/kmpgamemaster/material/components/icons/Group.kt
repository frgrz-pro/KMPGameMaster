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

public val IconPack.Group: ImageVector
    get() {
        if (_group != null) {
            return _group!!
        }
        _group = Builder(name = "Group", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(40.0f, 800.0f)
                verticalLineToRelative(-112.0f)
                quadToRelative(0.0f, -34.0f, 17.5f, -62.5f)
                reflectiveQuadTo(104.0f, 582.0f)
                quadToRelative(62.0f, -31.0f, 126.0f, -46.5f)
                reflectiveQuadTo(360.0f, 520.0f)
                quadToRelative(66.0f, 0.0f, 130.0f, 15.5f)
                reflectiveQuadTo(616.0f, 582.0f)
                quadToRelative(29.0f, 15.0f, 46.5f, 43.5f)
                reflectiveQuadTo(680.0f, 688.0f)
                verticalLineToRelative(112.0f)
                lineTo(40.0f, 800.0f)
                close()
                moveTo(760.0f, 800.0f)
                verticalLineToRelative(-120.0f)
                quadToRelative(0.0f, -44.0f, -24.5f, -84.5f)
                reflectiveQuadTo(666.0f, 526.0f)
                quadToRelative(51.0f, 6.0f, 96.0f, 20.5f)
                reflectiveQuadToRelative(84.0f, 35.5f)
                quadToRelative(36.0f, 20.0f, 55.0f, 44.5f)
                reflectiveQuadToRelative(19.0f, 53.5f)
                verticalLineToRelative(120.0f)
                lineTo(760.0f, 800.0f)
                close()
                moveTo(360.0f, 480.0f)
                quadToRelative(-66.0f, 0.0f, -113.0f, -47.0f)
                reflectiveQuadToRelative(-47.0f, -113.0f)
                quadToRelative(0.0f, -66.0f, 47.0f, -113.0f)
                reflectiveQuadToRelative(113.0f, -47.0f)
                quadToRelative(66.0f, 0.0f, 113.0f, 47.0f)
                reflectiveQuadToRelative(47.0f, 113.0f)
                quadToRelative(0.0f, 66.0f, -47.0f, 113.0f)
                reflectiveQuadToRelative(-113.0f, 47.0f)
                close()
                moveTo(760.0f, 320.0f)
                quadToRelative(0.0f, 66.0f, -47.0f, 113.0f)
                reflectiveQuadToRelative(-113.0f, 47.0f)
                quadToRelative(-11.0f, 0.0f, -28.0f, -2.5f)
                reflectiveQuadToRelative(-28.0f, -5.5f)
                quadToRelative(27.0f, -32.0f, 41.5f, -71.0f)
                reflectiveQuadToRelative(14.5f, -81.0f)
                quadToRelative(0.0f, -42.0f, -14.5f, -81.0f)
                reflectiveQuadTo(544.0f, 168.0f)
                quadToRelative(14.0f, -5.0f, 28.0f, -6.5f)
                reflectiveQuadToRelative(28.0f, -1.5f)
                quadToRelative(66.0f, 0.0f, 113.0f, 47.0f)
                reflectiveQuadToRelative(47.0f, 113.0f)
                close()
                moveTo(120.0f, 720.0f)
                horizontalLineToRelative(480.0f)
                verticalLineToRelative(-32.0f)
                quadToRelative(0.0f, -11.0f, -5.5f, -20.0f)
                reflectiveQuadTo(580.0f, 654.0f)
                quadToRelative(-54.0f, -27.0f, -109.0f, -40.5f)
                reflectiveQuadTo(360.0f, 600.0f)
                quadToRelative(-56.0f, 0.0f, -111.0f, 13.5f)
                reflectiveQuadTo(140.0f, 654.0f)
                quadToRelative(-9.0f, 5.0f, -14.5f, 14.0f)
                reflectiveQuadToRelative(-5.5f, 20.0f)
                verticalLineToRelative(32.0f)
                close()
                moveTo(360.0f, 400.0f)
                quadToRelative(33.0f, 0.0f, 56.5f, -23.5f)
                reflectiveQuadTo(440.0f, 320.0f)
                quadToRelative(0.0f, -33.0f, -23.5f, -56.5f)
                reflectiveQuadTo(360.0f, 240.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, 23.5f)
                reflectiveQuadTo(280.0f, 320.0f)
                quadToRelative(0.0f, 33.0f, 23.5f, 56.5f)
                reflectiveQuadTo(360.0f, 400.0f)
                close()
                moveTo(360.0f, 720.0f)
                close()
                moveTo(360.0f, 320.0f)
                close()
            }
        }
        .build()
        return _group!!
    }

private var _group: ImageVector? = null
