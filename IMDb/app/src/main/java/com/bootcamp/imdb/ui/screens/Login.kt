package com.bootcamp.imdb.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.App
import com.bootcamp.imdb.R
import com.bootcamp.imdb.database.UserDatabase
import com.bootcamp.imdb.navigation.BottomBarScreen
import com.bootcamp.imdb.navigation.OthersViews
import com.bootcamp.imdb.repository.UserDatabaseRepository
import com.bootcamp.imdb.ui.components.*
import com.bootcamp.imdb.ui.theme.*
import com.bootcamp.imdb.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun StandartLogin(navController: NavController, thisViewModel : LoginViewModel = viewModel()) {
    Column(
        Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(Mustard)
            .padding(  // todo colocar como variable accesible luego, para reutilizar en otros bloques de diseño
                50.dp,
                0.dp
            ),
        verticalArrangement = Arrangement.Center
    )
    {
        Logo()
        Column {
            TextInput(
                label = stringResource(R.string.user),
                value = thisViewModel.text,
                onValueChanged = {thisViewModel.onTextChange(it)}
            )
            TextInput(
                label = stringResource(R.string.password),
                value = thisViewModel.password,
                onValueChanged = {thisViewModel.onPasswordChange(it)},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            LoginButton(
                stringResource(R.string.login),
                onClickAction = {
                    navController.navigate(BottomBarScreen.Home.route)
/* probando room
                    CoroutineScope(Dispatchers.IO).launch {
                        val db = UserDatabase.getInstance(App.getContext())
                        val temp = db.userDao().getUserByEmail("leox-23@hotmail.com")
                        Log.d("usuario jalado", temp.toString())
                    }
 */
                })

        }

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Spacer(modifier = Modifier.size(40.dp))
            Text(
                text = stringResource(R.string.or_login_with),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 20.dp)
            )
            //Spacer(modifier = Modifier.size(20.dp))
            Row {
                LoginOtherAccount(
                    painterResource(R.drawable.ic_apple_logo),
                    "Cuenta de Apple")
                LoginOtherAccount(
                    painterResource(R.drawable.ic_facebook_logo),
                    "Cuenta de Facebook"
                )
                LoginOtherAccount(
                    painterResource(R.drawable.ic_google_logo),
                    "Cuenta de Google") {
                    //navController.navigate(OthersViews.Register.route)
                    //aqui el login de google
                }
            }
            Row(
                Modifier.padding(0.dp, 20.dp)
            ) {
                Text(
                    text = stringResource(R.string.you_do_not_have_an_account),
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.width(10.dp))
                //todo pendiente por crear recurso de texto clickable
                Text(
                    text = stringResource(R.string.register),
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            role = Role.Button
                        ) {
                            navController.navigate(OthersViews.Register.route)
                        },
                    color = Charcoal,
                    style = MaterialTheme.typography.body2
                )
            }
            Text(
                text = stringResource(R.string.continue_as_a_guest),
                modifier = Modifier
                    .padding(
                        0.dp,
                        0.dp,
                        0.dp,
                        30.dp
                    ) // trabajarlo general como una unidad para todos los elementos finales
                    .clickable(
                        enabled = true,
                        role = Role.Button
                    ) {
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
    StandartLogin(navController = rememberNavController(),LoginViewModel())
}