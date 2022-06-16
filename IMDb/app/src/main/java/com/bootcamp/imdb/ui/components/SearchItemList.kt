package com.bootcamp.imdb.ui.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.R

@Composable
fun SearchItemList(){
    Row {
        Image(painter = painterResource(R.drawable.info_icon),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp, 140.dp)
        )

        Column() {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchItemListPreview(){
    SearchItemList()
}