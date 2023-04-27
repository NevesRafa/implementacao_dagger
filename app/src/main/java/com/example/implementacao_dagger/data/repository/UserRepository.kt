package com.example.implementacao_dagger.data.repository

import com.example.implementacao_dagger.data.model.UserDetails

interface UserRepository {

    suspend fun getUsers(): List<UserDetails>

    suspend fun addUser(user: UserDetails)
}