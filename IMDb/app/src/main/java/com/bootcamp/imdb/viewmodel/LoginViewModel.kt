package com.bootcamp.imdb.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    //state
    var text by mutableStateOf("")
    var password by mutableStateOf("")
    var buttonEnabled by mutableStateOf(false)

    fun buttonState(){
       buttonEnabled = !(text == "" || password == "")
    }
    //events
    fun onTextChange(newString: String) {
        text = newString
        buttonState()
    }

    fun onPasswordChange(newString: String) {
        password = newString
        buttonState()
    }
}