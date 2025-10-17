package com.example.counterproject.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CounterScreen(modifier: Modifier) {
    var counter by remember { mutableIntStateOf(0) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { counter-- }, enabled = counter >= 1) {
                Text(text = "-")
            }

            AnimatedContent(
                contentAlignment = Alignment.Center,
                targetState = counter,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInVertically { -it }.togetherWith(slideOutVertically { it })
                    } else {
                        slideInVertically { it }.togetherWith(slideOutVertically { -it })
                    }
                }) { count ->
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "$count",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Button(onClick = { counter++ }) {
                Text("+")
            }
        }
    }
}