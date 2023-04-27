package com.example.implementacao_dagger.presentation

import com.example.implementacao_dagger.data.model.UserDetails

sealed class UserState {

    data class SuccessList(val response: List<UserDetails>) : UserState()

    data class SuccessAddName(val user: Unit) : UserState()
}