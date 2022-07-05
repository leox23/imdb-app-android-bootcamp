package com.bootcamp.imdb.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bootcamp.imdb.database.User

class RegisterViewModel : ViewModel(){
    var textName by mutableStateOf("")
    var textEmail by mutableStateOf("")
    var password by mutableStateOf("")
    val isPass = true
    var hidePassIcon by mutableStateOf(true)

    //para probar Room
    var user = User(
        0,
        "Leonel",
        "leox-23@hotmail.com",
        "Passmio2"
    )

    fun takeNewUserData() : User {
        user = User(
            name = textName,
            email = textEmail,
            password = password
        )
        return user as User
    }

    fun onTextNameChange(newString : String){
        textName = newString
    }

    fun onTextEmailChange(newString : String){
        textEmail = newString
    }

    fun onPasswordChange(newString : String){
        password = newString
    }

    fun hidePassIconSwitch(){
        hidePassIcon = !hidePassIcon
    }
}