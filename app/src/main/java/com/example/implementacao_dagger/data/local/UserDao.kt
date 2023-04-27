package com.example.implementacao_dagger.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.implementacao_dagger.data.model.UserDetails


@Dao
interface UserDao {

    @Query("SELECT * FROM UserDetails")
    fun getUsers(): List<UserDetails>

    @Insert
    fun save(user: UserDetails)
}
