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
import androidx.compose.ui.graphics.Color.Companion.White
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
import com.bootcamp.imdb.model.ModelConstant.EMPTY_RESOLVED
import com.bootcamp.imdb.navigation.BottomBarScreen
import com.bootcamp.imdb.ui.components.*
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Grey
import com.bootcamp.imdb.viewmodel.MovieDetailViewModel

@Composable
fun MovieDetail(
    navArgumentMovieId : String?,
    navController: NavController,
    vm : MovieDetailViewModel
    ) {
    val r = vm.MovieDetailResolved
    if (r == EMPTY_RESOLVED){
        vm.apiCallDetailMovie(navArgumentMovieId!!.toInt())
    }
    
    Column(
        Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar(
            backgroundColor = White,
            navigationIcon = {
                IconButton(
                    onClick = { navController.navigate(BottomBarScreen.Search.route)
                    }) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_left),
                        contentDescription = stringResource(R.string.back_button))
                       }
            },
            title = {
                Text(
                    r.original_title,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(-(30.dp)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Charcoal
                ) }
        )

        DividerGrey()

        TitleSection(r.title)
        Column(
            Modifier
                .padding(40.dp, 0.dp, 0.dp, 0.dp)
                .offset(y = -(20).dp)
        ) {
            Text(
                "${r.original_title} (${stringResource(R.string.original_title)})",
                Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                style = MaterialTheme.typography.body1,
                color = Grey,
                fontSize = 10.sp
            )
            if (false){ // aun no he adaptado recibir series desde la api
                    Text( // condicional para no mostrar si no serie
                    "${stringResource(R.string.tv_series)} + /*todo ultima emision variable */ ",
                    style = MaterialTheme.typography.body1,
                    color = Grey,
                    fontSize = 12.sp
                )
            }
        }
        Box(
            modifier = Modifier
                .clickable { }
                .fillMaxWidth()
                .height(225.dp),
            contentAlignment = Alignment.Center
        ) {
            // trailer image
            AsyncImage(
                model = r.backdrop_path,
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
                model = r.poster_path,
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
                        r.genres,
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
                        text = r.vote_average, //todo rating a sacar de datos originales
                        Modifier.padding(4.dp, 0.dp)
                    )
                }
                Text(
                    r.overview,
                    Modifier.padding(0.dp, 16.dp),
                    lineHeight = 22.sp,
                    fontSize = 16.sp
                )
            }
        }

        DividerGrey()

        if (false){ //todo falta reimplementar las series pero llamando de api
            Row(
                Modifier
                    .clickable { }
                    .fillMaxWidth()
                    .padding(26.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    stringResource(R.string.episode_guide), //todo debe ser leida de variable, aplico cuando consuma api
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