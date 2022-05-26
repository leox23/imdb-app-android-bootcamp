package com.example.imdb.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.compose.rememberNavController
import com.example.imdb.ui.theme.Charcoal


//todo pendiente por modificar recurso para quedar como componente (por ejemplo los textos clickables del login)
@Composable
fun LabelClickable(label: Int, destination: String) {
    val navControler = rememberNavController()
        TextButton(onClick = { navControler.navigate(destination) }) {
            Text(
                stringResource(label),
                color = Charcoal,
                style = MaterialTheme.typography.body2
            )
        }

}

