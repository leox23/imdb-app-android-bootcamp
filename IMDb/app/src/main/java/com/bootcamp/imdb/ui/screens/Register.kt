package com.bootcamp.imdb.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.R
import com.bootcamp.imdb.navigation.BottomBarScreen
import com.bootcamp.imdb.ui.components.LoginButton
import com.bootcamp.imdb.ui.components.LogoSmall
import com.bootcamp.imdb.ui.components.TextInputOutlined
import com.bootcamp.imdb.viewmodel.RegisterViewModel

@Composable
fun Register(navController: NavController, thisViewModel : RegisterViewModel = viewModel()) {
    Column(
        Modifier
            .padding(50.dp, 40.dp) //todo pendiente por colocar en dimen
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        LogoSmall()
        Spacer(Modifier.height(38.dp))
        Text(stringResource(R.string.create_an_account))
        TextInputOutlined(
            label = stringResource(R.string.name),
            value = thisViewModel.textName,
            onValueChanged = { thisViewModel.onTextNameChange(it) }
            )
        TextInputOutlined(
            label = stringResource(R.string.email),
            value = thisViewModel.textEmail,
            onValueChanged = { thisViewModel.onTextEmailChange(it) }
            )
        TextInputOutlined( //password
            label = stringResource(R.string.password),
            value = thisViewModel.password,
            onValueChanged = { thisViewModel.onPasswordChange(it) },
            isPass = thisViewModel.isPass,
            hideText = thisViewModel.hidePassIcon,
            hideTextSwitch = { thisViewModel.hidePassIconSwitch() }
        )
        LoginButton(stringResource(R.string.accept), true, onClickAction = {
            navController.navigate(BottomBarScreen.Home.route)
        })
    }
}

@Preview(
    name = "Register component",
    showBackground = true,
)
@Composable
fun RegisterPreview() {
    Register(navController = rememberNavController())
}