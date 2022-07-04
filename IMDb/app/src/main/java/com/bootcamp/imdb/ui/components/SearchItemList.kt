package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.bootcamp.imdb.R
import com.bootcamp.imdb.api.ApiConstants.IMAGE_W200
import com.bootcamp.imdb.model.Peliculas
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Grey

@Composable
fun SearchItemList(
    movie : Peliculas,
    navController: NavController,
) {
    //habria que crear nuevo modelo para utilizar stringsAdapter, son bruscos los cambios al tipear, tiene que recalcular muy rapido, no le da tiempo y crashea.
    Row(Modifier
        .clickable {
            navController.navigate("movieDetail/${movie.id}")
        }
    ){
        AsyncImage(
            IMAGE_W200 + movie.poster_path,
            contentDescription = stringResource(R.string.cover_image),
            modifier = Modifier
                .size(100.dp, 140.dp)
        )

        Column(modifier = Modifier.padding(14.dp, 0.dp, 0.dp, 0.dp)) {
            Text(
                text = movie.title,
                Modifier
                    .padding(0.dp, 14.dp, 0.dp, 8.dp)
                    .height(20.dp),
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