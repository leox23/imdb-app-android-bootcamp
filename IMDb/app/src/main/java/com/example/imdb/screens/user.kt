package com.example.imdb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdb.ui.theme.IMDbTheme
import com.example.imdb.ui.components.*
import com.example.imdb.ui.theme.*

@Composable
fun UserScreen() {
    Column (Modifier
        .background(Color.Red)){
        Text(
            text = "USER",
            modifier = Modifier
                .size(110.dp),
        )
    }
}

@Preview()
@Composable
fun UserScreenPreview() {
    IMDbTheme {
        UserScreen()
    }
}

