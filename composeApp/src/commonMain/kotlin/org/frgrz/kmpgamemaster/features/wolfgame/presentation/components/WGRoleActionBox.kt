package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import org.frgrz.kmpgamemaster.material.theme.AppTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

data class RoleActionItemViewModel(
    val name: StringResource,
    val desc: StringResource?,
    val icon: ImageVector
)


@Composable
fun RoleActionItem(viewModel: RoleActionItemViewModel) {
    Box(
        modifier = Modifier.padding(bottom = 12.dp)
    ) {
        ConstraintLayout {
            val row = createRef()
            val desc = createRef()

            Row (
                modifier = Modifier.constrainAs(row) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            ){
                Icon(
                    imageVector = viewModel.icon,
                    contentDescription = "",
                    modifier = Modifier
                        .width(32.dp)
                        .aspectRatio(1f)
                )

                Text(
                    text = stringResource(viewModel.name),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .height(32.dp)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }


            viewModel.desc?.let {
                Text(
                    text = stringResource(viewModel.desc),
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .constrainAs(desc) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(row.bottom)
                        },
                    textAlign = TextAlign.Justify,

                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

        }
    }
}

//TODO Fix Preview Data

@Composable
@Preview
fun WGRoleActionItem_Preview() {
    /*AppTheme {
        RoleActionItem(PreviewData.roleActionItemViewModel)
    }*/
}
