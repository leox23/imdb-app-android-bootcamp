package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.R


@Composable
fun TitlePage(){//todo es el mismo tamaño que se usa en la portadaimagen del trailer
    Column() {
        Image( painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription ="texto de prueba",
            modifier = Modifier
                .size(width = 140.dp, height = 190.dp)
                .background(color = Color.Red))
        Row(Modifier.padding(6.dp)) {
            Image(painter =
            painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription ="texto de prueba",
                modifier = Modifier.size(26.dp)
            )
            Text(text = "4.5",
                Modifier.padding(8.dp,6.dp,0.dp,2.dp))
        }
        Row(modifier = Modifier
            .background(color = Color.Yellow)
            .padding(start = 8.dp)) {
            Text("Nombre peli")
        }
        Row(modifier = Modifier // titulo y descripcion
            .padding(0.dp, 2.dp, 6.dp, 10.dp)
            .size(20.dp)
            .background(color = Color.Black)
            .align(Alignment.End)) {
            Image(
                painter =
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "texto de prueba",
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black),
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun TitlePagePreview(){
    TitlePage()
}