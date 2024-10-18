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
import kmpgamemaster.composeapp.generated.resources.Res
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRoleModel
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.stringResource
import kmpgamemaster.composeapp.generated.resources.angel_large
import kmpgamemaster.composeapp.generated.resources.angel_medium
import kmpgamemaster.composeapp.generated.resources.assassin_large
import kmpgamemaster.composeapp.generated.resources.assassin_medium
import kmpgamemaster.composeapp.generated.resources.astronomist_large
import kmpgamemaster.composeapp.generated.resources.astronomist_medium
import kmpgamemaster.composeapp.generated.resources.bear_handler_large
import kmpgamemaster.composeapp.generated.resources.bear_handler_medium
import kmpgamemaster.composeapp.generated.resources.berserk_large
import kmpgamemaster.composeapp.generated.resources.berserk_medium
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_large
import kmpgamemaster.composeapp.generated.resources.big_bad_wolf_medium
import kmpgamemaster.composeapp.generated.resources.black_wolf_large
import kmpgamemaster.composeapp.generated.resources.black_wolf_medium
import kmpgamemaster.composeapp.generated.resources.blacksmith_large
import kmpgamemaster.composeapp.generated.resources.blacksmith_medium
import kmpgamemaster.composeapp.generated.resources.blue_wolf_large
import kmpgamemaster.composeapp.generated.resources.blue_wolf_medium
import kmpgamemaster.composeapp.generated.resources.bully_large
import kmpgamemaster.composeapp.generated.resources.bully_medium
import kmpgamemaster.composeapp.generated.resources.cassandre_large
import kmpgamemaster.composeapp.generated.resources.cassandre_medium
import kmpgamemaster.composeapp.generated.resources.comedian_large
import kmpgamemaster.composeapp.generated.resources.comedian_medium
import kmpgamemaster.composeapp.generated.resources.corrupter_large
import kmpgamemaster.composeapp.generated.resources.corrupter_medium
import kmpgamemaster.composeapp.generated.resources.cupid_large
import kmpgamemaster.composeapp.generated.resources.cupid_medium
import kmpgamemaster.composeapp.generated.resources.deflecteur_large
import kmpgamemaster.composeapp.generated.resources.deflecteur_medium
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_large
import kmpgamemaster.composeapp.generated.resources.demoniac_soul_medium
import kmpgamemaster.composeapp.generated.resources.druggist_large
import kmpgamemaster.composeapp.generated.resources.druggist_medium
import kmpgamemaster.composeapp.generated.resources.duelists_large
import kmpgamemaster.composeapp.generated.resources.duelists_medium
import kmpgamemaster.composeapp.generated.resources.fox_large
import kmpgamemaster.composeapp.generated.resources.fox_medium
import kmpgamemaster.composeapp.generated.resources.gentleman_large
import kmpgamemaster.composeapp.generated.resources.gentleman_medium
import kmpgamemaster.composeapp.generated.resources.guard_large
import kmpgamemaster.composeapp.generated.resources.guard_medium
import kmpgamemaster.composeapp.generated.resources.guru_large
import kmpgamemaster.composeapp.generated.resources.guru_medium
import kmpgamemaster.composeapp.generated.resources.hitman_large
import kmpgamemaster.composeapp.generated.resources.hitman_medium
import kmpgamemaster.composeapp.generated.resources.hunter_large
import kmpgamemaster.composeapp.generated.resources.hunter_medium
import kmpgamemaster.composeapp.generated.resources.idiot_large
import kmpgamemaster.composeapp.generated.resources.idiot_medium
import kmpgamemaster.composeapp.generated.resources.little_girl_large
import kmpgamemaster.composeapp.generated.resources.little_girl_medium
import kmpgamemaster.composeapp.generated.resources.marshall_large
import kmpgamemaster.composeapp.generated.resources.marshall_medium
import kmpgamemaster.composeapp.generated.resources.mayor_large
import kmpgamemaster.composeapp.generated.resources.mayor_medium
import kmpgamemaster.composeapp.generated.resources.moon_son_large
import kmpgamemaster.composeapp.generated.resources.moon_son_medium
import kmpgamemaster.composeapp.generated.resources.noctambulist_large
import kmpgamemaster.composeapp.generated.resources.noctambulist_medium
import kmpgamemaster.composeapp.generated.resources.old_knight_large
import kmpgamemaster.composeapp.generated.resources.old_knight_medium
import kmpgamemaster.composeapp.generated.resources.peasant_large
import kmpgamemaster.composeapp.generated.resources.peasant_medium
import kmpgamemaster.composeapp.generated.resources.pied_piper_large
import kmpgamemaster.composeapp.generated.resources.pied_piper_medium
import kmpgamemaster.composeapp.generated.resources.priest_large
import kmpgamemaster.composeapp.generated.resources.priest_medium
import kmpgamemaster.composeapp.generated.resources.pyroman_large
import kmpgamemaster.composeapp.generated.resources.pyroman_medium
import kmpgamemaster.composeapp.generated.resources.ranger_large
import kmpgamemaster.composeapp.generated.resources.ranger_medium
import kmpgamemaster.composeapp.generated.resources.seer_large
import kmpgamemaster.composeapp.generated.resources.seer_medium
import kmpgamemaster.composeapp.generated.resources.sorcerer_large
import kmpgamemaster.composeapp.generated.resources.sorcerer_medium
import kmpgamemaster.composeapp.generated.resources.thief_large
import kmpgamemaster.composeapp.generated.resources.thief_medium
import kmpgamemaster.composeapp.generated.resources.three_brothers_large
import kmpgamemaster.composeapp.generated.resources.three_brothers_medium
import kmpgamemaster.composeapp.generated.resources.traitor_large
import kmpgamemaster.composeapp.generated.resources.traitor_medium
import kmpgamemaster.composeapp.generated.resources.two_sisters_large
import kmpgamemaster.composeapp.generated.resources.two_sisters_medium
import kmpgamemaster.composeapp.generated.resources.village_elder_medium
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_large
import kmpgamemaster.composeapp.generated.resources.white_soothsayer_medium
import kmpgamemaster.composeapp.generated.resources.white_wolf_large
import kmpgamemaster.composeapp.generated.resources.white_wolf_medium
import kmpgamemaster.composeapp.generated.resources.wild_kid_large
import kmpgamemaster.composeapp.generated.resources.wild_kid_medium
import kmpgamemaster.composeapp.generated.resources.wizard_large
import kmpgamemaster.composeapp.generated.resources.wizard_medium
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_large
import kmpgamemaster.composeapp.generated.resources.wolf_berserk_medium
import kmpgamemaster.composeapp.generated.resources.wolf_dog_large
import kmpgamemaster.composeapp.generated.resources.wolf_dog_medium
import kmpgamemaster.composeapp.generated.resources.wolf_fan_large
import kmpgamemaster.composeapp.generated.resources.wolf_fan_medium
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_large
import kmpgamemaster.composeapp.generated.resources.wolf_kitten_medium
import kmpgamemaster.composeapp.generated.resources.wolf_large
import kmpgamemaster.composeapp.generated.resources.wolf_medium

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
