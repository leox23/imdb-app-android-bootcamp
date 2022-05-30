package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.R


@Composable
fun Trailer() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .padding(0.dp, 0.dp, 0.dp, 20.dp)
    ) {
        Row(modifier = Modifier //el video
            .fillMaxWidth()
            .height(225.dp)
            .background(color = Color.Blue)) {
            Image(painter =
            painterResource(id = R.drawable.ic_launcher_background),
                contentDescription ="texto de prueba",
                modifier = Modifier
                    .fillMaxSize())
        }
        Row(modifier = Modifier // la imagen portada
            .padding(26.dp, 0.dp, 0.dp, 0.dp)
            .size(width = 140.dp, height = 190.dp)
            .background(color = Color.Red)
            .align(Alignment.BottomStart)) {
            Image(painter =
            painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription ="texto de prueba",
                modifier = Modifier
                    .fillMaxSize())
        }
        Column(modifier = Modifier // titulo y descripcion
            .padding(166.dp, 0.dp, 0.dp, 0.dp)
            .size(width = 226.dp, height = 75.dp)
            .background(color = Color.Yellow)
            .align(Alignment.BottomStart)) {
            Text(text = "Texto titulo",
                modifier = Modifier.padding(8.dp,8.dp,0.dp,0.dp))
            Text(text = "Mi texto descripcion",
                modifier = Modifier.padding(8.dp,8.dp,0.dp,0.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TrailerPreview(){
    Trailer()
}