package com.example.imdb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.imdb.ui.theme.Mustard


@Composable
fun Logo(){ //no es roboto, buscar fuente correcta
    Text(
        text = "IMDb", // todo aqui tengo que reutilizar el componente que voy a utilizar en el splash
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        style = MaterialTheme.typography.h2

    )
}


@Composable
fun Greeting() { // todo aun pendiente el splash
    Column (
        Modifier.background(Mustard)
    ) {
        Text("IMDb",
            Modifier.fillMaxWidth()
                .fillMaxHeight()
                .wrapContentSize(Alignment.Center),
            style = MaterialTheme.typography.h1
        )

    }
}

