package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleAction
import org.frgrz.kmpgamemaster.material.theme.AppTheme
import org.jetbrains.compose.resources.stringResource


//TODO ViewModel
@Composable
fun WGRoleActionBox(roleAction: WGRoleAction) {
    Box(
        modifier = Modifier.padding(bottom = 12.dp)
    ) {
        ConstraintLayout {
            val image = createRef()
            val title = createRef()
            val desc = createRef()

            Box(modifier = Modifier
                .width(24.dp)
                .aspectRatio(1f)
                .background(Color.Red)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

            Text(
                text = stringResource(roleAction.name),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(title) {
                        top.linkTo(image.top)
                        start.linkTo(image.end)
                        end.linkTo(parent.end)
                        bottom.linkTo(image.bottom)
                        width = Dimension.fillToConstraints
                    },
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = stringResource(roleAction.desc),
                modifier = Modifier
                    .padding(top = 6.dp)
                    .constrainAs(desc) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(image.bottom)
                    },
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
@Preview
fun WGRoleActionItem_Preview() {
    AppTheme {
        WGRoleActionBox(PreviewData.rolaAction)
    }
}
