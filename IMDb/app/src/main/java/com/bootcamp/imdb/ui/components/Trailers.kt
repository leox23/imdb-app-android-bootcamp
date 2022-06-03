package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bootcamp.imdb.R
import com.bootcamp.imdb.lorem.MovieProvider


@Composable
fun Trailer() {
    val title = MovieProvider.movieList[5].title
    val urlImage = MovieProvider.movieList[5].featuredImage
    val tumbnTrailer = "https://image.tmdb.org/t/p/w1280/g2djzUqA6mFplzC03gDk0WSyg99.jpg"
    Box(modifier = Modifier
        .padding(0.dp, 0.dp, 0.dp, 20.dp)
        .height(300.dp)
    ) {
        Column(modifier = Modifier //el video
            .fillMaxWidth()
            .height(225.dp)) {
            AsyncImage( model = tumbnTrailer,
                contentDescription ="Trailer de encanto",
                modifier = Modifier
                    .fillMaxSize())

        }
        Column(modifier = Modifier // titulo y descripcion
            .padding(40.dp, 0.dp, 0.dp, 0.dp)
            .size(width = 226.dp, height = 75.dp)
            .background(color = Color.Yellow)
            .align(Alignment.BottomEnd)) {
            Text(text = title,
                modifier = Modifier.padding(12.dp,8.dp,0.dp,0.dp),
                style = MaterialTheme.typography.body2)
            Text(text = "Encanto, te trasla...",
                modifier = Modifier.padding(12.dp,8.dp,0.dp,0.dp),
                style = MaterialTheme.typography.subtitle1)
        }
        Row(modifier = Modifier // la imagen portada
            .padding(26.dp, 118.dp, 0.dp, 0.dp)
            .size(width = 140.dp, height = 190.dp)
            .align(Alignment.BottomStart)) {
            AsyncImage(model = urlImage,
                contentDescription ="Portada de Encanto",
                modifier = Modifier
                    .fillMaxSize())
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TrailerPreview(){
    Trailer()
}