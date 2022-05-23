package com.example.imdb.ui.start_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.imdb.ui.components.LoginButton
import com.example.imdb.ui.components.LogoSmall
import com.example.imdb.ui.components.PassFieldOutline
import com.example.imdb.ui.components.TextFieldOutline


@Composable
fun Register(){
    Column (
        Modifier.padding(50.dp,40.dp), // pendiente por colocar en dimen
        horizontalAlignment = Alignment.Start
    ) {
        LogoSmall()
        Spacer(Modifier.height(38.dp))
        Text("Crear una cuenta")
        TextFieldOutline("Nombre")
        TextFieldOutline("Correo Electronico")
        PassFieldOutline()
        LoginButton("Aceptar")
    }
}

