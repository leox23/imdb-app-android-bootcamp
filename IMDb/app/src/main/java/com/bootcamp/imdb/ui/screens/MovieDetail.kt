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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.bootcamp.imdb.R
import com.bootcamp.imdb.navigation.BottomBarScreen
import com.bootcamp.imdb.ui.components.DividerGrey
import com.bootcamp.imdb.ui.components.FollowListButton
import com.bootcamp.imdb.ui.components.SpacerGrey
import com.bootcamp.imdb.ui.components.TitleSection
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Grey

@Composable
fun MovieDetail() {
    val navController = rememberNavController()
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
            Row(Modifier
                .padding(20.dp, 0.dp)
                .clickable {
                    navController.navigate(BottomBarScreen.Home.route)
                }
                .padding(5.dp)
                .align(Alignment.CenterStart)) {
                Image(
                    painter = painterResource(R.drawable.arrow_left),
                    contentDescription = "Arrow Left",
                    modifier = Modifier
                        .size(24.dp)
                )
            }
            Text(
                "Queens gambit",
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

        TitleSection("Gambito de dama")
        Column(
            Modifier
                .padding(40.dp, 0.dp, 0.dp, 0.dp)
                .offset(y = -(20).dp)
        ) {
            Text(
                "The Queens Gambit (titulo original)",
                Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                style = MaterialTheme.typography.body1,
                color = Grey,
                fontSize = 10.sp
            )
            Text(
                "Miniserie de TV 2020 - 2020 16",
                style = MaterialTheme.typography.body1,
                color = Grey,
                fontSize = 12.sp
            )
        }
        Box(     // trailer
            modifier = Modifier
                .clickable{ }
                .fillMaxWidth()
                .height(225.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                "https://image.tmdb.org/t/p/w1280/4aTonMQCSEgu5PV3n3xRaNMZmG1.jpg",
                "imagen de trailer",
                modifier = Modifier
                    .fillMaxSize()
            )

            Image(
                painter = painterResource(R.drawable.ic_play_shape),
                contentDescription = "Play Shape",
                modifier = Modifier
                    .size(50.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 10.dp)
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w185_and_h278_bestv2/gKxPyeItCrOscP8On4y5sG3WY9A.jpg",
                contentDescription = "Actor de reparto",
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
                        "Drama",
                        Modifier
                            .size(72.dp, 32.dp)
                            .border(
                                BorderStroke(1.dp, Grey.copy(alpha = ContentAlpha.medium)),
                                RoundedCornerShape(4.dp)
                            )
                            .padding(0.dp, 6.dp, 0.dp, 0.dp),
                        textAlign = TextAlign.Center,
                        color = Grey.copy(alpha = ContentAlpha.medium),
                        lineHeight = 20.sp
                    )
                    AsyncImage(
                        model = "https://upload.wikimedia.org/wikipedia/commons/1/18/Estrella_amarilla.png", // todo pendiente por colocar en recursos
                        contentDescription = "Img estrella",
                        modifier = Modifier
                            .padding(12.dp, 0.dp, 0.dp, 0.dp)
                            .size(20.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "4.20",
                        Modifier.padding(4.dp, 0.dp)
                    )
                }
                Text(
                    "Beth Harmon, una huérfana de ocho años, " +
                            "es tranquila, hosca y, según todas las " +
                            "apariencias, poco llamativa.",
                    Modifier.padding(0.dp, 16.dp),
                    lineHeight = 22.sp,
                    fontSize = 16.sp
                )
            }
        }

        DividerGrey()
        Row(
            Modifier
                .clickable { }
                .fillMaxWidth()
                .padding(26.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Guia de espisodios",
                style = MaterialTheme.typography.h4,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Text(
                    "7 episodios",
                    color = Grey
                )
                Image(
                    painter = painterResource(R.drawable.ic_angle_bracket),
                    contentDescription = "Imager ver lista de episodios ",
                    modifier = Modifier
                        .padding(20.dp, 0.dp, 0.dp, 0.dp)
                        .size(20.dp)
                )
            }
        }
        DividerGrey()
        FollowListButton("Agregar a mi lista de seguimiento")
        SpacerGrey()
        TitleSection("Lorem ipsum dolor")
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailPreview() {
    MovieDetail()
}