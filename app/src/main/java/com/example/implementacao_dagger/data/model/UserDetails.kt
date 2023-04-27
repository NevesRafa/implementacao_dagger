package com.example.implementacao_dagger.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDetails(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var name: String
)