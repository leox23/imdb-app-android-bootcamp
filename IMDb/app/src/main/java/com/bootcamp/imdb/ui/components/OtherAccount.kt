package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.theme.White_Smoke

@Composable
fun LoginOtherAccount(logo : Painter, description : String, onClick: () -> Unit = {}) {
    Image(
        painter = logo,
        contentDescription = description,
        modifier = Modifier
            .padding(9.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .shadow(elevation = 10.dp, shape = CircleShape)
            .size(62.dp)
            .background(White_Smoke)
            .padding(14.dp),
    )
}

@Preview(
    name = "LoginOtherAccount component",
    showBackground = true,
)
@Composable
fun LoginOtherAccountPreview() {
    LoginOtherAccount(painterResource(R.drawable.ic_google_logo), "Cuenta de Google")
}