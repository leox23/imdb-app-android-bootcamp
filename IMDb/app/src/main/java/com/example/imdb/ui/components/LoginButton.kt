package com.example.imdb.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.imdb.ui.theme.Grey
import com.example.imdb.ui.theme.White_Smoke


@Composable
fun LoginButton(label:String) {
    Button(
        onClick = { /*todo aqui toca lo que hara cuando sepa que toca*/ },
        Modifier
            .fillMaxWidth()
            .height(60.dp),
        false,
        //fontSize = 20.dp,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.textButtonColors(
            // en el momento no recuerdo como usar res/value/colors.xml
            backgroundColor = Grey,
            contentColor = White_Smoke,
            disabledContentColor = White_Smoke, //inconsistencia al intentar recibir desde recursos
        ),
    ){
        Text(label,
            style = MaterialTheme.typography.body2
        )
    }
}
