package com.example.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.imdb.R
import com.example.imdb.ui.theme.White_Smoke


@Composable
fun LoginAppleAccount() {
    val image: Painter = painterResource(id = R.drawable.ic_apple_logo)
    Image(painter = image,
        contentDescription = "",
        modifier = Modifier
            .padding(9.dp)
            .size(62.dp)
            .clip(CircleShape)
            .background(White_Smoke)
            .padding(14.dp)
    )
}

@Composable
fun LoginFacebookAccount() {
    val image: Painter = painterResource(id = R.drawable.ic_facebook_logo)
    Image(painter = image,
        contentDescription = "",
        modifier = Modifier
            .padding(9.dp)
            .size(62.dp)
            .clip(CircleShape)
            .background(White_Smoke)
            .padding(14.dp)
    )
}

@Composable
fun LoginGoogleAccount() {
    val image: Painter = painterResource(id = R.drawable.ic_google_logo)
    Image(painter = image,
        contentDescription = "",
        modifier = Modifier
            .padding(9.dp)
            .size(62.dp)
            .clip(CircleShape)
            .background(White_Smoke)
            .padding(14.dp)
    ) // todo el icono de google se ve mas pequeño, porque parte del icono es relleno blanco
}