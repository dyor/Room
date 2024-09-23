package com.example.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hole(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val number: Int,
    val difficulty: Int
)