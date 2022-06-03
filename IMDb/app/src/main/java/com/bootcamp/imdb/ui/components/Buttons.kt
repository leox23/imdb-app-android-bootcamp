package com.bootcamp.imdb.ui.components

import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Grey
import com.bootcamp.imdb.ui.theme.Mustard
import com.bootcamp.imdb.ui.theme.White_Smoke

@Composable
fun LoginButton(label: String, onClickAction: () -> Unit) {
    Button(
        onClick = onClickAction,
        modifier = Modifier
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
    ) {
        Text(
            label,
            style = MaterialTheme.typography.body2
        )
    }
}

@Preview(
    name = "LoginButton component",
    showBackground = true,
)
@Composable
fun LoginButtonPreview() {
   // LoginButton("Lorem"){}
}


@Composable
fun FollowListButton() {
    Button( onClick = {},
        Modifier
            .fillMaxWidth()
            .padding(30.dp,0.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        colors = ButtonDefaults.textButtonColors(
            // en el momento no recuerdo como usar res/value/colors.xml
            backgroundColor = Mustard,
            contentColor = Charcoal)
    ) {
        Text(text = "Empieza tu lista de seguimiento",
            style = MaterialTheme.typography.body2,
        )
    }
}
@Preview(
    name = "FollowListButton component",
    showBackground = true,
)
@Composable
fun FollowListButtonPreview() {
    FollowListButton()
}