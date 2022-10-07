package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.theme.IMDbTheme

@Composable
fun PlayScreen() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.blocked),
            contentDescription = "interfaz no construida"
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
