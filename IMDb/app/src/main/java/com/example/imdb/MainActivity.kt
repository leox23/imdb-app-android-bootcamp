package com.example.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdb.ui.theme.IMDbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //backgroundColor(Color(R.color.mustard))
                    //color = MaterialTheme.colors.background
                ) {
                    //Greeting()
                    StandartLoginPreview()

                }
            }
        }
    }
}

val robotoFamily = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_regular, FontWeight.W400), // Regular
    Font(R.font.roboto_light_italic, FontWeight.Light) // Light Italic
)

@Composable
fun Greeting() {
    Text(text = "IMDb")
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IMDbTheme {
        Greeting()
    }
}


//todavia no se si esto se mostrara o no
//para seguir las convenciones de pascal case
@Composable
fun StandartLogin(){
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFFF6C700)) //inconsistencia llamando mustard color de res
            .padding(50.dp, 0.dp) //colocar como variable  luego, para reutilizar en otros bloques de diseño
        //colors = backgroundColor(Color(R.color.mustard))
    ){
        labelAndInput("Usuario")
        labelAndInput("Constraseña")
        forgotPass()
        Spacer( modifier = Modifier.size(40.dp))
        LoginButton()
    }
}

@Preview(showBackground = true)
@Composable
fun StandartLoginPreview() {
    IMDbTheme {
        StandartLogin()
        //labelAndInput("Usuario")
    }
}


@Composable
fun labelAndInput(label : String) {
    Column {
        Text(text = label,
            Modifier.padding(0.dp, 3.dp)
        )
        TextFieldDemo()
    }
}

@Composable
fun TextFieldDemo() {
    Column {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(R.color.white))
        )
        //Text("The textfield has this text: " + textState.value.text)
    }
}

@Composable
fun forgotPass() {
    TextButton(onClick = { /* Do something! */ })
    {
        Text("¿Olvidaste tu contraseña?",
            color = Color(R.color.grey)
            )
    }
}

@Composable
fun LoginButton() {
    Button(
        onClick = { /* aqui toca lo que hara cuando sepa */ },
        //fontSize = 20.dp,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.textButtonColors(
            // en el momento no recuerdo como usar res/value/colors.xml
        backgroundColor = colorResource(R.color.grey),
            contentColor = Color(R.color.white_smoke),
            disabledContentColor = Color(0xFFFFFFFF), //inconsistencia al intentar recibir desde recursos
        ),
        enabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text("Login",
            fontSize = 20.sp
       )
    }
}


