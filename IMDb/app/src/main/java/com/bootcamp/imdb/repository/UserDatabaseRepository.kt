package com.bootcamp.imdb.repository

import android.app.Application
import android.content.Context
import com.bootcamp.imdb.database.User
import com.bootcamp.imdb.database.UserDatabase

class UserDatabaseRepository {

    suspend fun getUser(userMail : String) : User?{
        return UserDatabase.getInstance(App.getContext()).userDao().getUserByEmail(userMail)
    }
    suspend fun addNewUserDB (user : User){
            UserDatabase.getInstance(App.getContext()).userDao().addUser(user)
    }
}

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        App.setContext(this)
    }

    companion object {
        private lateinit var application: Application

        private fun setContext(app : App){
            App.application = app
        }

        fun getContext() : Context {
            return application
        }
    }
}