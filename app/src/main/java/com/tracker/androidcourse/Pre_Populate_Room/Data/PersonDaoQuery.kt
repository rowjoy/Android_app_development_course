package com.tracker.androidcourse.Pre_Populate_Room.Data


import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface  PersonDaoQuery{
    @Query("SELECT * FROM appuser")
    fun  readAll(): Flow<List<PersonModel>>
}