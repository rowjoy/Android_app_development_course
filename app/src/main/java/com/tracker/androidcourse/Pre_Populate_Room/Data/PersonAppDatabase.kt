package com.tracker.androidcourse.Pre_Populate_Room.Data


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonModel:: class], version = 1, exportSchema = false)

abstract  class PersonAppDatabase : RoomDatabase (){
    abstract  fun  PersonDaoQuery() : PersonDaoQuery
}