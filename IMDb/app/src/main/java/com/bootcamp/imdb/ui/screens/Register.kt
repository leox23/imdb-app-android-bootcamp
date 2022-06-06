package com.bootcamp.imdb.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.R
import com.bootcamp.imdb.navigation.BottomBarScreen
import com.bootcamp.imdb.ui.components.*

@Composable
fun Register(navController: NavController) {
    Column( //todo falta el boton de atras que va arriba a la izquierda
        Modifier.padding(50.dp, 40.dp), //todo pendiente por colocar en dimen
        horizontalAlignment = Alignment.Start
    ) {
        LogoSmall()
        Spacer(Modifier.height(38.dp))
        Text(stringResource(R.string.create_an_account))
        TextFieldOutline(stringResource(R.string.name))
        TextFieldOutline(stringResource(R.string.email))
        PassFieldOutline()
        LoginButton(stringResource(R.string.accept), onClickAction = {
            navController.navigate(BottomBarScreen.Home.route)
        })
    }
}

@Preview(
    name = "Register component",
    showBackground = true,
)
@Composable
fun RegisterPreview() {
    Register(navController = rememberNavController())
}