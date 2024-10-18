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

public val IconPack.Protect: ImageVector
    get() {
        if (_protect != null) {
            return _protect!!
        }
        _protect = Builder(name = "Protect", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 880.0f)
                quadToRelative(-139.0f, -35.0f, -229.5f, -159.5f)
                reflectiveQuadTo(160.0f, 444.0f)
                verticalLineToRelative(-244.0f)
                lineToRelative(320.0f, -120.0f)
                lineToRelative(320.0f, 120.0f)
                verticalLineToRelative(244.0f)
                quadToRelative(0.0f, 152.0f, -90.5f, 276.5f)
                reflectiveQuadTo(480.0f, 880.0f)
                close()
                moveTo(480.0f, 796.0f)
                quadToRelative(97.0f, -30.0f, 162.0f, -118.5f)
                reflectiveQuadTo(718.0f, 480.0f)
                lineTo(480.0f, 480.0f)
                verticalLineToRelative(-315.0f)
                lineToRelative(-240.0f, 90.0f)
                verticalLineToRelative(207.0f)
                quadToRelative(0.0f, 7.0f, 2.0f, 18.0f)
                horizontalLineToRelative(238.0f)
                verticalLineToRelative(316.0f)
                close()
            }
        }
        .build()
        return _protect!!
    }

private var _protect: ImageVector? = null
