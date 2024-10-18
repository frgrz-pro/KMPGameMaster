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

public val IconPack.AddVote: ImageVector
    get() {
        if (_addVote != null) {
            return _addVote!!
        }
        _addVote = Builder(name = "AddVote", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 760.0f)
                quadToRelative(-117.0f, 0.0f, -198.5f, -81.5f)
                reflectiveQuadTo(40.0f, 480.0f)
                quadToRelative(0.0f, -117.0f, 81.5f, -198.5f)
                reflectiveQuadTo(320.0f, 200.0f)
                horizontalLineToRelative(320.0f)
                quadToRelative(117.0f, 0.0f, 198.5f, 81.5f)
                reflectiveQuadTo(920.0f, 480.0f)
                quadToRelative(0.0f, 117.0f, -81.5f, 198.5f)
                reflectiveQuadTo(640.0f, 760.0f)
                lineTo(320.0f, 760.0f)
                close()
                moveTo(320.0f, 680.0f)
                horizontalLineToRelative(320.0f)
                quadToRelative(83.0f, 0.0f, 141.5f, -58.5f)
                reflectiveQuadTo(840.0f, 480.0f)
                quadToRelative(0.0f, -83.0f, -58.5f, -141.5f)
                reflectiveQuadTo(640.0f, 280.0f)
                lineTo(320.0f, 280.0f)
                quadToRelative(-83.0f, 0.0f, -141.5f, 58.5f)
                reflectiveQuadTo(120.0f, 480.0f)
                quadToRelative(0.0f, 83.0f, 58.5f, 141.5f)
                reflectiveQuadTo(320.0f, 680.0f)
                close()
                moveTo(330.0f, 600.0f)
                horizontalLineToRelative(60.0f)
                verticalLineToRelative(-90.0f)
                horizontalLineToRelative(90.0f)
                verticalLineToRelative(-60.0f)
                horizontalLineToRelative(-90.0f)
                verticalLineToRelative(-90.0f)
                horizontalLineToRelative(-60.0f)
                verticalLineToRelative(90.0f)
                horizontalLineToRelative(-90.0f)
                verticalLineToRelative(60.0f)
                horizontalLineToRelative(90.0f)
                verticalLineToRelative(90.0f)
                close()
                moveTo(620.0f, 600.0f)
                horizontalLineToRelative(60.0f)
                verticalLineToRelative(-240.0f)
                lineTo(560.0f, 360.0f)
                verticalLineToRelative(60.0f)
                horizontalLineToRelative(60.0f)
                verticalLineToRelative(180.0f)
                close()
                moveTo(480.0f, 480.0f)
                close()
            }
        }
        .build()
        return _addVote!!
    }

private var _addVote: ImageVector? = null
