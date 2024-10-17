package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import org.frgrz.kmpgamemaster.material.components.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Remove


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
fun AddRemoveRow(model: AddRemoveRowModel, modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
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

