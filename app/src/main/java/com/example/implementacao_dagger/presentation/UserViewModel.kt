package com.example.implementacao_dagger.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.implementacao_dagger.data.model.UserDetails
import com.example.implementacao_dagger.domain.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val userLiveData = MutableLiveData<UserState>()

    fun addName(name: UserDetails) {
        viewModelScope.launch {
            val addUser = userRepository.addUser(name)
            userLiveData.postValue(UserState.SuccessAddName(addUser))
            getUsers()
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            val getUsers = userRepository.getUsers()
            userLiveData.postValue(UserState.SuccessList(getUsers))
        }
    }
}