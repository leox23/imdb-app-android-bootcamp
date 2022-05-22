package com.example.imdb.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun TextField() {
    Column {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        androidx.compose.material.TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                // todo aca tengo que aplicar el manejo de Material Theming
                // para que me reconosca los colores de recursos o de ui.theme
                // y para poder reutilizar de una sola fuente
                // de momento solo lo dejare asi para entregar el martes
                backgroundColor = Color(0xFFF5F5F5)
            )
        )
        Text("The textfield has this text: " + textState.value.text) // como obtener este valor
    }
}