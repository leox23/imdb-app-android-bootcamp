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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.bootcamp.imdb.model.Movie
import com.bootcamp.imdb.model.Pelicula
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Grey

@Composable
fun SearchItemList(
    movie : Pelicula,
    navController: NavController,
) {
    Row(Modifier
        .clickable {
            navController.navigate("movieDetail/${movie.id}")
        }
    ){
        AsyncImage(
            "https://image.tmdb.org/t/p/w200" + movie.poster_path,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp, 140.dp)
        )

        Column(modifier = Modifier.padding(14.dp, 0.dp, 0.dp, 0.dp)) {
            Text(
                text = movie.title,
                Modifier.padding(0.dp, 14.dp, 0.dp, 8.dp),
                color = Charcoal,
                style = MaterialTheme.typography.body2
            )
            Text(
                movie.release_date.slice(0..3),
                style = MaterialTheme.typography.body1,
                color = Grey,
                fontSize = 18.sp
            )
            Text(
                movie.overview.slice(0..110) + "...",
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
    val navController = rememberNavController()
/*
    SearchItemList(
        "Godzilla vs Kong",
        2.5,
        "2022",
        "https://image.tmdb.org/t/p/w185_and_h278_bestv2/bnuC6hu7AB5dYW26A3o6NNLlIlE.jpg",
        "Godzilla es una pelicula que cuenta la pelea entre bla bla bla...",
        navController = navController
    )
*/
}