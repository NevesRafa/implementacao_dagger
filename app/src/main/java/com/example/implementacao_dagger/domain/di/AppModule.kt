package com.example.implementacao_dagger.domain.di

import android.content.Context
import androidx.room.Room
import com.example.implementacao_dagger.data.local.AppDatabase
import com.example.implementacao_dagger.data.local.UserDao
import com.example.implementacao_dagger.domain.repository.UserRepository
import com.example.implementacao_dagger.domain.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppContext(application: MyApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userDao)
    }
}