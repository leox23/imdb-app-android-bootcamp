package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
    Column(
        Modifier
            .wrapContentHeight()
    ) {
        Trailer(thisViewModel.featuredMovie)
        SpacerGrey()
        TitleSection(stringResource(R.string.the_best_selections))
        Carousel(thisViewModel.peliculasMasPuntuadas)
        SpacerGrey()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    IMDbTheme {
        HomeScreen(viewModel())
    }
}
