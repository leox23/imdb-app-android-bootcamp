package com.example.imdb.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.imdb.R

val Roboto = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_regular, FontWeight.W400), // Regular
    Font(R.font.roboto_light_italic, FontWeight.Light) // Light Italic
)

val Milford = FontFamily(
    Font(R.font.milford_black, FontWeight.Bold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle( //logo parece no funcionar con este metodo
        fontFamily = Milford,
        fontSize = 80.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = -(6.sp)
    ),

    body2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Light,
        fontSize = 17.sp
    ),
    subtitle2 = TextStyle( //olvide mi contra
        fontFamily = Roboto,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)