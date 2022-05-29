package com.bootcamp.imdb.ui.session

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bootcamp.imdb.R
import com.bootcamp.imdb.navigation.BottomBarScreen
import com.bootcamp.imdb.ui.components.LoginButton
import com.bootcamp.imdb.ui.components.LogoSmall
import com.bootcamp.imdb.ui.components.PassFieldOutline
import com.bootcamp.imdb.ui.components.TextFieldOutline


@Composable
fun Register(navController: NavController){
    Column (
        Modifier.padding(50.dp,40.dp), // pendiente por colocar en dimen
        horizontalAlignment = Alignment.Start
    ) {
        LogoSmall()
        Spacer(Modifier.height(38.dp))
        Text(stringResource(R.string.create_an_account))
        TextFieldOutline(stringResource(R.string.name))
        TextFieldOutline(stringResource(R.string.email))
        PassFieldOutline()
        LoginButton(stringResource(R.string.accept), onClickAction = {
            navController.navigate(BottomBarScreen.Home.route) })
    }
}

