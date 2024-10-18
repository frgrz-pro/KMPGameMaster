package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.jetbrains.compose.resources.stringResource

data class RoleCardViewModel(
    val model: WGRoleModel,
    val onWGRoleSelected: (WGRoleModel, Boolean) -> Unit,
) {

    val showDialog: MutableState<Boolean> = mutableStateOf(false)

    val roleDialogViewModel: RoleDialogViewModel = RoleDialogViewModel(
        model = model,
        onDialogDismissRequested = { showDialog.value = false }
    )

    fun onCardClicked() {
        showDialog.value = true
    }
}


@Composable
fun RoleCard(viewModel: RoleCardViewModel) {

    Card(
        onClick = { viewModel.onCardClicked() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ConstraintLayout {
            val image = createRef()
            val checkbox = createRef()
            val text = createRef()

            WGRoleImageLarge(
                role = viewModel.model.role,
                modifier = Modifier.fillMaxSize()
                    .aspectRatio(1f)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Checkbox(
                checked = viewModel.model.isSelected,
                onCheckedChange = { isChecked ->
                    viewModel.onWGRoleSelected(viewModel.model, isChecked)
                },
                modifier = Modifier.constrainAs(checkbox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )

            Text(
                text = stringResource(viewModel.model.name),
                color = MaterialTheme.colorScheme.tertiaryContainer,
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onTertiaryContainer)
                    .padding(horizontal = 4.dp, vertical = 2.dp)
                    .constrainAs(text) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(image.bottom)
                    }

            )
        }
    }

    if (viewModel.showDialog.value) {
        RoleDialog(viewModel.roleDialogViewModel)
    }
}