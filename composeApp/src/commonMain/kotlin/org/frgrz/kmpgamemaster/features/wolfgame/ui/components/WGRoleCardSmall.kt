package org.frgrz.kmpgamemaster.features.wolfgame.ui.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.frgrz.kmpgamemaster.data.entities.WGRole


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
