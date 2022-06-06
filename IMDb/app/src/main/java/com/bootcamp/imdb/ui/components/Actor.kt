package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.theme.Grey

@Composable
fun Actor(){
    Column(modifier = Modifier
        .width(100.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Actor de reparto",
            modifier = Modifier
                .padding(0.dp)
                .size(100.dp, 140.dp)
                .background(Color.Red)
        )
        Text(text = "Robert Downey Jr.",
             fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 6.dp, 6.dp, 2.dp)) // todo unificar con estilos globales, ver con que esta alineado en terminos de diseño
        Text(text = "Tony Stark",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Grey,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp, 6.dp, 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ActorPreview(){
    Actor()
}