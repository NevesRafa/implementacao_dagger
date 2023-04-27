package com.example.implementacao_dagger.data.repository

import com.example.implementacao_dagger.data.local.UserDao
import com.example.implementacao_dagger.data.model.UserDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {

    override suspend fun getUsers(): List<UserDetails> {
        val users = withContext(Dispatchers.IO) {
            userDao.getUsers()
        }

        return users
    }

    override suspend fun addUser(user: UserDetails) {
        withContext(Dispatchers.IO) {
            userDao.save(user)
        }
    }
}