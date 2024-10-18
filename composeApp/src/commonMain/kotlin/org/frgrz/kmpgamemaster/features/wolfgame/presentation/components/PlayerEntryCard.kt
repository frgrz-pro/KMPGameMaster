package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.frgrz.kmpgamemaster.material.components.IconPack
import org.frgrz.kmpgamemaster.material.components.icons.Remove

data class PlayerEntryCardModel(
    val text: String,
    val index: Int,
    val onDelete: (Int) -> Unit
)

@Composable
fun PlayerEntryCard(text: String, index: Int, onDelete: (Int) -> Unit) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 0.dp, vertical = 2.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.onTertiaryContainer)
                .padding(horizontal = 4.dp, vertical = 2.dp)

        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = text,
                    modifier = Modifier.weight(1f)
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically),

                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.tertiaryContainer
                )

                IconButton(
                    onClick = { onDelete.invoke(index) },
                    modifier = Modifier
                        .size(48.dp) // Set size for square shape
                        .aspectRatio(1f) // Ensure aspect ratio for square
                        .padding(start = 16.dp)

                ) {
                    Icon(
                        imageVector = IconPack.Remove, // Replace with your icon
                        contentDescription = "More options",
                        tint = MaterialTheme.colorScheme.tertiaryContainer
                    )
                }
            }
        }
    }
}