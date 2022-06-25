package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.components.Carousel
import com.bootcamp.imdb.ui.components.SpacerGrey
import com.bootcamp.imdb.ui.components.TitleSection
import com.bootcamp.imdb.ui.components.Trailer
import com.bootcamp.imdb.ui.theme.IMDbTheme
import com.bootcamp.imdb.viewmodel.HomeViewModel

@Composable
fun HomeScreen( thisViewModel : HomeViewModel) {
    if (thisViewModel.selectedHomeMovie == null) {
        thisViewModel.featuredHomeMovie()
        thisViewModel.carouselItems()
    }
    Column(
        Modifier
            .wrapContentHeight()
    ) {
        Trailer(
            thisViewModel.selectedHomeMovie,
            thisViewModel.trailerImage,
            thisViewModel.coverImage,
            thisViewModel.titleTrailer,
            thisViewModel.description
        )
        SpacerGrey()
        TitleSection(stringResource(R.string.the_best_selections))
        thisViewModel.carouselItems?.let { Carousel(it) }
        SpacerGrey() // todo inonsistencia en diseño, no hay suficiente espacio para jugar con padding para que sea mas distinguible la sombra inderior y la barra gris siguientem queda pendiente ajuztar
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    IMDbTheme {
        HomeScreen(viewModel())
    }
}
