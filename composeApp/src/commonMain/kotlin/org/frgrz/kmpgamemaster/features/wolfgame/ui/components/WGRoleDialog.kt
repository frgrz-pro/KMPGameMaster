package org.frgrz.kmpgamemaster.features.wolfgame.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.jetbrains.compose.resources.stringResource


@Composable
fun WGRoleDialog(model: WGRoleModel, onDialogDismissRequested:(Boolean)->Unit) {
    Dialog(
        onDismissRequest = { onDialogDismissRequested.invoke(false) },
        content = {
            Card(modifier = Modifier.padding(24.dp)) {
                ConstraintLayout(
                    modifier = Modifier.padding(top = 12.dp)
                        .width(360.dp)
                ) {
                    val image = createRef()
                    val button = createRef()
                    val text = createRef()
                    val badgeRow = createRef()
                    val actions = createRef()

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
                        WGRoleImageLarge(
                            role = model.role,
                            modifier = Modifier.fillMaxSize()
                                .aspectRatio(1f)
                        )
                    }

                    Text(
                        text = stringResource(model.name),
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 4.dp)
                            .constrainAs(text) {
                                top.linkTo(image.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }

                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(badgeRow) {
                                top.linkTo(text.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }) {
                        TextBadge(
                            model.playsWith.name,
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        TextBadge(
                            model.winsWith.name,
                            MaterialTheme.colorScheme.secondaryContainer,
                            MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp, end = 12.dp, top = 24.dp)
                            .constrainAs(actions) {
                                top.linkTo(badgeRow.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        model.actions.forEach {
                            WGRoleActionItem(it)
                        }
                    }

                    Button(
                        onClick = { onDialogDismissRequested.invoke(false) },
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .constrainAs(button) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                top.linkTo(actions.bottom)
                            }) {
                        Text("Fermer") //TODO Add String
                    }
                }
            }
        }
    )
}