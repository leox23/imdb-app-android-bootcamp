package com.example.imdb.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.imdb.R
import com.example.imdb.ui.theme.Charcoal


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
        //Text("The textfield has this text: " + textState.value.text) // como obtener este valor
    }
}


@Composable
fun TextFieldOutline(label : String) {
    var name by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = name,
        onValueChange = { name = it },
        Modifier
            .fillMaxWidth()
            .size(82.dp)
            .padding(0.dp, 4.dp),
        label = { Text(label) }
    )
}



@Composable
fun PassFieldOutline() {
    var password by remember { mutableStateOf("") }
    var hidden by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp, 0.dp, 0.dp),
        label = { Text(stringResource(R.string.password)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = { hidden = !hidden }) {
                val vector = painterResource(
                    if (hidden) R.drawable.eye_invisible
                    else R.drawable.eye
                )
                val description = if (hidden) stringResource(R.string.hide_pass) else stringResource(R.string.reveal_pass)
                Icon(painter = vector, contentDescription = description)
            }
        }
    )
    Text(stringResource(R.string.password_must_contain_8_characters),
        color = Charcoal,
        style = MaterialTheme.typography.subtitle2)
    Spacer(modifier = Modifier.size(40.dp))
}
