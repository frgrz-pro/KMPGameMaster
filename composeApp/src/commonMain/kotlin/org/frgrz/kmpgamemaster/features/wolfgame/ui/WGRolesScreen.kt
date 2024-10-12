package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import org.frgrz.kmpgamemaster.data.mappers.WGRoleAction
import org.frgrz.kmpgamemaster.features.wolfgame.models.WGRoleModel
import org.frgrz.kmpgamemaster.features.wolfgame.ui.components.getLargeImageRes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class WGRolesScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = getScreenModel<WGRoleViewModel>()
        val filteredRoles by viewModel.filteredRoles

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Roles") })
            }
        ) { innerPadding ->

            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val column = createRef()

                Column(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight()
                        .padding(innerPadding)
                        .constrainAs(column) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                ) {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(viewModel.filters) { filter ->
                            Card(
                                shape = RoundedCornerShape(6.dp),
                                modifier = Modifier
                                    .clickable {
                                        viewModel.onFilterSelected(filter)
                                    },
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(
                                            if (viewModel.selectedFilterIndex.value ==
                                                viewModel.filters.indexOf(filter)
                                            ) {
                                                MaterialTheme.colorScheme.primaryContainer
                                            } else {
                                                MaterialTheme.colorScheme.onPrimaryContainer
                                            }
                                        )
                                ) {
                                    Text(
                                        text = filter.name,
                                        style = MaterialTheme.typography.titleMedium,
                                        modifier = Modifier
                                            .padding(
                                                start = 12.dp,
                                                end = 12.dp,
                                                top = 6.dp,
                                                bottom = 6.dp
                                            ),
                                        color = if (viewModel.selectedFilterIndex.value ==
                                            viewModel.filters.indexOf(filter)
                                        ) {
                                            MaterialTheme.colorScheme.onPrimaryContainer
                                        } else {
                                            MaterialTheme.colorScheme.primaryContainer
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    filteredRoles.DisplayResult(
                        onLoading = { /*TODO*/ },
                        onError = { /*TODO*/ },
                        onSuccess = {
                            if (it.isNotEmpty()) {

                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(3),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                    modifier = Modifier.padding(12.dp)
                                ) {
                                    itemsIndexed(it) { index, item ->
                                        RoleCard(item)
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun RoleCard(model: WGRoleModel) {

    var showDialog by remember { mutableStateOf(false) }


    Card(

        onClick = { showDialog = true },
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
                painter = painterResource(getLargeImageRes(model.role)),
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
                checked = model.isSelected,
                onCheckedChange = { _ -> },
                modifier = Modifier.constrainAs(checkbox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )

            Text(
                text = stringResource(model.name),
                color = MaterialTheme.colorScheme.tertiaryContainer,
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onTertiaryContainer)
                    .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
                    .constrainAs(text) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(image.bottom)
                    }

            )
        }
    }

    if (showDialog) {
        Dialog(
            onDismissRequest = { showDialog = false },
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
                            Image(
                                painter = painterResource(getLargeImageRes(model.role)),
                                contentDescription = "",
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
                            getBadge(model.playsWith.name,
                                MaterialTheme.colorScheme.primaryContainer,
                                MaterialTheme.colorScheme.onPrimaryContainer)
                            Spacer(modifier = Modifier.width(4.dp))
                            getBadge(model.winsWith.name,
                                MaterialTheme.colorScheme.secondaryContainer,
                                MaterialTheme.colorScheme.onSecondaryContainer)
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
                                RoleActionItem(it)
                            }
                        }

                        Button(
                            onClick = { showDialog = false },
                            modifier = Modifier
                                .padding(bottom = 12.dp, top = 12.dp)
                                .constrainAs(button) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    bottom.linkTo(parent.bottom)
                                    top.linkTo(actions.bottom)
                                }) {
                            Text("Fermer")
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun getBadge(displayText: String, containerColor:Color, textColor: Color) {
    Card(
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .background(containerColor)
        ) {
            Text(
                text = displayText,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        end = 4.dp,
                        top = 2.dp,
                        bottom = 2.dp
                    ),
                color = textColor
            )
        }
    }
}

@Composable
fun RoleActionItem(roleAction: WGRoleAction) {
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
                text = roleAction.name,
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
                text = roleAction.desc,
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