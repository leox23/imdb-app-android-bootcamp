package com.bootcamp.imdb.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.R
import com.bootcamp.imdb.navigation.BottomBarScreen
import com.bootcamp.imdb.navigation.OthersViews
import com.bootcamp.imdb.ui.components.*
import com.bootcamp.imdb.ui.theme.*

@Composable
fun StandartLogin(navController: NavController){
    Column (
        Modifier
            .fillMaxHeight()
            .background(Mustard)
            .padding(  // todo colocar como variable accesible luego, para reutilizar en otros bloques de diseño
                50.dp,
                0.dp
            ),
        verticalArrangement = Arrangement.Center)
    {
        Logo()

        Column {
            Label(stringResource(R.string.user))
            TextField()
            Label(stringResource(R.string.password))
            TextField()
            ForgotPass()
            Spacer(modifier = Modifier.size(20.dp))
            LoginButton(
                stringResource(R.string.login),
                onClickAction = {
                    navController.navigate(BottomBarScreen.Home.route)
                })
        }

        Column (
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Spacer(modifier = Modifier.size(40.dp))
            Text(text = stringResource(R.string.or_login_with),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 20.dp))
            //Spacer(modifier = Modifier.size(20.dp))
            Row {
                LoginOtherAccount(painterResource(R.drawable.ic_apple_logo), "Cuenta de Apple")
                LoginOtherAccount(painterResource(R.drawable.ic_facebook_logo), "Cuenta de Facebook")
                LoginOtherAccount(painterResource(R.drawable.ic_google_logo), "Cuenta de Google"){
                    //navController.navigate(OthersViews.Register.route)
                    //aqui el login de google
                }
            }
            Row (
                Modifier.padding(0.dp, 20.dp)
            ){
                Text(text = stringResource(R.string.you_do_not_have_an_account),
                    style = MaterialTheme.typography.subtitle1)
                Spacer(modifier =  Modifier.width(10.dp))
                //todo pendiente por crear recurso de texto clickable
                Text(text = stringResource(R.string.register),
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            role = Role.Button
                        ){
                            navController.navigate(OthersViews.Register.route)
                        },
                    color = Charcoal,
                    style = MaterialTheme.typography.body2)
            }
            //todo falta este por aplicarle el efecto del click
            Text(text = stringResource(R.string.continue_as_a_guest),
                modifier = Modifier
                    .padding(0.dp,0.dp,0.dp, 30.dp) // trabajarlo general como una unidad para todos los elementos finales
                    .clickable(
                        enabled = true,
                        role = Role.Button
                    ){
                        navController.navigate(BottomBarScreen.Home.route)
                    },
                    style = MaterialTheme.typography.body2,
            )
        }
    }
}

@Preview(
    name = "StandartLogin component",
    showBackground = true,
)
@Composable
fun StandartLoginPreview() {
    StandartLogin(navController = rememberNavController())
}