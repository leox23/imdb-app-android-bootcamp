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
import androidx.compose.ui.unit.dp
import com.example.imdb.ui.theme.White_Smoke

@Composable
fun LoginOtherAccount(logo : Painter, description : String) {
    Image(painter = logo,
        contentDescription = description,
        modifier = Modifier
            .padding(9.dp)
            .size(62.dp)
            .clip(CircleShape)
            .background(White_Smoke)
            .padding(14.dp)
    ) // todo el icono de google se ve mas pequeño, porque parte del icono es relleno blancom falta corregirlo
}