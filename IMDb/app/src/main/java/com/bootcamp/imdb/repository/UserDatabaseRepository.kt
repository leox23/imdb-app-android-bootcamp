package com.bootcamp.imdb.repository

import com.bootcamp.imdb.App
import com.bootcamp.imdb.database.User
import com.bootcamp.imdb.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDatabaseRepository {
    suspend fun addNewUserDB (user : User){
        CoroutineScope(Dispatchers.IO).launch {
            UserDatabase.getInstance(App.getContext()).userDao().addUser(user)
        }
    }

    suspend fun getUser(userMail : String) : User?{
        return UserDatabase.getInstance(App.getContext()).userDao().getUserByEmail(userMail)
    }

}