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

public val IconPack.Kill: ImageVector
    get() {
        if (_kill != null) {
            return _kill!!
        }
        _kill = Builder(name = "Kill", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(240.0f, 880.0f)
                verticalLineToRelative(-170.0f)
                quadToRelative(-39.0f, -17.0f, -68.5f, -45.5f)
                reflectiveQuadToRelative(-50.0f, -64.5f)
                quadToRelative(-20.5f, -36.0f, -31.0f, -77.0f)
                reflectiveQuadTo(80.0f, 440.0f)
                quadToRelative(0.0f, -158.0f, 112.0f, -259.0f)
                reflectiveQuadToRelative(288.0f, -101.0f)
                quadToRelative(176.0f, 0.0f, 288.0f, 101.0f)
                reflectiveQuadToRelative(112.0f, 259.0f)
                quadToRelative(0.0f, 42.0f, -10.5f, 83.0f)
                reflectiveQuadToRelative(-31.0f, 77.0f)
                quadToRelative(-20.5f, 36.0f, -50.0f, 64.5f)
                reflectiveQuadTo(720.0f, 710.0f)
                verticalLineToRelative(170.0f)
                lineTo(240.0f, 880.0f)
                close()
                moveTo(320.0f, 800.0f)
                horizontalLineToRelative(40.0f)
                verticalLineToRelative(-80.0f)
                horizontalLineToRelative(80.0f)
                verticalLineToRelative(80.0f)
                horizontalLineToRelative(80.0f)
                verticalLineToRelative(-80.0f)
                horizontalLineToRelative(80.0f)
                verticalLineToRelative(80.0f)
                horizontalLineToRelative(40.0f)
                verticalLineToRelative(-142.0f)
                quadToRelative(38.0f, -9.0f, 67.5f, -30.0f)
                reflectiveQuadToRelative(50.0f, -50.0f)
                quadToRelative(20.5f, -29.0f, 31.5f, -64.0f)
                reflectiveQuadToRelative(11.0f, -74.0f)
                quadToRelative(0.0f, -125.0f, -88.5f, -202.5f)
                reflectiveQuadTo(480.0f, 160.0f)
                quadToRelative(-143.0f, 0.0f, -231.5f, 77.5f)
                reflectiveQuadTo(160.0f, 440.0f)
                quadToRelative(0.0f, 39.0f, 11.0f, 74.0f)
                reflectiveQuadToRelative(31.5f, 64.0f)
                quadToRelative(20.5f, 29.0f, 50.5f, 50.0f)
                reflectiveQuadToRelative(67.0f, 30.0f)
                verticalLineToRelative(142.0f)
                close()
                moveTo(420.0f, 600.0f)
                horizontalLineToRelative(120.0f)
                lineToRelative(-60.0f, -120.0f)
                lineToRelative(-60.0f, 120.0f)
                close()
                moveTo(340.0f, 520.0f)
                quadToRelative(33.0f, 0.0f, 56.5f, -23.5f)
                reflectiveQuadTo(420.0f, 440.0f)
                quadToRelative(0.0f, -33.0f, -23.5f, -56.5f)
                reflectiveQuadTo(340.0f, 360.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, 23.5f)
                reflectiveQuadTo(260.0f, 440.0f)
                quadToRelative(0.0f, 33.0f, 23.5f, 56.5f)
                reflectiveQuadTo(340.0f, 520.0f)
                close()
                moveTo(620.0f, 520.0f)
                quadToRelative(33.0f, 0.0f, 56.5f, -23.5f)
                reflectiveQuadTo(700.0f, 440.0f)
                quadToRelative(0.0f, -33.0f, -23.5f, -56.5f)
                reflectiveQuadTo(620.0f, 360.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, 23.5f)
                reflectiveQuadTo(540.0f, 440.0f)
                quadToRelative(0.0f, 33.0f, 23.5f, 56.5f)
                reflectiveQuadTo(620.0f, 520.0f)
                close()
                moveTo(480.0f, 800.0f)
                close()
            }
        }
        .build()
        return _kill!!
    }

private var _kill: ImageVector? = null
