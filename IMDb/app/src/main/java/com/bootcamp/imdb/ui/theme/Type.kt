package com.bootcamp.imdb.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bootcamp.imdb.R

val shadowColor = Grey

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
    h1 = TextStyle( //splash
        fontFamily = Milford,
        fontSize = 125.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = -(8.sp),
        shadow = Shadow(
            color = shadowColor,
            offset = Offset(12f, 12f),
            blurRadius = 16f
        )
    ),
    h2 = TextStyle(
        fontFamily = Milford,
        fontSize = 80.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = -(6.sp),
        shadow = Shadow(
            color = shadowColor,
            offset = Offset(10f, 10f),
            blurRadius = 10f
        )
    ),
    h3 = TextStyle(
        fontFamily = Milford,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = -(4.sp),
        shadow = Shadow(
            color = shadowColor,
            offset = Offset(8f, 8f),
            blurRadius = 12f
        )
    ),
    h4 = TextStyle(
        fontFamily = Roboto,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        /*
        shadow = Shadow(
            color = shadowColor,
            offset = Offset(8f, 8f),
            blurRadius = 12f
        )
        */
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        shadow = Shadow(
            color = shadowColor,
            offset = Offset(6f, 10f),
            blurRadius = 6f
        )
    ),
    subtitle1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Light,
        fontSize = 17.sp
    ),
    subtitle2 = TextStyle( //texto olvide mi contraseña
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