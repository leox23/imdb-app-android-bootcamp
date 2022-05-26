package com.example.imdb.ui.start_app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imdb.BottomBar
import com.example.imdb.R
import com.example.imdb.ui.components.*
import com.example.imdb.ui.theme.*

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
            LoginButton(stringResource(R.string.login), onClickAction = { navController.navigate("register") })
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
                LoginOtherAccount(painterResource(R.drawable.ic_google_logo), "Cuenta de Google")
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
                            navController.navigate("register")
                        },
                    color = Charcoal,
                    style = MaterialTheme.typography.body2)
            }
            //todo falta este por aplicarle el efecto del click
            Text(text = stringResource(R.string.continue_as_a_guest),
                modifier = Modifier.padding(0.dp,0.dp,0.dp, 30.dp), // trabajarlo general como una unidad para todos los elementos finales
                style = MaterialTheme.typography.body2)
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun StandartLoginPreview() {
    IMDbTheme {
        StandartLogin()
    }
}
*/
