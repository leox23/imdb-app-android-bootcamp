package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.theme.IMDbTheme

@Composable
fun PlayScreen() {
    Column (Modifier.background(Color.Yellow)){
        Text(
            text = "Play",
            modifier = Modifier
                .size(110.dp),
        )
    }
}

@Preview()
@Composable
fun PlayScreenPreview() {
    IMDbTheme {
        PlayScreen()
    }
}
