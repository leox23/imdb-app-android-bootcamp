package com.example.imdb.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.imdb.ui.components.*
import com.example.imdb.ui.theme.*

@Composable
fun StandartLogin(){
    Column (
        Modifier
            .fillMaxHeight()
            .background(Mustard) // inconsistencia llamando mustard color de res
            .padding(  // todo colocar como variable accesible luego, para reutilizar en otros bloques de diseño
                50.dp,
                0.dp
            ),
        verticalArrangement = Arrangement.Center)
    {
        Logo()

        Column {
            Label("Usuario")
            TextField()
            Label("Constraseña")
            TextField()
            ForgotPass()
            Spacer(modifier = Modifier.size(20.dp))
            LoginButton()
        }

        Column (
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Spacer(modifier = Modifier.size(40.dp))
            Text(text = "Ó podes iniciar con",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 20.dp))
            //Spacer(modifier = Modifier.size(20.dp))
            Row {
                LoginAppleAccount()
                LoginFacebookAccount()
                LoginGoogleAccount()
            }
            Row (
                Modifier.padding(0.dp, 20.dp)
            ){
                Text(text = "¿No tienes una cuenta",
                    style = MaterialTheme.typography.subtitle1)
                Spacer(modifier =  Modifier.width(10.dp))
                //todo este texto debe ser un textButton
                Text(text = "Registrate",
                    color = Charcoal,
                    style = MaterialTheme.typography.body2)
            }
            //todo este texto debe ser un textButton
            Text(text = "Continuar como invitado",
                modifier = Modifier.padding(0.dp,0.dp,0.dp, 30.dp), // trabajarlo general como una unidad para todos los elementos finales
                style = MaterialTheme.typography.body2)
        }
    }
}