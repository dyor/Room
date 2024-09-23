package com.example.room.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GolferDao {
    @Query("SELECT * FROM golfer")
    fun getAll(): List<Golfer>

    @Query("SELECT * FROM golfer WHERE id IN (:golferIds)")
    fun loadAllByIds(golferIds: IntArray): List<Golfer>

    @Query("SELECT * FROM golfer WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Golfer

    @Insert
    fun insertAll(golfers: List<Golfer>)

    @Delete
    fun delete(golfer: Golfer)
}

@Dao
interface HoleDao {
    @Query("SELECT * FROM hole")
    fun getAll(): List<Hole>

    @Query("SELECT * FROM hole WHERE id IN (:holeIds)")
    fun loadAllByIds(holeIds: IntArray): List<Hole>

    @Query("SELECT * FROM hole WHERE number LIKE :holeNumber LIMIT 1")
    fun findByName(holeNumber: Int): Hole

    @Insert
    fun insertAll(holes: Hole)

    @Delete
    fun delete(hole: Hole)
}