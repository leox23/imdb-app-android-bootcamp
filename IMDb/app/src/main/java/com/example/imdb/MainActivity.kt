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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Composable
fun Greeting() { // todo aun pendiente el splash
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
            .background(Color(0xFFF6C700)) // inconsistencia llamando mustard color de res
            .padding(  // todo colocar como variable accesible luego, para reutilizar en otros bloques de diseño
                50.dp,
                0.dp
            ),
        verticalArrangement = Arrangement.Center)
    {
        Logo()

        Column {
            Label("Usuario")
            TextField()
            Label("Constraseña")
            TextField()
            ForgotPass()
            Spacer(modifier = Modifier.size(20.dp))
            LoginButton()
        }

        Column (
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Spacer(modifier = Modifier.size(40.dp))
            Text(text = "Ó podes iniciar con",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 20.dp))
            //Spacer(modifier = Modifier.size(20.dp))
            Row {
                LoginAppleAccount()
                LoginFacebookAccount()
                LoginGoogleAccount()
            }
            Row (
                Modifier.padding(0.dp, 20.dp)
                    ){
                Text(text = "¿No tienes una cuenta",
                    style = MaterialTheme.typography.subtitle1)
                Spacer(modifier =  Modifier.width(10.dp))
                //todo este texto debe ser un textButton
                Text(text = "Registrate",
                    color = Color(R.color.charcoal),
                    style = MaterialTheme.typography.body2)
            }
            //todo este texto debe ser un textButton
            Text(text = "Continuar como invitado",
                style = MaterialTheme.typography.body2)
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
        //Logo()
    }
}

@Composable
fun Logo(){ //no es roboto, buscar fuente correcta
    Text(
        text = "IMDb", // todo aqui tengo que reutilizar el componente que voy a utilizar en el splash
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth().height(100.dp),
        style = MaterialTheme.typography.h1

    )
}

@Composable
fun Label(label : String) {
        Text(text = label,
            Modifier.padding(0.dp, 17.dp, 0.dp, 8.dp),
            color = Color(R.color.charcoal), //iel gris parece ser muy claro en conparacion al diseño, por modularizar el color
            style = MaterialTheme.typography.body2
        )
}

@Composable
fun TextField() {
    Column {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
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
fun ForgotPass() {
    TextButton(onClick = { /* aqui lo que colocare donde se recupera la contraseña*/ })
    {
        Text("¿Olvidaste tu contraseña?",
            color = Color(R.color.charcoal),
            style = MaterialTheme.typography.subtitle2
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
            style = MaterialTheme.typography.body2
       )
    }
}

@Composable
fun LoginAppleAccount() {
    val image: Painter = painterResource(id = R.drawable.ic_apple_logo)
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

@Composable
fun LoginFacebookAccount() {
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

@Composable
fun LoginGoogleAccount() {
    val image: Painter = painterResource(id = R.drawable.ic_google_logo)
    Image(painter = image,
        contentDescription = "",
        modifier = Modifier
            .padding(9.dp)
            .size(62.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFFFFF))
            .padding(14.dp)
    ) // todo el icono de google se ve mas pequeño, porque parte del icono es relleno blanco
}