package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleFilter


@Composable
fun WGRoleFilterCard(
    filter: RoleFilter,
    backgroundColor: Color,
    textColor: Color,
    onFilterSelected: (RoleFilter) -> Unit,
) {

    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .clickable {
                onFilterSelected.invoke(filter)
            },
    ) {
        Box(modifier = Modifier.background(backgroundColor)) {
            Text(
                text = filter.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                color = textColor
            )
        }
    }
}
