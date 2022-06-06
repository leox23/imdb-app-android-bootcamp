package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Mustard

@Composable
fun Label(label: String) {
    Text(
        text = label,
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
        Text(
            "¿Olvidaste tu contraseña?",
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

@Composable
fun TitleSection(label: String) {
    Row(
        Modifier
            .padding(16.dp, 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            Modifier
                .size(8.dp, 36.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Mustard)
        )
        Text(
            text = label,
            Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 0.dp, 0.dp),
            style = MaterialTheme.typography.h4,
            letterSpacing = -(1.sp)
        )
    }
}

@Preview(
    name = "TitleSection component",
    showBackground = true,
)
@Composable
fun TitleSectionPreview() {
    TitleSection("Lorem Ipsun Dolor")
}