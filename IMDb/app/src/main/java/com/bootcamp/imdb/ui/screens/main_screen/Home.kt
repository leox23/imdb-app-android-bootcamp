package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.components.Carousel
import com.bootcamp.imdb.ui.components.TitleSection
import com.bootcamp.imdb.ui.components.Trailer
import com.bootcamp.imdb.ui.theme.IMDbTheme
import com.bootcamp.imdb.ui.theme.White_Smoke

@Composable
fun HomeScreen() {
    Column(Modifier.padding(0.dp,0.dp,0.dp,20.dp)) {
        Trailer()
        Spacer(Modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(White_Smoke))
        TitleSection("Las mejores selecciones")
        Carousel()
        Spacer(Modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(White_Smoke))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    IMDbTheme {
        HomeScreen()
    }
}
