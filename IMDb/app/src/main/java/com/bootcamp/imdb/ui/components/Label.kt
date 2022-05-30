package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.ui.theme.Charcoal

@Composable
fun Label(label : String) {
    Text(text = label,
        Modifier.padding(0.dp, 17.dp, 0.dp, 8.dp),
        color = Charcoal,
        style = MaterialTheme.typography.body2
    )
}

@Preview(
    name = "Label component",
    showBackground = true,
)
@Composable
fun LabelPreview() {
    Label("Lorem Ipsum")
}


@Composable
fun ForgotPass() {
    TextButton(onClick = { /*todo pendinte por construir y an recive args */ })
    {
        Text("¿Olvidaste tu contraseña?",
            color = Charcoal,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Preview(
    name = "ForgotPass component",
    showBackground = true,
)
@Composable
fun ForgotPassPreview() {
    ForgotPass()
}