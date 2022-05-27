package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.theme.Charcoal

@Composable
fun Label(label : String) {
    Text(text = label,
        Modifier.padding(0.dp, 17.dp, 0.dp, 8.dp),
        color = Charcoal, //iel gris parece ser muy claro en conparacion al diseño, por modularizar el color
        style = MaterialTheme.typography.body2
    )
}


@Composable
fun ForgotPass() { // de esta quiza podemos hacer una sola
    TextButton(onClick = { /* aqui lo que colocare donde se recupera la contraseña*/ })
    {
        Text("¿Olvidaste tu contraseña?",
            color = Charcoal,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

