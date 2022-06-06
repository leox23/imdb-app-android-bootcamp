package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable //todo sera necesario usarlo en otra vista asi que debe recibir un parametro composable
fun Carousel() {
    val items = (1..10).map { it } //solo de prueba, luego buscare que sea random
    Box() {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState()
            ) {
                itemsIndexed(items) { index, item ->
                    Row {
                        Spacer(Modifier.width(24.dp))
                        TitlePage(index)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CarouselPreview() {
    Carousel()
}
