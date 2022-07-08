package com.bootcamp.imdb.repository

import com.bootcamp.imdb.App
import com.bootcamp.imdb.database.User
import com.bootcamp.imdb.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDatabaseRepository {

    suspend fun getUser(userMail : String) : User?{
        return UserDatabase.getInstance(App.getContext()).userDao().getUserByEmail(userMail)
    }
    suspend fun addNewUserDB (user : User){
            UserDatabase.getInstance(App.getContext()).userDao().addUser(user)
    }
}