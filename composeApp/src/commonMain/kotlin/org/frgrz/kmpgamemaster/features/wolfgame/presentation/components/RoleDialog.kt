package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.assassin
import kmpgamemaster.composeapp.generated.resources.assassin_action
import kmpgamemaster.composeapp.generated.resources.assassin_action_desc
import kmpgamemaster.composeapp.generated.resources.assassin_large
import kmpgamemaster.composeapp.generated.resources.close
import kmpgamemaster.composeapp.generated.resources.plays_solo
import kmpgamemaster.composeapp.generated.resources.wins_solo
import org.frgrz.kmpgamemaster.material.components.icons.CancelRole
import org.frgrz.kmpgamemaster.material.components.icons.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Kill
import org.frgrz.kmpgamemaster.material.components.icons.Team
import org.frgrz.kmpgamemaster.material.components.icons.Win
import org.frgrz.kmpgamemaster.material.theme.AppTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


data class RoleDialogViewModel(
    val name: StringResource,
    val imageDrawableResource: DrawableResource,
    val playsWith: StringResource,
    val winConditions: List<RoleActionItemViewModel>,
    val cancels: String,
    val actions: List<RoleActionItemViewModel>,
) {

    var onDialogDismissRequested: () -> Unit = {}
        private set

    fun setOnDialogDismissRequested(onDialogDismissRequested: () -> Unit) {
        this.onDialogDismissRequested = onDialogDismissRequested
    }
}

@Composable
fun RoleDialog(viewModel: RoleDialogViewModel) {
    Dialog(
        onDismissRequest = { viewModel.onDialogDismissRequested.invoke() },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
        content = {
            Card(modifier = Modifier.padding(24.dp)) {
                ConstraintLayout(
                    modifier = Modifier.padding(top = 24.dp)
                        .fillMaxWidth()
                ) {
                    val image = createRef()
                    val title = createRef()
                    val actions = createRef()
                    val button = createRef()

                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.width(120.dp)
                            .aspectRatio(1f)
                            .constrainAs(image) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        val imagePainter = painterResource(viewModel.imageDrawableResource)
                        Image(
                            painter = imagePainter,
                            contentDescription = "My Image", //TODO String resource
                            modifier = Modifier.fillMaxSize()
                                .aspectRatio(1f)
                        )
                    }

                    Text(
                        text = stringResource(viewModel.name),
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 4.dp)
                            .constrainAs(title) {
                                top.linkTo(image.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }

                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                            .constrainAs(actions) {
                                top.linkTo(title.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Icon(
                                imageVector = IconPack.Team,
                                modifier = Modifier.height(24.dp)
                                    .aspectRatio(1f),
                                contentDescription = ""
                            )
                            Text(
                                stringResource(viewModel.playsWith),
                                modifier = Modifier.padding(start = 8.dp)
                                    .align(Alignment.CenterVertically),

                                style = MaterialTheme.typography.titleMedium,
                            )
                        }

                        viewModel.winConditions.forEach {
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Icon(
                                    imageVector = it.icon,
                                    modifier = Modifier.height(24.dp)
                                        .aspectRatio(1f),
                                    contentDescription = ""
                                )

                                //TODO Display points
                                Text(
                                    stringResource(it.name),
                                    modifier = Modifier.padding(start = 8.dp)
                                        .align(Alignment.CenterVertically),
                                    style = MaterialTheme.typography.titleMedium,
                                )
                            }
                        }

                        if (viewModel.cancels.isNotEmpty()) {

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Icon(
                                    imageVector = IconPack.CancelRole,
                                    modifier = Modifier.height(24.dp)
                                        .aspectRatio(1f),
                                    contentDescription = ""
                                )

                                Text(
                                    viewModel.cancels,
                                    modifier = Modifier.padding(start = 8.dp)
                                        .align(Alignment.CenterVertically),
                                    style = MaterialTheme.typography.titleMedium,
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        viewModel.actions.forEach {
                            RoleActionItem(it)
                        }
                    }

                    Button(
                        onClick = { viewModel.onDialogDismissRequested.invoke() },
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .constrainAs(button) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                top.linkTo(actions.bottom)
                            }) {
                        Text(stringResource(Res.string.close))
                    }
                }
            }
        }
    )
}


@Composable
@Preview
fun RoleDialog_Preview() {


    val roleActionItemViewModel = RoleActionItemViewModel(
        Res.string.assassin_action,
        Res.string.assassin_action_desc,
        IconPack.Kill,
    )

    val winConditions = listOf(
        RoleActionItemViewModel(
            Res.string.wins_solo,
            null,
            IconPack.Win,
        )
    )

    val roleDialogViewModel = RoleDialogViewModel(
        Res.string.assassin,
        Res.drawable.assassin_large,
        Res.string.plays_solo,
        winConditions,
        "Immunisé contre les Loups.",
        listOf(roleActionItemViewModel)
    )


    AppTheme {
        RoleDialog(roleDialogViewModel)
    }
}