package com.example.room.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Golfer(
    //add a unique identifier that is auto populated
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val bumps: Int,
    var wins: Int,
)