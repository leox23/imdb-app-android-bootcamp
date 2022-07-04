package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.model.PeliculasMejorCalificadas

@Composable
fun Carousel(carouselItems: List<PeliculasMejorCalificadas>?) {
    Box {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                state = rememberLazyListState()
            ) {
                itemsIndexed(carouselItems ?: listOf()) { index, item ->
                    if (index <= 6){
                        Row {
                            Spacer(Modifier.width(24.dp))
                            MostVotedAverage(item)
                        }
                    }
                }
            }
        }
    }
}



@Preview
@Composable
fun CarouselPreview() {
    //Carousel()
}
