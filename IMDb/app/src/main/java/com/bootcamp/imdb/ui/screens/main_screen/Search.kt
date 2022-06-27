package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.components.DividerAndPadding
import com.bootcamp.imdb.ui.components.DividerGrey
import com.bootcamp.imdb.ui.components.SearchItemList
import com.bootcamp.imdb.ui.theme.IMDbTheme
import com.bootcamp.imdb.viewmodel.SearchViewModel


@Composable
fun SearchScreen(
    navController: NavController,
    thisViewModel: SearchViewModel
    ) {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = thisViewModel.search,
            placeholder = {
                Text(text = stringResource(R.string.search_on_imdb))
            },
            onValueChange = { thisViewModel.onSearchChange(it) },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon),
                    Modifier.size(30.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 16.dp),
            shape = RoundedCornerShape(12.dp),
            maxLines = 1
        )
        DividerGrey()
        if (thisViewModel.search != "") {
            LazyColumn(
                contentPadding = PaddingValues(12.dp)
            ) {
                itemsIndexed(thisViewModel.filteredMovies) { index, movie ->
                    SearchItemList(
                        movie,
                        navController,
                    )
                    DividerAndPadding()
                }

            }

        }
    }
}

@Preview()
@Composable
fun SearchScreenPreview() {
    IMDbTheme {
        val navController = rememberNavController()
        SearchScreen(navController,viewModel())
    }
}
