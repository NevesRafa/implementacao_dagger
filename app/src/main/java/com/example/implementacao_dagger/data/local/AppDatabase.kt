package com.example.implementacao_dagger.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.implementacao_dagger.data.model.UserDetails

@Database(
    entities = [UserDetails::class],
    version = 1,
    exportSchema = true
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}