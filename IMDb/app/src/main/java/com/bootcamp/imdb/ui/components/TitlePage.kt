package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bootcamp.imdb.R
import com.bootcamp.imdb.lorem.MovieProvider.Companion.movieList


@Composable
fun TitlePage(position : Int){//todo es el mismo tamaño que se usa en la portadaimagen del trailer
    val title = movieList[position].title
    val urlImage = movieList[position].featuredImage
    val rating = movieList[position].rating.toString()
    Column(Modifier
        .shadow(2.dp)
        .padding(12.dp)
        .background(Color.White)
        .width(124.dp)
        .wrapContentHeight()){
        AsyncImage(
            model = urlImage,
            contentDescription ="imagen portada",
            modifier = Modifier
                .size(124.dp, height = 186.dp)
                .background(color = Color.Red))
        Row(Modifier.padding(6.dp)) {
            Image(painter =
            painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription ="texto de prueba",
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(color = Color.Green)
            )
            Text(text = rating,
                Modifier.padding(8.dp,0.dp,0.dp,2.dp))
        }
        Row(modifier = Modifier
            .background(color = Color.Yellow)
            .padding(start = 8.dp)
            .height(22.dp)) {
            Text(title)
        }
        Row(modifier = Modifier // titulo y descripcion
            .padding(0.dp, 2.dp, 6.dp, 10.dp)
            .size(20.dp)
            .clip(CircleShape)
            .background(color = Color.Black)
            .align(Alignment.End)) {
            Image(
                painter =
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "texto de prueba",
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black),
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun TitlePagePreview(){
    TitlePage(1)
}