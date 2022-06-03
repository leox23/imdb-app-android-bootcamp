package com.bootcamp.imdb.ui.screens.main_screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.theme.IMDbTheme
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.components.FollowListButton
import com.bootcamp.imdb.ui.components.TitleSection
import com.bootcamp.imdb.ui.components.TitleSectionPreview
import com.bootcamp.imdb.ui.theme.White_Smoke

@Composable
fun UserScreen() {
    Column (Modifier
        .fillMaxWidth()){
        Row {
            Image(
                painter = painterResource(R.drawable.eye_invisible),
                contentDescription = "Image User",
            modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = "Juan Perez",
             style = MaterialTheme.typography.body2)
            Image(painter = painterResource(R.drawable.ic_google_logo),
                contentDescription = "Config User")

        }

        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp
        )
        /*
        ######################################################################
          aqui debe ir el carousel, lo dejo para despues
######################################################################
*/

        Spacer(
            Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(White_Smoke))
    Column(){
        TitleSection(label = "Lista de seguimiento")
        // tener un componente de texto que se pueda usar en estos casos
        Text(text = "Crear una lista de seguimiento para no perderte nunguna pelicula o serie de TV")
        FollowListButton()

    }

        Spacer(
            Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(White_Smoke))

        TitleSection(label = "Vistas recientes")
        Text(text = "No has visitado ninguna pagina recientemente")

        Spacer(
            Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(White_Smoke))
        TitleSection("Vistas recientes")
        Text(text = "N has visitado ninguna pagina recientemente")

        Spacer(
            Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(White_Smoke))
        TitleSection(label = "Personas Favoritas")
        Text(text = "Aun no tienes personas favoritas")
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    IMDbTheme {
        UserScreen()
    }
}

