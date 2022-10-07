package com.bootcamp.imdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object {
        @Volatile private var instance : UserDatabase? = null

        fun getInstance(context : Context) : UserDatabase {
            return instance ?: synchronized(this){
                instance ?: buidDatabase(context).also { instance = it}
            }
        }

        private fun buidDatabase(context : Context) : UserDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "userDatabase"
            ).build()
        }
    }

}