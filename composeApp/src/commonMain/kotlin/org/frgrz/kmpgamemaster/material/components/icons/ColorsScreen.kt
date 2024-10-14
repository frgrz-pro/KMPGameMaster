package org.frgrz.kmpgamemaster.material.components.icons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

class ColorsScreen : Screen {

    @Composable
    override fun Content() {
        Scaffold(
            content = {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Primary",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onPrimary

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "OnPrimary",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.primary

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.secondary)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Secondary",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSecondary

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.onSecondary)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "OnSecondary",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.secondary

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.tertiary)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Tertiary",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onTertiary

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.onTertiary)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "OnTertiary",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.tertiary

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "PrimaryContainer",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onPrimaryContainer

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.onPrimaryContainer)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "OnPrimaryContainer",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.primaryContainer

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "SecondaryContainer",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSecondaryContainer

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "OnSecondaryContainer",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.secondaryContainer

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.tertiaryContainer)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "TertiaryContainer",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onTertiaryContainer

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.onTertiaryContainer)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "OnTertiaryContainer",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.tertiaryContainer

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surfaceBright)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "SurfaceBright",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSurface

                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.background)
                            .height(48.dp)
                    ) {
                        Text(
                            text = "SurfaceBright",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onBackground

                        )
                    }
                }
            }
        )
    }
}