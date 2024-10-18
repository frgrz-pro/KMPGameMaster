package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AddPlayerField(text: String, onValueChanged: (String) -> Unit, onAddButtonClicked: () -> Unit) {

    Row {
        TextField(
            value = text,
            onValueChange = onValueChanged,
            label = { Text("Nouveau Joueur") },
            modifier = Modifier.weight(1f)
                .background(MaterialTheme.colorScheme.background),
            maxLines = 1,

            )

        IconButton(
            onClick = onAddButtonClicked,
            modifier = Modifier
                .size(48.dp) // Set size for square shape
                .aspectRatio(1f) // Ensure aspect ratio for square
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = Icons.Filled.Add, // Replace with your icon
                contentDescription = "More options",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
