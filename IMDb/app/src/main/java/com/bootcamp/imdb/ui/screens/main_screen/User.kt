package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.theme.IMDbTheme
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.components.FollowListButton
import com.bootcamp.imdb.ui.components.SpacerGrey
import com.bootcamp.imdb.ui.components.SpacerWhite
import com.bootcamp.imdb.ui.components.TitleSection
import com.bootcamp.imdb.ui.screens.main_screen.UserThingsSavedProvider.Companion.thingsLists
import com.bootcamp.imdb.ui.theme.Black
import com.bootcamp.imdb.ui.theme.Grey

@Composable
fun UserScreen() {
    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 10.dp, 40.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Row(Modifier
                .clickable { }
                .padding(10.dp, 10.dp, 20.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.sample_user),
                    contentDescription = stringResource(R.string.image_user),
                    modifier = Modifier
                        .border(BorderStroke(1.dp, Black), RoundedCornerShape(20.dp))
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Text(
                    text = stringResource(R.string.name_user),
                    Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                    style = MaterialTheme.typography.body2,
                    )

            }
            Image(painter = painterResource(R.drawable.config_icon),
                modifier = Modifier
                    .clickable { }
                    .size(32.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentDescription = stringResource(R.string.user_config))

        }

        Divider(
            color = Grey.copy(alpha = ContentAlpha.disabled),
            modifier = Modifier
                .padding(20.dp, 10.dp, 20.dp, 20.dp)
                .fillMaxWidth(),
            thickness = 2.dp
        )

        CarouselThings()
        SpacerWhite()
        SpacerGrey()

        Column {
            TitleSection(stringResource(R.string.tracking_list))
            TextNormal(
                stringResource(R.string.create_a_watchlist_so_you_dont_miss_any_movie_or_tv_series),
                0.dp
            )
            FollowListButton()

        }

        SpacerGrey()
        TitleSection(stringResource(R.string.recent_views))
        TextNormal(stringResource(R.string.you_have_not_visited_any_pages_recently))
        SpacerGrey()

        TitleSection(stringResource(R.string.favorite_people))
        TextNormal(stringResource(R.string.you_dont_have_favorite_people_yet))
        SpacerGrey()
    }
}

@Composable
fun TextNormal(text: String, paddingBotton: Dp = 20.dp) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp, 0.dp, 0.dp, paddingBotton),
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun CarouselThings() {
    val items = (0..2).map { it }
    Box {
        BoxWithConstraints(
            modifier =
            Modifier.fillMaxWidth()
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp),
                state = rememberLazyListState()
            ) {
                itemsIndexed(items) { index, item ->
                    Spacer(Modifier
                        .size(12.dp,150.dp)
                    )
                    CarouselCard(item)
                }
            }
        }
    }
}

/*
######################################################################
  Cards y sus datos
######################################################################
*/
@Composable
fun CarouselCard(index: Int) {
    val title = thingsLists[index].title
    val attr = thingsLists[index].attr
    val amount = thingsLists[index].amount.toString()
    //todo - no entiendo porque en el vista previa se ve bien, pero dentro de la app en el emulador se ve mal
    Card(
        modifier = Modifier
            .clickable { }
            .shadow(
                1.dp,
                RoundedCornerShape(8.dp),
                true
            )
            .padding(12.dp)
            .size(152.dp, 136.dp)
    ) {
        Column {
            Text(
                title,
                Modifier
                    .size(152.dp, 80.dp)
                    .background(Grey.copy(ContentAlpha.disabled))
                    .padding(10.dp),
                style = MaterialTheme.typography.caption
            )
            Text(
                attr,
                style = MaterialTheme.typography.caption
            )
            Text(
                amount,
                style = MaterialTheme.typography.caption,
                color = Grey,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    IMDbTheme {
        UserScreen()
    }
}

data class UserThingsSaved(
    val title: String,
    val attr: String,
    val amount: Int
)

sealed class UserThingsSavedProvider {
    companion object {
        val thingsLists = listOf(
            UserThingsSaved(
                "Calificar y obtener recomendaciones",
                "Calificaciones",
                0
            ),
            UserThingsSaved(
                "Agregar a Listas",
                "Listas",
                4
            ),
            UserThingsSaved(
                "Aun pendientes",
                "Comentarios",
                0
            )
        )
    }

}

