package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.theme.Grey

@Composable
fun SpacerGrey(){
    Spacer(
        Modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(Grey.copy(ContentAlpha.disabled))
    )
}

@Composable
fun SpacerWhite(){
    Spacer(
        Modifier
            .height(20.dp)
            .fillMaxWidth()
    )
}

@Composable
fun DividerGrey(){
    Divider(
        color = Grey.copy(alpha = ContentAlpha.disabled),
        modifier = Modifier
            .fillMaxWidth(),
        thickness = 1.dp
    )
}

@Composable
fun DividerAndPadding(){
    Spacer(
        Modifier
            .fillMaxWidth()
            .padding(0.dp, 7.dp))
    DividerGrey()
    Spacer(
        Modifier
            .fillMaxWidth()
            .padding(0.dp, 7.dp))
}