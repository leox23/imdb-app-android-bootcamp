package com.bootcamp.imdb.ui.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.White_Smoke

@Composable
fun TextField() {
    Column {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
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
                backgroundColor = White_Smoke
            )
        )
        //Text("The textfield has this text: " + textState.value.text) // como obtener este valor
    }
}

@Preview(
    name = "TextField component",
    showBackground = true,
)
@Composable
fun TextFieldPreview() {
    TextField()
}


@Composable
fun TextFieldOutline(label: String) {
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

@Preview(
    name = "TextFieldOutline component",
    showBackground = true,
)
@Composable
fun TextFieldOutlinePreview() {
    TextFieldOutline("Lorem ipsum")
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
                val description =
                    if (hidden) stringResource(R.string.hide_pass) else stringResource(R.string.reveal_pass)
                Icon(painter = vector, contentDescription = description)
            }
        }
    )
    Text(
        stringResource(R.string.password_must_contain_8_characters),
        color = Charcoal,
        style = MaterialTheme.typography.subtitle2
    )
    Spacer(modifier = Modifier.size(40.dp))
}

@Preview(
    name = "PassFieldOutLine component",
    showBackground = true,
)
@Composable
fun PassFieldOutlinePreview() {
    PassFieldOutline()
}
