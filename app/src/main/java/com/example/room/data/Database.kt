package com.example.room.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Golfer::class], version = 1)
abstract class GolferDatabase : RoomDatabase() {
    abstract fun golferDao(): GolferDao
}

@Database(entities = [Hole::class], version = 1)
abstract class HoleDatabase : RoomDatabase() {
    abstract fun holeDao(): HoleDao
}