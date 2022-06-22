package com.bootcamp.imdb.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.bootcamp.imdb.R
import com.bootcamp.imdb.navigation.BottomBarScreen
import com.bootcamp.imdb.ui.components.DividerGrey
import com.bootcamp.imdb.ui.components.FollowListButton
import com.bootcamp.imdb.ui.components.SpacerGrey
import com.bootcamp.imdb.ui.components.TitleSection
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Grey
import com.bootcamp.imdb.viewmodel.MovieDetailViewModel

@Composable
fun MovieDetail(
    string : String?,
    navController: NavController,
    movie : MovieDetailViewModel
    ) {

    movie.onMovieSearchResultClick(string!!.toInt())

    Column(
        Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp)
                .height(30.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(Modifier //todo flecha y barra deberia ser hecho en scaffold
                .padding(20.dp, 0.dp)
                .clickable {
                    navController.navigate(BottomBarScreen.Search.route)
                }
                .padding(5.dp)
                .align(Alignment.CenterStart)) {
                Image(
                    painter = painterResource(R.drawable.arrow_left),
                    contentDescription = stringResource(R.string.back_button),
                    modifier = Modifier
                        .size(24.dp)
                )
            }
            Text(
                movie.originalTitle, //todo recortar titulo a solo 26 caracteres, titulos largos soperponen el boton atras
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Charcoal
            )
        }
        DividerGrey()

        TitleSection(movie.title)
        Column(
            Modifier
                .padding(40.dp, 0.dp, 0.dp, 0.dp)
                .offset(y = -(20).dp)
        ) {
            Text(
                "${movie.originalTitle} (${stringResource(R.string.original_title)})",
                Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                style = MaterialTheme.typography.body1,
                color = Grey,
                fontSize = 10.sp
            )
            if (movie.isSerie == true){
                Text( //todo condicional para no mostrar si es serie
                    "${stringResource(R.string.tv_series)} ${movie.emissionTime}",
                    style = MaterialTheme.typography.body1,
                    color = Grey,
                    fontSize = 12.sp
                )
            }
        }
        Box(     // trailer image
            modifier = Modifier
                .clickable { }
                .fillMaxWidth()
                .height(225.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = movie.trailerImage,
                stringResource(R.string.trailer_image),
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

        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 10.dp)
        ) {
            AsyncImage(
                model = movie.featuredImage,
                contentDescription = stringResource(R.string.cover_image),
                modifier = Modifier
                    .padding(0.dp)
                    .size(100.dp, 140.dp)
            )
            Column(
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        movie.genre,
                        Modifier
                            .height(32.dp)
                            .border(
                                BorderStroke(1.dp, Grey.copy(alpha = ContentAlpha.medium)),
                                RoundedCornerShape(4.dp)
                            )
                            .padding(6.dp, 4.dp),
                        textAlign = TextAlign.Center,
                        color = Grey.copy(alpha = ContentAlpha.medium),
                        lineHeight = 20.sp
                    )
                    AsyncImage( // todo estrella rating pendiente por colocar en recursos strings
                        model = stringResource(R.string.yellow_star_icon),
                        contentDescription = stringResource(R.string.image_star_rating),
                        modifier = Modifier
                            .padding(12.dp, 0.dp, 0.dp, 0.dp)
                            .size(20.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = movie.rating, //todo rating a sacar de datos originales
                        Modifier.padding(4.dp, 0.dp)
                    )
                }
                Text(
                    movie.description,
                    Modifier.padding(0.dp, 16.dp),
                    lineHeight = 22.sp,
                    fontSize = 16.sp
                )
            }
        }

        DividerGrey()

        if (movie.isSerie == true){
            Row(
                Modifier
                    .clickable { }
                    .fillMaxWidth()
                    .padding(26.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Guia de espisodios", //todo debe ser leida de variable, aplico cuando consuma api
                    style = MaterialTheme.typography.h4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Text(
                        "7 episodios", //todo igual que arriba
                        color = Grey
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_angle_bracket),
                        contentDescription = stringResource(R.string.see_list_of_episodes),
                        modifier = Modifier
                            .padding(20.dp, 0.dp, 0.dp, 0.dp)
                            .size(20.dp)
                    )
                }
            }
        }
        DividerGrey()
        FollowListButton(stringResource(R.string.add_to_my_watch_list))
        SpacerGrey()
        TitleSection(stringResource(R.string.lorem_ipsum_dolor))
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailPreview() {
    //val navController = rememberNavController()
    //MovieDetail(navController)
}