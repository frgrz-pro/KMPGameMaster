package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import org.frgrz.kmpgamemaster.features.wolfgame.ui.components.RoleImageLarge

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

                    Spacer(modifier = Modifier.height(8.dp))

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

                                        Card(
                                            onClick = {
                                                /*scope.launch {
                                                    snackbarHostState.showSnackbar(
                                                        message = "${item.role.name} : ${item.isSelected}",
                                                        duration = SnackbarDuration.Short
                                                    )
                                                }*/
                                            },
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 2.dp
                                            ),
                                            shape = RoundedCornerShape(4.dp),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .aspectRatio(1f)
                                        ) {
                                            RoleImageLarge(item.role)
                                        }
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
