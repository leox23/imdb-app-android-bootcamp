package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.components.Carousel
import com.bootcamp.imdb.ui.components.SpacerGrey
import com.bootcamp.imdb.ui.components.TitleSection
import com.bootcamp.imdb.ui.components.Trailer
import com.bootcamp.imdb.ui.theme.IMDbTheme

@Composable
fun HomeScreen() {
    Column(
        Modifier
            .padding(0.dp, 0.dp, 0.dp, 20.dp)
    ) {
        Trailer()
        SpacerGrey()
        TitleSection("Las mejores selecciones")
        Carousel()
        SpacerGrey()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    IMDbTheme {
        HomeScreen()
    }
}
