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

public val IconPack.Transform: ImageVector
    get() {
        if (_transform != null) {
            return _transform!!
        }
        _transform = Builder(name = "Transform", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 680.0f)
                quadToRelative(66.0f, 0.0f, 113.0f, -47.0f)
                reflectiveQuadToRelative(47.0f, -113.0f)
                lineTo(320.0f, 520.0f)
                quadToRelative(0.0f, 66.0f, 47.0f, 113.0f)
                reflectiveQuadToRelative(113.0f, 47.0f)
                close()
                moveTo(280.0f, 360.0f)
                horizontalLineToRelative(160.0f)
                quadToRelative(0.0f, -33.0f, -23.5f, -56.5f)
                reflectiveQuadTo(360.0f, 280.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, 23.5f)
                reflectiveQuadTo(280.0f, 360.0f)
                close()
                moveTo(520.0f, 360.0f)
                horizontalLineToRelative(160.0f)
                quadToRelative(0.0f, -33.0f, -23.5f, -56.5f)
                reflectiveQuadTo(600.0f, 280.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, 23.5f)
                reflectiveQuadTo(520.0f, 360.0f)
                close()
                moveTo(480.0f, 880.0f)
                quadToRelative(-75.0f, 0.0f, -140.5f, -28.5f)
                reflectiveQuadToRelative(-114.0f, -77.0f)
                quadToRelative(-48.5f, -48.5f, -77.0f, -114.0f)
                reflectiveQuadTo(120.0f, 520.0f)
                verticalLineToRelative(-440.0f)
                horizontalLineToRelative(720.0f)
                verticalLineToRelative(440.0f)
                quadToRelative(0.0f, 75.0f, -28.5f, 140.5f)
                reflectiveQuadToRelative(-77.0f, 114.0f)
                quadToRelative(-48.5f, 48.5f, -114.0f, 77.0f)
                reflectiveQuadTo(480.0f, 880.0f)
                close()
                moveTo(480.0f, 800.0f)
                quadToRelative(116.0f, 0.0f, 198.0f, -82.0f)
                reflectiveQuadToRelative(82.0f, -198.0f)
                verticalLineToRelative(-360.0f)
                lineTo(200.0f, 160.0f)
                verticalLineToRelative(360.0f)
                quadToRelative(0.0f, 116.0f, 82.0f, 198.0f)
                reflectiveQuadToRelative(198.0f, 82.0f)
                close()
                moveTo(480.0f, 480.0f)
                close()
            }
        }
        .build()
        return _transform!!
    }

private var _transform: ImageVector? = null
