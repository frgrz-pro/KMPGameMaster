package org.frgrz.kmpgamemaster.features.wolfgame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class WGRolesScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<WGRoleViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Roles") })
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(innerPadding)
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(viewModel.filters) { filter ->
                        Text(
                            text = filter.name,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.Gray)
                                .padding(start = 12.dp, end = 12.dp, top = 6.dp, bottom = 6.dp)

                        )
                    }

                    /* item {

                     }*/
                }
            }
        }
    }
}

//                    Text(
//                        text = "Filter",
//                        modifier = Modifier
//                                .clickable {
//                                    viewModel.selectedFilterIndex.value =
//                                        viewModel.filters.indexOf(filter)
//                                }
//                                .background(
//                                    if (viewModel.selectedFilterIndex.value == viewModel.filters.indexOf(
//                                            filter
//                                        )
//                                    ) {
//                                        Color.LightGray
//                                    } else {
//                                        Color.Transparent
//                                    }
//                                )
//                            .padding(8.dp)
//                    )
//                }
//                    items(viewModel.filters) { filter ->
//                        Text(
//                            text = filter.name,
//                            modifier = Modifier
//                                .clickable {
//                                    viewModel.selectedFilterIndex.value =
//                                        viewModel.filters.indexOf(filter)
//                                }
//                                .background(
//                                    if (viewModel.selectedFilterIndex.value == viewModel.filters.indexOf(
//                                            filter
//                                        )
//                                    ) {
//                                        Color.LightGray
//                                    } else {
//                                        Color.Transparent
//                                    }
//                                )
//                                .padding(8.dp)
//                        )
//                    }
//                }
//            }
//        }
//    }

