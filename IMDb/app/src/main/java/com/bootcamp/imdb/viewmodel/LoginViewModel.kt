package com.bootcamp.imdb.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel



class LoginViewModel : ViewModel() {
    //state
    var text by mutableStateOf("")
    var password by mutableStateOf("")

    //events
    fun onTextChange(newString : String){
        text = newString
    }

    fun onPasswordChange(newString : String){
        password = newString
    }
}