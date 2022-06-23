package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bootcamp.imdb.R
import com.bootcamp.imdb.model.Movie


@Composable
fun TitlePage( movie : Movie ) {
    Column(
        Modifier
            .clickable { }
            .shadow(1.dp)
            .background(Color.White)
            .width(124.dp)
            .wrapContentHeight()) {
        AsyncImage(
            model = movie.featuredImage,
            contentDescription = stringResource(R.string.cover_image),
            modifier = Modifier
                .size(124.dp, height = 186.dp)
        )
        Row(Modifier.padding(6.dp)) {
            AsyncImage(
                model = stringResource(R.string.yellow_star_icon),
                contentDescription = stringResource(R.string.image_star_rating),
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
            )
            Text(
                text = movie.rating.toString(),
                Modifier.padding(8.dp, 0.dp, 8.dp, 2.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(start = 8.dp)
                .height(22.dp)
        ) {
            Text(movie.title)
        }
        Row(
            modifier = Modifier // titulo y descripcion
                .padding(0.dp, 2.dp, 6.dp, 10.dp)
                .size(20.dp)
                .clip(CircleShape)
                .align(Alignment.End)
        ) {
            Image(
                painter = painterResource(R.drawable.info_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun TitlePagePreview() {
    //TitlePage(1)
}