package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.WGRole


@Composable
fun WGRoleCardSmall(role: WGRole, onCardClicked: () -> Unit) {
    Card(
        onClick = {
            onCardClicked.invoke()
        },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        WGRoleImageMedium(
            role = role,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun WGRoleExtrasCardSmall(count: Int) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Text(
                text = "+$count",

                modifier = Modifier
                    .align(Alignment.Center),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
    }
}
