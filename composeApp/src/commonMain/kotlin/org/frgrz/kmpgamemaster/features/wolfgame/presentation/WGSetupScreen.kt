package org.frgrz.kmpgamemaster.features.wolfgame.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.more_roles
import kmpgamemaster.composeapp.generated.resources.start_game
import kmpgamemaster.composeapp.generated.resources.werewolf
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGRoleCardSmall
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.components.WGRoleExtrasCardSmall
import org.frgrz.kmpgamemaster.material.components.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Remove
import org.jetbrains.compose.resources.stringResource


class WGSetupScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<WGSetupViewModel>()

        //TODO : viewModel.onPlayerCountChanged(players.size)

        Scaffold(
            topBar = {
                TopAppBar(title = { Text(stringResource(Res.string.werewolf)) })
            },
            content = { innerPadding ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(32.dp)
                ) {
                    Text(
                        text = viewModel.playerLabel.value,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AddRemoveRow(model = viewModel.wolvesModel)

                    Spacer(modifier = Modifier.height(8.dp))

                    AddRemoveRow(model = viewModel.peasantModel)

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Rôles",  //TODO String resource
                            modifier = Modifier.padding(end = 8.dp),
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    viewModel.selectedRoles.value.DisplayResult(
                        onLoading = { /*TODO*/ },
                        onError = { /*TODO*/ },
                        onSuccess = { items ->
                            if (items.isNotEmpty()) {

                                //TODO Move logic to VM
                                val exceedDisplayableLimit = items.size > 15
                                val extraItems = items.size - 15
                                val displayedItems = if (exceedDisplayableLimit) {
                                    items.subList(0, 15)
                                } else {
                                    items
                                }

                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(5),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                    modifier = Modifier.padding(12.dp)
                                ) {
                                    itemsIndexed(displayedItems) { index, item ->
                                        if (extraItems > 0 && index == displayedItems.lastIndex) {
                                            WGRoleExtrasCardSmall(extraItems)
                                        } else {
                                            //TODO Add tooltip
                                            WGRoleCardSmall(item.role) {}
                                        }
                                    }
                                }
                            }
                        }
                    )

                    TextButton(
                        onClick = {
                            navigator.push(WGRolesScreen())
                        },
                    ) {
                        Text(
                            text = stringResource(Res.string.more_roles),
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                    Spacer(modifier = Modifier.height(48.dp))

                    OutlinedButton(
                        onClick = {
                            navigator.push(WGPlayersScreen())
                        },
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 6.dp)
                    ) {
                        Text(
                            text = "Modifier les joueurs",  //TODO String resource
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    FilledTonalButton(
                        onClick = {
                            viewModel.saveGameSettings()
                            navigator.push(WGGameScreen())
                        },
                        modifier = Modifier.fillMaxWidth()
                            .padding(6.dp),
                        enabled = viewModel.canStartGame.value
                    ) {
                        Text(
                            text = stringResource(Res.string.start_game),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        )
    }
}

data class AddRemoveRowModel(
    val count: MutableState<Int> = mutableStateOf(1),
    val label: MutableState<String> = mutableStateOf(""),
    val canAdd: MutableState<Boolean> = mutableStateOf(true),
    val canRemove: MutableState<Boolean> = mutableStateOf(false),
    val unit: String = "",
    val canAddRule: () -> Boolean,
    val canRemoveRule: () -> Boolean,
    val onCountChanged: (Int) -> Unit,
) {

    init {
        updateCount(count.value)
    }

    fun onRemoveClicked() {
        if (!canRemove.value)
            return

        updateCount(count.value - 1)
    }

    fun onAddClicked() {
        if (!canAdd.value)
            return

        updateCount(count.value + 1)
    }

    fun updateCount(newCount: Int) {
        count.value = newCount
        onCountChanged.invoke(count.value)
        label.value = "${count.value} $unit"
        updateAddRemove()
    }

    private fun updateAddRemove() {
        canAdd.value = canAddRule.invoke()
        canRemove.value = canRemoveRule.invoke()
    }

}

@Composable
fun AddRemoveRow(model: AddRemoveRowModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = { model.onRemoveClicked() },
            enabled = model.canRemove.value
        ) {
            val icon = rememberVectorPainter(image = IconPack.Remove)
            Icon(
                painter = icon,
                contentDescription = "Remove"  //TODO String resource
            )
        }

        Text(
            text = model.label.value,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            style = MaterialTheme.typography.titleLarge
        )

        IconButton(
            onClick = { model.onAddClicked() },
            enabled = model.canAdd.value
        ) {
            val icon = rememberVectorPainter(image = Icons.Filled.Add)
            Icon(
                painter = icon,
                contentDescription = "Remove"  //TODO String resource
            )
        }
    }
}

