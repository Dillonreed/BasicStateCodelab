package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    Column(modifier = modifier) {
        if (count > 0) Text(text = "You've had $count glasses")
        Button(
            onClick = { count++ },
            enabled = count < 10,
            modifier = Modifier
        ) { Text(text = "Add glass") }
    }
}

@CustomPreview
@Composable
fun WaterCounterPreview() {
    BasicStateCodelabTheme {
        WaterCounter()
    }
}
