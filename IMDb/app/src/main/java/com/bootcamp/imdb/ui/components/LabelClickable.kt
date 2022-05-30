package com.bootcamp.imdb.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.theme.Charcoal

//todo pendiente por modificar recurso para quedar como componente (por ejemplo los textos clickables del login)
@Composable
fun LabelClickable(label: Int, destination: String) {
        TextButton(onClick = {}) {
            Text(
                stringResource(label),
                color = Charcoal,
                style = MaterialTheme.typography.body2
            )
        }
}

@Preview(
    name = "LabelClickable component",
    showBackground = true,
)
@Composable
fun LabelClickablePreview() {
    LabelClickable(R.string.register,"")
}

