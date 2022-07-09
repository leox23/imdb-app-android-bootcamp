package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Grey
import com.bootcamp.imdb.ui.theme.Mustard
import com.bootcamp.imdb.ui.theme.White_Smoke

@Composable
fun LoginButton(label: String, enabled : Boolean, onClickAction: () -> Unit) {
    Button(
        onClick = onClickAction,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(
                elevation = 15.dp,
            ),
        enabled = enabled,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Grey,
            contentColor = White_Smoke,
            disabledContentColor = White_Smoke,
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
fun FollowListButton(text: String = "Empieza tu lista de Seguimiento") {
    Button(
        onClick = {},
        Modifier
            .padding(0.dp, 30.dp)
            .fillMaxWidth()
            .height(50.dp)
            .padding(30.dp, 0.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Mustard,
            contentColor = Charcoal
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
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