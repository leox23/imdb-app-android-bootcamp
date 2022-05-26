package com.example.imdb.ui.components

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.imdb.navigation.OthersViews
import com.example.imdb.ui.theme.Mustard
import kotlinx.coroutines.delay


@Composable
fun SplashIntro(navController : NavController) {
    val scaleAnimation: Animatable<Float, AnimationVector1D> = remember { Animatable(initialValue = 0f) }

    Animation(
        navController = navController,
        scaleAnimation = scaleAnimation,
        delayScreen = 3000L,
        durationMillisAnimation = 1500
    )
    DesignSplashScreen(
        scaleAnimation = scaleAnimation
    )
}

@Composable
fun Animation(
    scaleAnimation: Animatable<Float, AnimationVector1D>,
    navController: NavController,
    durationMillisAnimation: Int,
    delayScreen: Long
) {

    LaunchedEffect(key1 = true) {
        scaleAnimation.animateTo(
            targetValue = 0.5F,
            animationSpec = tween(
                durationMillis = durationMillisAnimation,
                easing = {
                    OvershootInterpolator(3F).getInterpolation(it)
                }
            )
        )
        delay(timeMillis = delayScreen)

        navController.navigate(route = OthersViews.Login.route) {
            popUpTo(route = OthersViews.Splash.route) {
                inclusive = false
            }
        }
    }
}
@Composable
fun DesignSplashScreen(
    modifier: Modifier = Modifier,
    scaleAnimation: Animatable<Float, AnimationVector1D>
) {

        Column (
            Modifier.background(Mustard)
        ) {
            Text("IMDb",
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.Center),
                style = MaterialTheme.typography.h1,
            )
    }
}






@Composable
fun Logo(){ //no es roboto, buscar fuente correcta
    Text(
        text = "IMDb", // todo aqui tengo que reutilizar el componente que voy a utilizar en el splash
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        style = MaterialTheme.typography.h2

    )
}

@Composable
fun LogoSmall(){ //no es roboto, buscar fuente correcta
    Text(
        text = "IMDb", // todo aqui tengo que reutilizar el componente que voy a utilizar en el splash
        textAlign = TextAlign.Start,
        modifier = Modifier
            .background(Mustard, shape = RoundedCornerShape(8.dp))
            .padding(14.dp, 2.dp),
        style = MaterialTheme.typography.h3

    )
}


