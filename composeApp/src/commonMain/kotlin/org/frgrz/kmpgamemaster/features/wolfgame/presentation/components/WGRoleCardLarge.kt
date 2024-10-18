package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.foundation.Image
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
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

data class RoleCardViewModel(
    val name: StringResource,
    val role: WGRole,
    val isSelected: MutableState<Boolean>,
    val imageResource: DrawableResource,
    val roleDialogViewModel: RoleDialogViewModel,
) {

    val showDialog: MutableState<Boolean> = mutableStateOf(false)

    var onWGRoleSelected: (WGRole, Boolean) -> Unit = { _, _ -> }
        private set

    init {
        roleDialogViewModel.setOnDialogDismissRequested {
            showDialog.value = false
        }
    }

    fun setOnRoleSelected(onWGRoleSelected: (WGRole, Boolean) -> Unit): RoleCardViewModel {
        this.onWGRoleSelected = onWGRoleSelected
        return this
    }


    fun onCardClicked() {
        showDialog.value = true
    }

    fun onCheckedChanged(isChecked: Boolean) {
        onWGRoleSelected(role, isChecked)

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

            Image(
                painter = painterResource(viewModel.imageResource),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
                    .aspectRatio(1f)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Checkbox(
                checked = viewModel.isSelected.value,
                onCheckedChange = { isChecked ->
                    viewModel.onCheckedChanged(isChecked)
                },
                modifier = Modifier.constrainAs(checkbox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )

            Text(
                text = stringResource(viewModel.name),
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
