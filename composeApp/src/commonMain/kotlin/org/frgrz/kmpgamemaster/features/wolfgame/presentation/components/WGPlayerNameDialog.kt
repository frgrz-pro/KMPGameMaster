package org.frgrz.kmpgamemaster.features.wolfgame.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kmpgamemaster.composeapp.generated.resources.Res
import kmpgamemaster.composeapp.generated.resources.close
import org.frgrz.kmpgamemaster.material.theme.AppTheme
import org.jetbrains.compose.resources.stringResource


data class WGPlayerNameViewModel(
    val name: String,
    val onDismiss: () -> Unit,
)

@Composable
fun WGPlayerNameDialog(viewModel: WGPlayerNameViewModel) {
    Dialog(
        onDismissRequest = viewModel.onDismiss,
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.width(240.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = viewModel.name,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = viewModel.onDismiss,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = stringResource(Res.string.close)

                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun WGPlayerNameDialog_Preview() {
    AppTheme {
        WGPlayerNameDialog(
            WGPlayerNameViewModel(
                name = "Player 1"
            ) {}
        )
    }
}