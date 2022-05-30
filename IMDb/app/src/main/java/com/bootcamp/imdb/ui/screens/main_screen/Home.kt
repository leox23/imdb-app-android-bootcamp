package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bootcamp.imdb.ui.components.Trailer
import com.bootcamp.imdb.ui.theme.IMDbTheme

@Composable
fun HomeScreen() {
    Trailer()
}

@Preview()
@Composable
fun HomeScreenPreview() {
    IMDbTheme {
        HomeScreen()
    }
}
