package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Grey

@Composable
fun SearchItemList(
    image: String,
    title: String,
    year: String,
    description: String
) {
    Row(Modifier
        .clickable {}) {
        AsyncImage(
            image,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp, 140.dp)
        )

        Column(modifier = Modifier.padding(14.dp, 0.dp, 0.dp, 0.dp)) {
            Text(
                text = title,
                Modifier.padding(0.dp, 14.dp, 0.dp, 8.dp),
                color = Charcoal,
                style = MaterialTheme.typography.body2
            )
            Text(
                year,
                style = MaterialTheme.typography.body1,
                color = Grey,
                fontSize = 18.sp
            )
            Text(
                description,
                Modifier.padding(0.dp, 14.dp, 0.dp, 0.dp),
                style = MaterialTheme.typography.body1,
                color = Grey,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchItemListPreview() {
    SearchItemList(
        "https://image.tmdb.org/t/p/w185_and_h278_bestv2/bnuC6hu7AB5dYW26A3o6NNLlIlE.jpg",
        "Godzilla vs Kong",
        "2022",
        "Godzilla es una pelicula que cuenta la pelea entre bla bla bla..."
    )
}