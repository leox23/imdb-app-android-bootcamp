package com.example.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
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


// El IDE me corrige de colocarlo camel case (no pascal case)
// segun entiendo las convenciones debe ser no pascal case
// en caso de que la funcion compuesta se muestre en pantalla
@Composable
fun StandartLogin(){
    Column (
        Modifier
            .fillMaxHeight()
            .background(Color(0xFFF6C700)) //inconsistencia llamando mustard color de res
            .padding(  // todo colocar como variable accesible luego, para reutilizar en otros bloques de diseño
                50.dp,
                0.dp
            ),
        verticalArrangement = Arrangement.Center)
    {
        Text(
            text = "IMDb",// todo aqui tengo que reutilizar el componente que voy a utilizar en el splash
            fontSize = 72.sp, // todo falta solucionar los de las fuentes
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Column {
            labelAndInput("Usuario")
            labelAndInput("Constraseña")
            forgotPass()
            Spacer(modifier = Modifier.size(20.dp))
            LoginButton()
        }

        Column (
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.size(40.dp))
            Text(text = "Ó podes iniciar con")
            Spacer(modifier = Modifier.size(30.dp))
            Row {
                LoginAnotherAccount()
                LoginAnotherAccount()
                LoginAnotherAccount()
            }
            Row {
                Text(text = "¿No tienes una cuenta")
                Spacer(modifier =  Modifier.width(10.dp))
                //todo este texto debe ser un textButton en negrita
                Text(text = "Registrate")
            }
            //todo este texto debe ser un textButton en negrita
            Text(text = "Continuar como invitado",
                modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StandartLoginPreview() {
    IMDbTheme {
        StandartLogin()
        //labelAndInput("Usuario")
        //loginAnotherAccount()
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
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.border(BorderStroke(0.dp, Color.Red)),
            colors = TextFieldDefaults.textFieldColors(
                // todo aca tengo que aplicar el manejo de Material Theming
                // para que me reconosca los colores de recursos o de ui.theme
                // y para poder reutilizar de una sola fuente
                // de momento solo lo dejare asi para entregar el martes
                backgroundColor = Color(0xFFFFFFFF)),
        )
        //Text("The textfield has this text: " + textState.value.text) // como obtener este valor
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
        onClick = { /*todo aqui toca lo que hara cuando sepa que toca*/ },
        Modifier
            .fillMaxWidth()
            .height(60.dp),
        false,
        //fontSize = 20.dp,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.textButtonColors(
            // en el momento no recuerdo como usar res/value/colors.xml
        backgroundColor = colorResource(R.color.grey),
            contentColor = Color(R.color.white_smoke),
            disabledContentColor = Color(0xFFFFFFFF), //inconsistencia al intentar recibir desde recursos
        ),
    ) {
        Text("Login",
            fontSize = 20.sp
       )
    }
}

@Composable
fun LoginAnotherAccount() {
    val image: Painter = painterResource(id = R.drawable.ic_facebook_logo)
    Image(painter = image,
        contentDescription = "",
        modifier = Modifier
            .padding(9.dp)
            .size(62.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFFFFF))
            .padding(14.dp)
    )
}

