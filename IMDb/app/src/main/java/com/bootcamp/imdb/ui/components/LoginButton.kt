package com.bootcamp.imdb.ui.components

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.theme.Grey
import com.bootcamp.imdb.ui.theme.White_Smoke


@Composable
fun LoginButton(label:String, onClickAction: () -> Unit) {
    Button(
       onClick = onClickAction,
       modifier =  Modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(
                elevation = 15.dp,
            ),
        enabled = true,
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
