package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGRoleCard
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGRoleFilterCard
import org.frgrz.kmpgamemaster.material.components.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.SelectAll

class WGRolesScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = getScreenModel<WGRoleViewModel>()
        val filteredRoles by viewModel.filteredRoles //TODO Move to ViewModel

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Roles") },
                    actions = {
                        IconButton(
                            onClick = { viewModel.onToggleAllClicked() },
                        ) {
                            Icon(imageVector = IconPack.SelectAll, contentDescription = "")
                        }
                    })
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

                            val isFilterSelected = viewModel.selectedFilterIndex.value ==
                                    viewModel.filters.indexOf(filter)

                           val backgroundColor= if (isFilterSelected) {
                                MaterialTheme.colorScheme.primaryContainer
                            } else {
                                MaterialTheme.colorScheme.onPrimaryContainer
                            }

                            val textColor = if (isFilterSelected) {
                                MaterialTheme.colorScheme.onPrimaryContainer
                            } else {
                                MaterialTheme.colorScheme.primaryContainer
                            }

                            WGRoleFilterCard(filter, backgroundColor, textColor) {
                                viewModel.onFilterSelected(filter)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    filteredRoles.DisplayResult(
                        onLoading = { /*TODO*/ },
                        onError = { /*TODO*/ },
                        onSuccess = { items ->
                            if (items.isNotEmpty()) {
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(3),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                    modifier = Modifier.padding(12.dp)
                                ) {
                                    itemsIndexed(items = items, key = { _, item -> item.role }) { _, item ->
                                        WGRoleCard(item) { model, isChecked ->
                                            viewModel.onRoleCheckedChanged(model,isChecked)
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
