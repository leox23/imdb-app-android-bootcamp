package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bootcamp.imdb.R


@Composable
fun Trailer(
    id: Int?,  //por si tengo que ir a la vista detalle desde aqui
    trailerImage: String,
    coverImage: String,
    titleTrailer: String,
    description: String
) {
    Box(
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 20.dp)
            .height(300.dp)
            .offset(y = -(2.dp))
    ) {
        Box(
            modifier = Modifier //el video
                .clickable { }
                .fillMaxWidth()
                .height(225.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = trailerImage,
                contentDescription = stringResource(R.string.trailer_image),
                modifier = Modifier
                    .fillMaxSize()
            )
            Image(
                painter = painterResource(R.drawable.ic_play_shape),
                contentDescription = stringResource(R.string.play_button),
                modifier = Modifier
                    .size(50.dp)
            )
        }
        Column(
            modifier = Modifier // titulo y descripcion
                .padding(40.dp, 0.dp, 0.dp, 0.dp)
                .size(width = 226.dp, height = 75.dp)
                .align(Alignment.BottomEnd)
        ) {
            Text(
                text = titleTrailer,
                modifier = Modifier.padding(12.dp, 8.dp, 0.dp, 0.dp),
                style = MaterialTheme.typography.body2
            )
            Text(
                text = description,
                modifier = Modifier.padding(12.dp, 8.dp, 0.dp, 0.dp),
                style = MaterialTheme.typography.subtitle1
            )
        }
        Row(
            modifier = Modifier // la imagen portada
                .padding(26.dp, 118.dp, 0.dp, 0.dp)
                .size(width = 140.dp, height = 190.dp)
                .align(Alignment.BottomStart)
        ) {
            AsyncImage(
                model = coverImage,
                contentDescription = stringResource(R.string.cover_image),
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TrailerPreview() {
    //Trailer()
}