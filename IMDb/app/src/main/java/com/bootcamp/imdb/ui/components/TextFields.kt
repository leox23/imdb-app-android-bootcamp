package com.bootcamp.imdb.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.White_Smoke

@Composable
fun TextInput(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {

    Label(label)

    TextField(
        value = value,
        onValueChange = onValueChanged,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
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
    if (visualTransformation == PasswordVisualTransformation()) {
        ForgotPass()
        Spacer(modifier = Modifier.size(20.dp))
    }
}


@Preview(
    name = "TextField component",
    showBackground = true,
)
@Composable
fun TextInputPreview() {
    TextInput("Nombre usuaruo", "ingresa texto", {})
}


@Composable
fun TextInputOutlined(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    isPass: Boolean = false,
    hideText: Boolean = false,
    hideTextSwitch: () -> Unit = {}
) {

    OutlinedTextField(
        label = { Text(label) },
        value = value,
        onValueChange = onValueChanged,
        keyboardOptions = FieldCheckIsPass().keyboardOptions(isPass),
        visualTransformation = FieldCheckIsPass().visualTransformation(isPass, hideText),
        trailingIcon = { FieldEyeIconHideText(isPass, hideText, hideTextSwitch) },
        modifier = Modifier
            .fillMaxWidth()
            .size(82.dp)
            .padding(0.dp, 4.dp),

        shape = RoundedCornerShape(12.dp)
    )

    if (isPass) {
        Text(
            stringResource(R.string.password_must_contain_8_characters),
            color = Charcoal,
            style = MaterialTheme.typography.subtitle2
        )
        Spacer(modifier = Modifier.size(40.dp))
    }
}


@Preview(
    name = "TextFieldOutline component",
    showBackground = true,
)
@Composable
fun TextFieldOutlinePreview() {
    TextInputOutlined("Nombre Usuario", "", {})
}

class FieldCheckIsPass {
    fun keyboardOptions(isPass: Boolean): KeyboardOptions {
        return if (isPass) {
            KeyboardOptions(keyboardType = KeyboardType.Password)
        } else {
            KeyboardOptions.Default
        }
    }

    fun visualTransformation(isPass: Boolean, hideText: Boolean): VisualTransformation {
        return if (isPass) {
            if (hideText) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }
        } else {
            VisualTransformation.None
        }
    }
}

@Composable
fun FieldEyeIconHideText(isPass: Boolean, hideText: Boolean, hideTextSwitch: () -> Unit = {}) {
    if (isPass) {
        IconButton(onClick = { hideTextSwitch() }) {
            val vector = painterResource(
                if (hideText) R.drawable.eye_invisible
                else R.drawable.eye
            )
            val description =
                if (hideText) stringResource(R.string.hide_pass) else stringResource(R.string.reveal_pass)
            Icon(painter = vector, contentDescription = description)
        }
    }
}