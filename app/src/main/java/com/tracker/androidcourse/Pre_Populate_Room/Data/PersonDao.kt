package com.tracker.androidcourse.Pre_Populate_Room.Data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface  PersonDao {
    @Query("SELECT * FROM appuser")
    fun  readAll(): Flow<List<Person>>
}