package com.bootcamp.imdb.screens

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
fun HomeScreen() {
    Column (Modifier.background(Color.Green)){
        Text(
            text = "Home",
            modifier = Modifier
                .size(110.dp),
        )
    }
}

@Preview()
@Composable
fun HomeScreenPreview() {
    IMDbTheme {
        HomeScreen()
    }
}
