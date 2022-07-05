package com.bootcamp.imdb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers():List<User>

    @Query("Select * From user WHERE email LIKE :mail")
    suspend fun getUserByEmail(mail : String) :User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user:User)
}